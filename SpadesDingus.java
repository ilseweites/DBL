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
        int[] xPoints = {(x), (x + radius), (x + 2*radius)};
        int[] yPoints = {y + radius/2 , (y - radius/2) - (radius - radius/4), y + radius/2};
        int[] xPoints2 = {(x + radius/2), (x + radius), (x + radius + radius/2)};
        int[] yPoints2 = {(y + radius + radius/2), (y + radius/2), (y + radius + radius/2)};
        g.setColor(color);
        if (filled)
            g.fillArc(x, y, radius, radius, 0, 360);
        else
            g.drawArc(x, y, radius, radius, 0, 360);   
        
        g.setColor(color);
        if (filled)
            g.fillArc((x + radius), y, radius, radius, 0, 360);
        else
            g.drawArc((x + radius), y, radius, radius, 0, 360);

        g.setColor(color);
        if (filled)
            g.fillPolygon(xPoints, yPoints, 3);
        else 
            g.drawPolygon(xPoints, yPoints, 3);

        g.setColor(color);
        if (filled)
            g.fillPolygon(xPoints2, yPoints2, 3);
        else   
            g.drawPolygon(xPoints2, yPoints2, 3);
    }
}