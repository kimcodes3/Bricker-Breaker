/* 
 * Execution: LinkedList
 * 
 * create a linked list class that implements the list interface
 * for a generic type 
 */

public class BrickBreaker {
    
    //fields 
    private Ball ball = new Ball(); // ball object 
    private Bar bar = new Bar(); // bar object 
    private int numLives = 3; //number of lives the user has 
    private LinkedList<Brick> brickList = new LinkedList<Brick>(); //linked list with brick objects inside
    //private int numTrue = 0; 
    private boolean startRound = false;
    private boolean firstTime = true;
    
    /*
     * input: none
     * output: void
     * description: creates a linked list of bricks with each row having 1 less 
     * hit capacity than the row before
     * 
     */
    
    public void buildBrick() {
        int hits = 3;
        for (double y = 0.9; y > 0.75; y -= 0.045) {
            for (double x = 0.1; x < 0.9; x += 0.065) {
                Brick temp = new Brick(x, y, hits);
                brickList.add(temp);
            }
            //System.out.println(hits);
            hits--;
        }  
    }
    
    /*
     * input: none
     * output: boolean
     * description: if the ball lands on the bar, method will return true
     * otherwise it will return false
     */
    public boolean barCollision() {
        
        boolean ballCollide = false;
        if ((ball.x >= bar.x - bar.length) && (ball.x <= bar.x + bar.length) 
                && ball.y - ball.radius <= bar.y + bar.height) {
            ball.y = 0.12;
            ballCollide = true;
            //numTrue++;
            //System.out.println(numTrue);
            
        }
        
        return ballCollide;
    }
    
    /*
     * input: none
     * output: void
     * description: if the ball passes the bar; the game will restart and the
     * user loses a life
     */
    public void loseLife() {
        
        if (ball.y + ball.radius < bar.y - bar.height) {
            
            startRound = false;
            ball.x = 0.5; 
            ball.y = 0.12;
            bar.x = 0.5;
            ball.vy = Math.abs(ball.vy);
            firstTime = true;
            
            numLives--;
            //System.out.println(numLives);
        }
        PennDraw.text(0.1, 0.2, "numLives: " + numLives);
        if (numLives <= 0) { 
            
            PennDraw.text(0.5, 0.5, "YOU LOSE!");
        } 
    }
    /*
     * input: none
     * ouput: void
     * description: if the ball collides with the brick, it will: change the ball's 
     * velocity, it will decrease the number of hits on that particular brick, and if
     * hits = 0 on that brick, it will be removed 
     */
    public void brickCollision() {
        LinkedList<Brick>.Node current = brickList.head;
        while (current != null) {
            //determines if the ball is within the area of a brick 
            if ((ball.x >= current.value.x - Brick.length) && 
                (ball.x <= current.value.x + Brick.length) 
                    && (ball.y >= current.value.y - Brick.height) 
                    && (ball.y <= current.value.y + Brick.height)) {
                ball.vy = -ball.vy;
                current.value.hits--;
                
            }
            if (current.value.hits == 0) {
                brickList.remove(brickList.indexOf(current.value));
                
            }
            current = current.next;
        }
    }
    
    /*
     * input: void
     * output: boolean
     * description: if the user destroys all of the bricks 
     * the method returns true
     */
    public boolean win() {
        if (brickList.isEmpty()) {
            PennDraw.text(0.5, 0.5, "You win, Thanks for Playing!"); 
            return true; 
        } else {
            return false; 
        }
    }
    
    /*
     * input: none 
     * output: void
     * description: as long has lives, this method will animate the whole game
     * this game will not begin until the user presses a key.
     */
    
    public void playGame() {
        
        PennDraw.enableAnimation(50); 
        
        while (numLives > 0) {
            this.ball.drawBall();
            this.bar.drawBar();
            // draws all the bricks in the game
            LinkedList<Brick>.Node current = brickList.head;
            while (current != null) {
                current.value.drawBrick();
                current = current.next;
            }
            
            //game starts when a key is typed
            if(PennDraw.hasNextKeyTyped()) {
                //System.out.print(PennDraw.hasNextKeyTyped());
                startRound = true; 
                PennDraw.nextKeyTyped();
                //System.out.print(PennDraw.hasNextKeyTyped());
            }
            
            
            if (startRound) {    
                ball.ballMove();
                bar.move();
                firstTime = false;
                
            }
            
            //if the ball hits the bar and its not the first time this game is ran 
            //then change the ball's velocity
            if (barCollision() && !firstTime) {
                ball.vy = -ball.vy;
            }
            
            //PennDraw.text(0.1, 0.2, "numLives: " + numLives);
            loseLife();
            brickCollision();
            PennDraw.advance(); 
            PennDraw.clear();
            
            if (win()) {
                PennDraw.disableAnimation(); 
            }  
        }
    }
    
    public static void main(String[] args) {
        BrickBreaker arkanoid = new BrickBreaker();
        arkanoid.buildBrick();
        arkanoid.playGame();
        
    }
}

