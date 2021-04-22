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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Hashtable;

class PrisonersDilemma /* possible extends... */ {
    private int timerDelay = 1000;
    
    void buildGUI() {
        SwingUtilities.invokeLater( () -> {
            //creating the frame
            JFrame frame = new JFrame("Prisoner's dilemma"); //creates the frame with corresponding name
            frame.setVisible(true); //makes frame visible to user
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program when frame is closed
            frame.setResizable(false); //makes the frame non-resizable
            frame.setSize(800, 800); //sets the size of the frame to 800x800
            frame.setLayout(new BorderLayout());

            //creates playingfield
            PlayingField playingfield = new PlayingField(); //creates new playingfield where the grid will be stored in
            playingfield.fillGrid(); //fills the playingfield with the grid
            playingfield.setLayout(new GridLayout(playingfield.getGridWidth(), playingfield.getGridLength()));
            playingfield.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            playingfield.randomPatch(); //randomizes initial values in grid

            playingfield.addNeighbours();
            for (int x = 0 ; x < playingfield.getGridWidth(); x++){
                for (int y = 0 ; y < playingfield.getGridLength(); y++){
                    Patch patch;
                    patch = playingfield.getPatch(x, y);
                    patch.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            patch.toggleStrategy();
                        }
                    });  
                    playingfield.add(playingfield.getPatch(x,y));
                }
            }
            frame.add(playingfield,BorderLayout.CENTER);

            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    playingfield.step();
                }
            };

            Timer timer = new Timer(timerDelay, taskPerformer);

            JPanel sliders = new JPanel();
            frame.add(sliders, BorderLayout.NORTH);

            //creates panel for buttons
            JPanel buttons = new JPanel();
            frame.add(buttons, BorderLayout.SOUTH);

            //creates go button
            JButton goButton = new JButton("Go");
            goButton.addActionListener(new ActionListener () {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                    if (goButton.getText().equals("Go")){
                        goButton.setText("Pause");
                    } else {
                        goButton.setText("Go");
                    } 
                }
            });

            JButton resetButton = new JButton("Reset");
            resetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playingfield.randomPatch();
                }
            });

            JLabel alphaLabel = new JLabel("Reward alpha: ");
            JSlider alphaSlider = new JSlider(0, 30, 10);
            alphaSlider.setMajorTickSpacing(1);
            alphaSlider.setPaintTicks(true);
            alphaSlider.setPaintLabels(true);
            Hashtable labelTable = new Hashtable();
            labelTable.put(0 , new JLabel("0.0") );
            labelTable.put(10, new JLabel("1.0") );
            labelTable.put(20, new JLabel("2.0") );
            labelTable.put(30, new JLabel("3.0") );
            alphaSlider.setLabelTable(labelTable);

            alphaSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider)e.getSource();
                    playingfield.setAlpha(source.getValue()/10.0); // changing alpha according tho the value of the slider /10.0
                    alphaLabel.setText(" Reward α: " + playingfield.getAlpha());
                }
            });

            JLabel timerLabel = new JLabel("Time in milliseconds : ");
            JSlider timerSlider = new JSlider(0, 3000, 10);
            timerSlider.setMajorTickSpacing(1);
            timerSlider.setPaintTicks(true);
            timerSlider.setPaintLabels(true);
            Hashtable labelTable2 = new Hashtable();
            // labelTable2.put(0, new JLabel("0"));
            // labelTable2.put(500, new JLabel("500"));
            // labelTable2.put(1000, new JLabel("1000"));
            // labelTable2.put(1500, new JLabel("1500"));
            // labelTable2.put(2000, new JLabel("2000"));
            // labelTable2.put(2500, new JLabel("2500"));
            // labelTable2.put(3000, new JLabel("3000"));
            // timerSlider.setLabelTable(labelTable2);

            timerSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider source = (JSlider)e.getSource();
                    timerDelay = source.getValue();
                    timer.setDelay(timerDelay);
                }
            });

            //adds components to button panel
            buttons.add(goButton);      
            buttons.add(resetButton);
            sliders.add(timerLabel);
            sliders.add(timerSlider);
            sliders.add(alphaLabel);
            sliders.add(alphaSlider);
        } );
    }
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }
}
