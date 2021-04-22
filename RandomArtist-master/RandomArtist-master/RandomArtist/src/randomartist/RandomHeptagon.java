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

class RandomHeptagon extends RandomShape {
    private int[] coordinateX = new int[7];
    private int[] coordinateY = new int[7];
    
    private int startX;
    private int startY;
    private int radius;
    
    public RandomHeptagon(int maxX, int maxY) {
        super(maxX, maxY);

        startX = random.nextInt(maxX);
        startY = random.nextInt(maxY);
        radius = random.nextInt(maxX/4);
        
        coordinateX[0] = startX;
        coordinateY[0] = startY - radius;
        
        coordinateX[1] = (int) (startX + radius*Math.cos(Math.toRadians(360/7)));
        coordinateY[1] = (int) (startY - radius*Math.sin(Math.toRadians(360/7)));
        
        coordinateX[2] = (int) (startX + radius*Math.cos(Math.toRadians((360/7)*2-90)));
        coordinateY[2] = (int) (startY + radius*Math.sin(Math.toRadians((360/7)*2-90)));
        
        coordinateX[3] = (int) (startX + radius*Math.cos(Math.toRadians((360/7)*3-90)));
        coordinateY[3] = (int) (startY + radius*Math.sin(Math.toRadians((360/7)*3-90)));
        
        coordinateX[4] = (int) (startX - radius*Math.cos(Math.toRadians((360/7)*3-90)));
        coordinateY[4] = (int) (startY + radius*Math.sin(Math.toRadians((360/7)*3-90)));
        
        coordinateX[5] = (int) (startX - radius*Math.cos(Math.toRadians((360/7)*2-90)));
        coordinateY[5] = (int) (startY + radius*Math.sin(Math.toRadians((360/7)*2-90)));
        
        coordinateX[6] = (int) (startX - radius*Math.cos(Math.toRadians((360/7))));
        coordinateY[6] = (int) (startY - radius*Math.sin(Math.toRadians((360/7))));
        
    }

    @Override
    void draw(Graphics g) {
        // Get a random color
        getRandomColor();
        
        // Set the color of the shape to 'color'
        g.setColor(color);
        
        g.drawPolygon(coordinateX, coordinateY, 7);
    }    
}
