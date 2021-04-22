/**
 * COMPLETE 
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * 
 * @author Ilse Weites 1563343
 * @author Marlou Hoogstraate 1564870
 * assignment group 119
 * 
 * assignment copyright Kees Huizing
 */

import java.awt.*;

class Patch extends Button {
    private boolean cooperating; //Private boolean for cooperating patch
    private double score; //Private boolean for the score
    private boolean changeStrategy; //Private boolean to see if the patch should change next round
    private boolean justChanged; //Private boolean to see if the patch sould go back to the original color next round
    Patch[] neighbours = new Patch[9]; //Array for keeping a eye on the neighbours
    
    //Boolean that returns true if patch is cooperating
    boolean isCooperating() {
        return this.cooperating;
    }
    
    //Void sets to strategy C if isC is true and sets to strategy D if isC is false
    void setCooperating(boolean isC) {
        this.cooperating = isC; //Compares this.cooperating to isC
        if(this.cooperating) {
            this.setBackground(Color.BLUE); //if patch is cooperating, it makes the patch blue
        } else {
            this.setBackground(Color.RED); //if patch is defecting, it makes the patch red
        }
    }
    
    // change strategy from C to D and vice versa
    void toggleStrategy() {
        if(this.cooperating) {
            this.setBackground(Color.ORANGE); //Sets color of the patch to orange if the patch just went from cooperating to defecting
        } else {
            this.setBackground(Color.CYAN); //Sets color of the patch to cyan if the patch just went from defecting to cooeprating
        }
        this.cooperating = !cooperating; //changes value of cooperating to opposite value
        this.justChanged = true; //strategy was toggled, so justChanged is true
    }

    //Checks if strategy need to be changed with boolean statement
    void setChangeStrategy(boolean bool) {
        this.changeStrategy = bool;
    }

    //Returns changedStrategy
    boolean changedStrategy() {
        return this.changeStrategy;
    }

    //Return getJustChanged
    public boolean getJustChanged() {
        return this.justChanged;
    }
    
    //Returns score of this patch in current round
    double getScore() {
        return this.score;
    }

    //Sets the score of the patches to new score
    void setScore(double score) {
        this.score = this.score + score;
    }

    //Resets the score of the patches
    void resetScore() {
        this.score = 0.0; //Resets score of patch to 0
    }
}
