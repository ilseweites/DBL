package randomartist;

/**
 * Author: Jan Heemstra & Olof Morra
 * Course: 2IP90
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import randomartist.*;


/**
 * starter file for Random Artist homework assignment

 * @author huub & kees
 */

public class Cara extends JPanel implements ActionListener {
    Random random = new Random();
    ArrayList<RandomShape> shapes = new ArrayList<RandomShape>();
    
    public Cara() {
        setPreferredSize(new Dimension(800, 800)); // make panel 800 by 800 pixels        
    }

    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g);     // clears the background
        
        // Loop this, 10 to 30 (or more) objects, random amount... 
        for (RandomShape shape : shapes){
            shape.draw(g);
        }
    }

    /**
     * redraws the Cara JPanel, when the button is pressed. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        regenerate();
        repaint();
    }

    public void regenerate() {
        // clear the shapes list
        shapes.clear();
        
        
        int amount = random.nextInt(200);
        // create random shapes 
        for (int i = 0; i < 10 + amount; i++){
            int nextShape = random.nextInt(5);
            switch(nextShape) {
                case 0: shapes.add(new RandomCircle(800, 800));
                    break;
                case 1: shapes.add(new RandomStar(800, 800));
                    break;
                case 2: shapes.add(new RandomHeptagon(800, 800));
                    break;
                case 3: shapes.add(new RandomTriangle(800, 800));
                    break;
                case 4: shapes.add(new RandomHeptagon(800, 800));
                    break;
            }
        }
        
        shapes.add(new randomartist.RandomPoem(300, 300));
    }
 }
