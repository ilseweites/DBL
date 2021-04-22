/**
 * Author: Jan Heemstra & Olof Morra
 * Course: 2IP90
 */

package randomartist;

import java.awt.Graphics;

/**
 * simple example shape
 *
 * @author huub
 */

class RandomTriangle extends RandomShape {
    private int[] coordinateX = new int[3];
    private int[] coordinateY = new int[3];
    
    public RandomTriangle(int maxX, int maxY) {
        super(maxX, maxY);

        for(int i = 0; i < 3; i++) {
            coordinateX[i] = random.nextInt(maxX);
            coordinateY[i] = random.nextInt(maxY);
        }
    }

    @Override
    void draw(Graphics g) {
        // Get a random color
        getRandomColor();
        
        // Set the color of the shape to 'color'
        g.setColor(color);
        
        g.drawPolygon(coordinateX, coordinateY, 3);
    }    
}
