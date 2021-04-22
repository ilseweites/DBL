/*
 * part of HA Random artist
 * TO BE COMPLETED
 *
 * @author huub
 * @author kees
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Painting extends JPanel implements ActionListener {

   /*---- Randomness ----*/
    /** you can change the variable SEED if you like
     *  the same program with the same SEED will generate exactly the same sequence of pictures
     */
    final static long SEED = 37; // seed for the random number generator; any number works

    /** do not change the following two lines **/
    final static Random random = new Random( SEED ); // random generator to be used by all classes
    int numberOfRegenerates = 0;

   /*---- Screenshots ----
    * do not change
    */
    char current = '0';
    String filename = "randomshot_"; // prefix

   /*---- Dinguses ----*/
    ArrayList<Dingus> shapes = new ArrayList<Dingus>(); //arraylist in which the subclasses of dingus will be stored
    
    //...

    public Painting() {
        setPreferredSize(new Dimension(450, 800)); // make panel 450 by 800 pixels.
        //...
    }

    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g);     // clears the panel
        // draw all shapes
        
        //for all subclasses of individual shapes, the shape will be drawn
        for (Dingus shape : shapes){
            shape.draw(g); 
        }
    }

    /**
     * reaction to button press
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( "Regenerate".equals(e.getActionCommand()) ) {
            regenerate();
            repaint();
        } else { // screenshot
            saveScreenshot( this, filename+current++ ); // ++ to show of compact code :-)
        }
    }

    void regenerate() {
        numberOfRegenerates++; // do not change

        // clear the shapes list
        shapes.clear();

        // create random shapes
        int amount = random.nextInt(30); //creates random amount of shapes printed (of which the max is 30)
        shapes.add(new CardDingus(450, 800)); //creates card border of 450 by 800 pixels
        //creates at least 10 different shapes, up to the randomized amount which was given above
        for (int i = 0; i < 10 + amount; i++){
            int nextShape = random.nextInt(5); //the next shape is a random shape of the 5 preset shapes
            switch(nextShape) {
                case 0: shapes.add(new DiamondDingus(225, 575)); //if nextShape is 1 a diamond is printed
                    break; //breaks after printing one shape
                case 1: shapes.add(new SpadesDingus(225, 575)); //if nextShape is 2 spades are printed
                    break; //breaks after printing one shape
                case 2: shapes.add(new HeartDingus(225, 575)); //if nextShape is 3 a heart is printed
                    break; //breaks after printing one shape
                case 3: shapes.add(new ClubsDingus(225, 575)); //if nextShape is 4 clubs are printed
                    break; //breaks after printing one shape
                case 4: shapes.add(new JokerDingus(225, 575)); //if nextShape is 5 a joker is printed
                    break; //breaks after printing one shape
            }
        }
    }

    /** 
     * saves a screenshot of a Component on disk
     *  overides existing files
     *
     * @param component - Component to be saved
     * @param name - filename of the screenshot, followed by a sequence number
     * 
     * do not change
     */
    void saveScreenshot(Component component, String name) {
        String randomInfo = ""+SEED+"+"+ (numberOfRegenerates-1); //minus 1 because the initial picture should not count
        System.out.println( SwingUtilities.isEventDispatchThread() );
        BufferedImage image =
            new BufferedImage(
                              component.getWidth(),
                              component.getHeight(),
                              BufferedImage.TYPE_INT_RGB
                             );
        // call the Component's paint method, using
        // the Graphics object of the image.
        Graphics graphics = image.getGraphics();
        component.paint( graphics ); // alternately use .printAll(..)
        graphics.drawString(randomInfo, 0, component.getHeight());
        
        try {
            ImageIO.write(image, "PNG", new File(name+".png"));
            System.out.println( "Saved screenshot as "+ name );
        } catch( IOException e ) {
            System.out.println( "Saving screenshot failed: "+e );
        }
    }
    
}