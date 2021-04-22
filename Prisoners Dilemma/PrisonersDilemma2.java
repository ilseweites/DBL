/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */

import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
//...

class PrisonersDilemma2 /* possible extends... */ {
    //...
    
    void buildGUI() {
        SwingUtilities.invokeLater( () -> {
            //...
        } );

    JFrame frame = new JFrame("Prisoners Dilemma");
    JPanel gui = new JPanel(new BorderLayout(2,2));
    JPanel p1 = new JPanel(new GridLayout(10, 10));
    p1.setBackground(Color.PINK);
    //p1.setLayout(new GridLayout(10, 10));
    JPanel p2 = new JPanel();

    JButton goButton = new JButton("GO");
    JButton resetButton = new JButton("RESET");
    p2.add(goButton);
    p2.add(resetButton);
    gui.add(p1, BorderLayout.CENTER);
    gui.add(p2, BorderLayout.SOUTH);
    frame.add(gui);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setVisible(true);
    }
    
    //...
    
    public static void main( String[] a ) {
        (new PrisonersDilemma2()).buildGUI();
    }
}
