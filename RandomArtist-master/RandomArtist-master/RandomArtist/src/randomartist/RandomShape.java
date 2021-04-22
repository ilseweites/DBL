package randomartist;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * the mother of all random shapes
 *
 * @author huub
 */

/**
 * Author: Jan Heemstra & Olof Morra
 * Course: 2IP90
 */

abstract class RandomShape {  
    static Random random = new Random();
    
    /** color used for drawing this shape **/
    protected Color color;  
    /** position of the shape (upper left corner) **/
    protected int x, y;  
    
    public RandomShape( int maxX, int maxY ) {
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);
        getRandomColor(); // Gives object a random color
    }
    
    protected void getRandomColor() {
        // Java 'Color' class takes 3 floats, from 0 to 1.
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        
        // We choose to also add transparancy
        float a = random.nextFloat();
        
        color = new Color(r, g, b, a);
    }
    
    abstract void draw(Graphics g);
}

