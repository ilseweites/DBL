/**
 * Author: Jan Heemstra & Olof Morra
 * Course: 2IP90
 */

package RC;

import java.awt.Graphics;

/**
 * simple example shape
 *
 * @author huub
 */

class RC extends RandomShape {
    private int radius;   
    private boolean fill; // filled or not?
    
    public RC(int maxX, int maxY) {
        super(maxX, maxY);

        radius = random.nextInt(maxX/4); // or something more sophisticated
        fill = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        // Get a random color
        getRandomColor();
        
        // Set the color of the shape to 'color'
        g.setColor(color);
        
        // The circle is filled or not
        if (fill) {
            g.fillArc(x, y, 2*radius, radius,0, 360);
        } else { 
            g.drawArc(x, y, 2*radius, radius,0, 360);
        }
    }    
}
