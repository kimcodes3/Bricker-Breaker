/* 
 * Execution: Bar
 * 
 * creates a bar object that moves with user input
 */

public class Bar { 
    
    //fields 
    public double x; // x coordinate 
    public static double y = 0.08; //y coordinate (stays constant)
    public static double length = 0.08; // half length 
    public static double height = 0.02; // half height
    
    //constructor
    public Bar() {
        this.x = 0.5;
    }
    
    //methods 
    
    /*
     * input: none
     * output: void
     * description: x coordinate dependent on x coordinate of the mouse
     */
    public void move() {
        x = PennDraw.mouseX(); 
    }
    
    /*
     * input: none 
     * output: void
     * description: draws bars using penn draw library
     */
    public void drawBar() {
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.filledRectangle(x, y, length, height);
        
    }
    
    public static void main(String[] args) {
        Bar bar = new Bar();
        
        bar.move();
    }
    
}