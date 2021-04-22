import java.awt.Graphics;

class SpadesDingus extends Dingus {
    protected int radius;
    protected boolean filled; //true: filled, false: outline

    public SpadesDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX/4);
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        //
        int[] xPoints = {(x), (x + radius), (x + 2*radius)};
        int[] yPoints = {y + radius/2 , (y - radius/2) - (radius - radius/4), y + radius/2};
        int[] xPoints2 = {(x + radius/2), (x + radius), (x + radius + radius/2)};
        int[] yPoints2 = {(y + radius + radius/2), (y + radius/2), (y + radius + radius/2)};
        
        //Creates the left circle of the club
        g.setColor(color); //Creates random color
        if (filled) //if the circle is filled draws filled circle
            g.fillArc(x, y, radius, radius, 0, 360);
        else //if the circle is not filled draws outline circle
            g.drawArc(x, y, radius, radius, 0, 360);   
        
        //Creates the right circle of the club
        g.setColor(color); //Creates random color
        if (filled) //if the circle is filled draws filled circle
            g.fillArc((x + radius), y, radius, radius, 0, 360);
        else //if the circle is not filled draws outline circle
            g.drawArc((x + radius), y, radius, radius, 0, 360);

        //Creates top triangle
        g.setColor(color); //Creates random color
        if (filled) //if the triangle is filled draws filled triangle
            g.fillPolygon(xPoints, yPoints, 3);
        else //if the triangle is not filled draws outline triangle
            g.drawPolygon(xPoints, yPoints, 3);

        //Creates bottom triangle
        g.setColor(color); //Creates random color
        if (filled) //if the triangle is filled draws filled triangle
            g.fillPolygon(xPoints2, yPoints2, 3);
        else //if the triangle is not filled draws outline triangle
            g.drawPolygon(xPoints2, yPoints2, 3);
    }
}