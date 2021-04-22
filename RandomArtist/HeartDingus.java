/**
 * CircleDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author huub
 */

import java.awt.Graphics;

class HeartDingus extends Dingus {
    protected int radius;
    protected boolean filled; //true: filled, false: outline

    public HeartDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX/4);
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        //Defines x and y coordinates of the triangle of the heart
        int[] xPoints = {(x), (x + radius), (x + 2*radius)};
        int[] yPoints = {y + radius/2, (y + radius/2) + (radius + radius/4), y + radius/2};

        //Creates the left half circle of the heart
        g.setColor(color); //Creates random color
        if (filled) //if the circle is filled draws filled circle
            g.fillArc(x, y, radius, radius, 0, 180);
        else //if the circle is not filled draws outline circle
            g.drawArc(x, y, radius, radius, 0, 180);   
        
        //Creates the right half circle of the heart
        g.setColor(color); //Creates random color
        if (filled) //if the circle is filled draws filled circle
            g.fillArc((x + radius), y, radius, radius, 0, 180);
        else //if the circle is not filled draws outline circle
            g.drawArc((x + radius), y, radius, radius, 0, 180);

        //Creates the bottom triangle of the heart
        g.setColor(color); //Creates random color
        if (filled) //if the triangle is filled draws filled triangle
            g.fillPolygon(xPoints, yPoints, 3);
        else //if the triangle is not filled draws outline triangle
            g.drawPolygon(xPoints, yPoints, 3);
    }
}