// TO BE COMPLETED 
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Dingus --  part of HA Random Artist
 * abstract class representing an arbitrary shape
 * @author huub
 */
abstract class Dingus {
    /** random generator to be used by all subclasses of Dingus 
     *  do not change
     */
    Random random = Painting.random;

    /** postion of the shape (upper left corner) **/
    protected int x, y;

    /** color used for drawing this shape **/
    protected Color color;

    /** maximal coordinates; drawing area is (0,0)- (maxX,maxY) **/
    int maxX, maxY;

    /**
     * initializes color and position to random values
     *
     * @param maxX, maxY - give maximum values for the position
     */    
     public Dingus(int maxX, int maxY) {
        this.maxX = maxX; this.maxY = maxY;
        // initialize to a random position
        x = random.nextInt((maxX - 75) + 1) + 75; //randomizes a x coordinate which is within the inner border of the card
        y = random.nextInt((maxY - 75) + 1) + 75; //randomizes a y coordinate which is within the inner border of the card
        // initialize to a random color
        // TODO
        //color consists of random rgb value between 0 and 255 and a random transparacy value between 0 and 255
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    abstract void draw(Graphics g);
}
