import java.awt.Graphics;

class DiamondDingus extends Dingus {
    protected int radius;
    protected boolean filled; //true: filled, false: outline

    public DiamondDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        filled = random.nextBoolean();
        y = 2*x; //makes the length of the triangles 2 times the width of the triangle
    }

    @Override
    void draw(Graphics g) {
        //Defines x and y coordinates of the top triangle of the diamond
        int[] xPoints = {(x), (x + x/2), (x + x)};
        int[] yPoints = {y + y/2, y, y + y/2};
        //Defines x and y coordinates of the bottom triangle of the diamond
        int[] xPoints2 = {(x), (x + x/2), (x + x)};
        int[] yPoints2 = {y + y/2, y + y, y + y/2};
       
        //Creates the top triangle of the diamond
        g.setColor(color); //Creates random color
        if (filled) //if the triangle is filled draws filled triangle
            g.fillPolygon(xPoints, yPoints, 3);
        else //if the triangle is not filled draws outline triangle
            g.drawPolygon(xPoints, yPoints, 3);

        //Creates the bottom triangle of the diamond
        g.setColor(color); //Creates random color
        if (filled) //if the triangle is filled draws filled triangle
            g.fillPolygon(xPoints2, yPoints2, 3);
        else //if the triangle is not filled draws outline triangle
            g.drawPolygon(xPoints2, yPoints2, 3);
    }
}