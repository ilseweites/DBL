package RA;

/**
 * Author: Jan Heemstra & Olof Morra
 * Course: 2IP90
 */

/** Main class for HA Random Artist 
  * can be used unchanged
  * 
  * @author kees
  */

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class RA {
  JFrame frame; 
  Cara cara; // provides random painting 
  JButton button;

  RA() {
    // create the GUI on the event thread.
    // this is better than on the main thread 
    SwingUtilities.invokeLater( new Runnable() {
      @Override
      public void run() {
        cara = new Cara();
        frame = new JFrame("Computer Assisted Random Artist");
        frame.add(cara, BorderLayout.CENTER);
        button = new JButton("regenerate");
        button.addActionListener(cara); // cara provides reaction on buttonclick
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        cara.regenerate(); // can be done here since cara has a size!
        frame.setVisible(true);                
      }
    } );
  }
  
  public static void main(String[] arg) {
      new RA();    
  }
}
  
  
  
  
  
  
  
  
  
  
  
  
  

