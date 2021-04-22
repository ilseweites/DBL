/**
 * COMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * 
 * @author Ilse Weites 1563343
 * @author Marlou Hoogstraate 1564870
 * assignment group 119
 * 
 * assignment copyright Kees Huizing
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Hashtable;

class PrisonersDilemma {
    private int timerDelay = 1000; //Timer delay in ms
    
    void buildGUI() {
        SwingUtilities.invokeLater( () -> {

            //Creating the frame
            JFrame frame = new JFrame("Prisoner's dilemma"); //Creates frame with a name
            frame.setVisible(true); //Sets frame to visible
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //it exits the program when you close the frame
            frame.setResizable(false); //Sets frame to not resizable
            frame.setSize(800, 800); //Sets size with width and hight of frame
            frame.setLayout(new BorderLayout()); //Makes borderlayout in the frame

            //Creating the playingfield
            PlayingField playingfield = new PlayingField(); //creates new playingfield where the grid will be stored in
            playingfield.fillGrid(); //fills the playingfield with the grid
            playingfield.setLayout(new GridLayout(playingfield.getGridWidth(), playingfield.getGridLength())); //Sets gridlayout of the playingfield
            playingfield.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); //Reads playingfield from left to right
            playingfield.randomPatch(); //randomizes initial values in grid
            playingfield.addNeighbours(); //Adds neighbours to playingfield

            //Creates grid of patches which is stored in the playingfield
            //Loop that runs for every index(x,y) of the grid
            for (int x = 0 ; x < playingfield.getGridWidth(); x++){
                for (int y = 0 ; y < playingfield.getGridLength(); y++){
                    Patch patch; //Creates individual patch for every index of grid
                    patch = playingfield.getPatch(x, y); //Gets patch for every cell in playingfield
                    patch.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            patch.toggleStrategy(); //Toggles strategy for every patch in the playingfield
                        }
                    });  
                    playingfield.add(playingfield.getPatch(x,y)); //Add patches to the cells of the playingfield
                }
            }
            frame.add(playingfield,BorderLayout.CENTER); //Adds the playingfield in the center of the frame

            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    playingfield.step(); //Activates step for every patch in the playingfield
                }
            };

            //Creating Alpha slider
            JLabel alphaLabel = new JLabel("Reward alpha: "); //Creates label with text "Reward alpha: " 
            JSlider alphaSlider = new JSlider(0, 30, 10); //Creates slider with min, max and value
            alphaSlider.setMajorTickSpacing(1); //sets spacing to 1
            alphaSlider.setPaintTicks(true); //Sets ticks visible
            alphaSlider.setPaintLabels(true); //Sets labels visible

            //Creates hashtable for alpha slider
            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(0 , new JLabel("0.0") ); //Creates lable at 0 with corresponding value of alpha
            labelTable.put(10, new JLabel("1.0") ); //Creates lable at 10 with corresponding value of alpha
            labelTable.put(20, new JLabel("2.0") ); //Creates lable at 20 with corresponding value of alpha
            labelTable.put(30, new JLabel("3.0") ); //Creates lable at 30 with corresponding value of alpha
            alphaSlider.setLabelTable(labelTable); //Adds labelTable to alphaSlider

            //Creates new ChangeListener for the alpha slider
            alphaSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider)e.getSource(); //Gets value of slider which is given by moving the slider
                    playingfield.setAlpha(source.getValue()/10.0); //Changing alpha according tho the value of the slider /10.0
                    alphaLabel.setText(" Reward α: " + playingfield.getAlpha()); //Prints the current value of alpha
                }
            });

            Timer timer = new Timer(timerDelay, taskPerformer); //Creates new timer, with initial delay and new delay given by use of slider

            //Creates slider for timer
            JLabel timerLabel = new JLabel("Time in milliseconds : "); //Creates label for the timer
            JSlider timerSlider = new JSlider(0, 3000, 1000); //Creates slider with min, max and value
            timerSlider.setMajorTickSpacing(1); //sets spacing to 1
            timerSlider.setPaintTicks(true); //Sets ticks visible
            timerSlider.setPaintLabels(true); //Sets labels visible

            //Creates hashtable for timer
            Hashtable<Integer, JLabel> labelTable2 = new Hashtable<>(); //Creates new labeltable 
            labelTable2.put(0, new JLabel("0")); //Creates lable at 0 with corresponding value
            labelTable2.put(500, new JLabel("500")); //Creates lable at 500 with corresponding value
            labelTable2.put(1000, new JLabel("1000")); //Creates lable at 1000 with corresponding value
            labelTable2.put(1500, new JLabel("1500")); //Creates lable at 1500 with corresponding value
            labelTable2.put(2000, new JLabel("2000")); //Creates lable at 2000 with corresponding value
            labelTable2.put(2500, new JLabel("2500")); //Creates lable at 2500 with corresponding value
            labelTable2.put(3000, new JLabel("3000")); //Creates lable at 3000 with corresponding value
            timerSlider.setLabelTable(labelTable2); //Adds the labeltable to timerSlider

            //Creates new ChangeListener for the timer slider
            timerSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider)e.getSource(); //Gets value of slider which is given by moving the slider
                    timerDelay = source.getValue(); //Returns current value of slider and changes the timerdelay correspondingly
                    timer.setDelay(timerDelay); //Set the delay of the timer to value of slider
                }
            });

            //Creating go button
            JButton goButton = new JButton("Go"); //Creates button with the text "go"
            goButton.addActionListener(new ActionListener () {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Timer stops when goButton is pressed when program was running
                    if (timer.isRunning()) {
                        timer.stop();
                    //Timer starts running when goButton is pressed
                    } else {
                        timer.start();
                    }
                    //Changes text of the goButton to Pause if program is running
                    if (goButton.getText().equals("Go")){
                        goButton.setText("Pause");
                    //Keeps the text of the goButton if program is not running
                    } else {
                        goButton.setText("Go");
                    } 
                }
            });

            //Creating resetButton
            JButton resetButton = new JButton("Reset"); //Creates button with text "Reset"
            resetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playingfield.randomPatch(); //When resetbutton is pressed, it will randomize the patches by calling back to .randomPatch()
                }
            });

            //adds components to the panel for sliders
            JPanel sliders = new JPanel(); //Creates panel named sliders
            frame.add(sliders, BorderLayout.NORTH); //put sliders in top of the frame
            sliders.add(timerLabel); //Adds timerLabel to sliders panel
            sliders.add(timerSlider); //Adds timerSlider to sliders panel
            sliders.add(alphaLabel); //Adds alphaLabel to sliders panel
            sliders.add(alphaSlider); //Adds alphaLabel to sliders panel

            //adds components to the panel for buttons
            JPanel buttons = new JPanel(); //Creates panel named buttons
            frame.add(buttons, BorderLayout.SOUTH); //put buttons in bottom of the frame
            buttons.add(goButton); //adds goButton to buttons panel
            buttons.add(resetButton); //adds resetButton to buttons panel
        } );
    }
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }
}
