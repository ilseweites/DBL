/**
 * CircleDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author huub
 */

import java.awt.Graphics;

class JokerDingus extends Dingus {
    protected int radius;
    protected boolean filled; //true: filled, false: outline

    public JokerDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX/4);
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        //Defines the x and y coordinate of the top traingle of the diamond
        int[] xPoints = {x - radius/4, x, x+radius, x+radius+radius/4};
        int[] yPoints = {y + radius + radius/4, y + radius, y + radius, y + radius + radius/4};
        //Defines the x and y coordinate of the top traingle of the diamond
        int[] xPoints2 = {x, x, x+radius, x+radius};
        int[] yPoints2 = {y, y+radius/4, y+radius/4, y};
        //Defines the x and y coordinate of the top traingle of the diamond
        int[] xPoints3 = {x-radius/4, x, x+radius/3};
        int[] yPoints3 = {y-radius/3, y, y};
        //Defines the x and y coordinate of the top traingle of the diamond
        int[] xPoints4 = {x+radius/3, x+radius/2, x+radius/2+radius/6};
        int[] yPoints4 = {y, y-radius/3, y};
        //Defines the x and y coordinate of the top traingle of the diamond
        int[] xPoints5 = {x+radius/2+radius/6, x+radius, x+radius+radius/4};
        int[] yPoints5 = {y, y, y-radius/3};

        //Creates the left triangle on the crown of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the triangle is filled draws filled triangle
            g.fillPolygon(xPoints3, yPoints3, 3);
        else //if the triangle is not filled draws outline triangle
            g.drawPolygon(xPoints3, yPoints3, 3); 

        //Creates the left circle on the crown of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the circle is filled draws filled circle
            g.fillArc((x + radius/2 - radius/8), (y - radius/2), radius/4, radius/4, 0, 360);
        else //if the circle is not filled draws outline circle
            g.drawArc((x + radius/2 -radius/8), (y - radius/2), radius/4, radius/4, 0, 360);

        //Creates the middle circle on the crown of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the circle is filled draws filled circle
            g.fillArc((x + radius + radius/4 - radius/8), (y - radius/2), radius/4, radius/4, 0, 360);
        else //if the circle is not filled draws outline circle
            g.drawArc((x + radius + radius/4  - radius/8), (y - radius/2), radius/4, radius/4, 0, 360);

        //Creates the right circle on the crown of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the circle is filled draws filled circle
            g.fillArc((x - radius/4 - radius/8), (y - radius/2), radius/4, radius/4, 0, 360);
        else //if the circle is not filled draws outline circle
            g.drawArc((x - radius/4 - radius/8), (y - radius/2), radius/4, radius/4, 0, 360);

        //Creates the middle triangle on the crown of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the triangle is filled draws filled triangle
            g.fillPolygon(xPoints4, yPoints4, 3);
        else //if the triangle is not filled draws outline triangle
            g.drawPolygon(xPoints4, yPoints4, 3); 

        //Creates the right triangle on the crown of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the triangle is filled draws filled triangle
            g.fillPolygon(xPoints5, yPoints5, 3);
        else //if the triangle is not filled draws outline triangle
            g.drawPolygon(xPoints5, yPoints5, 3); 

        //Creates the top rectangle of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the rectangle is filled draws filled rectangle
            g.fillPolygon(xPoints2, yPoints2, 4);
        else //if the rectangle is not filled draws outline rectangle
            g.drawPolygon(xPoints2, yPoints2, 4);          
        
        //Creates the biggest circle in de middle of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the circle is filled draws filled circle
            g.fillArc(x, y, radius, radius, 0, 360);
        else //if the circle is not filled draws outline circle
            g.drawArc(x, y, radius, radius, 0, 360);   
        
        //Creates the parallellogram on the bottom of the joker
        g.setColor(color);//Creates random color
        if (filled) //if the parallellogram is filled draws filled parallellogram
            g.fillPolygon(xPoints, yPoints, 4);
        else //if the parallellogram is not filled draws outline parallellogram
            g.drawPolygon(xPoints, yPoints, 4);  
    }
}