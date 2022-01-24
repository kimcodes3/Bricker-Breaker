/* 
 * Execution: Brick
 * 
 * class for the brick object which has a location and number of hits 
 */

public class Brick {
    
    //fields
    public int hits; // number of hits a break can take before its destroyed
    public double x; // x coordinate 
    public double y; // y coordinate 
    public static double length = 0.03; // half length
    public static double height = 0.02; // half height
    
    /*
     * constructor 
     * input: double, double, int
     * output: void 
     * description: gives each brick a location and hit capacity
     */
    public Brick(double x, double y, int hits) {
        
        this.x = x;
        this.y = y; 
        this.hits = hits;
        
        
        
    }
    
    /*
     * input: none 
     * output: void 
     * description: draws brick using penn draw library
     */
    public void drawBrick() {
        PennDraw.setPenColor(PennDraw.BLUE); 
        PennDraw.filledRectangle(x, y, length, height);
    }
    
    public static void main(String[] args) {
        Brick brick = new Brick(0.5, 0.6, 3);
        brick.drawBrick();
        
    }
}