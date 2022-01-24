/* 
 * Execution: Ball
 * 
 * creates a ball object with set x and y coordinates / radius 
 */

public class Ball {
    
    //fields 
    public double x; //x coordinate
    public double y; //y coordinate 
    public double radius; //radius
    public static double vx = 0.001; //x velocity
    public static double vy = 0.01; //y velocity
     
    
    //constructor
    public Ball() {
        this.x = 0.5; 
        this.y = 0.12; 
        this.radius = 0.02; 
        
    }
 
    //methods 
    /*
     * input: none 
     * output: void
     * description: moves ball by the velocity and bounces the ball
     * on the walls
     */
    public void ballMove() {
            x += vx;
            y += vy; 
                
        if (x <= radius) {
           
            x = radius; 
            vx = -vx;  
        }
        
        if (x >= 1 - radius) {
            x = 1 - radius;
            vx = -vx;
            
        }
        
        if (y >= 1 - radius) {
            y = 1 - radius;
            vy = -vy; 
        }
    }
    /*
     * input: none 
     * output: none
     * description: draws ball using penn draw library
     */
    public void drawBall() {
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.filledCircle(this.x, this.y, this.radius); 
        
    }
    
    public static void main(String[] args) {
        Ball ball = new Ball();
        ball.drawBall();

        
    }
    
    
}