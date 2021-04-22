/**
 * INCOMPLETE 
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */
import java.awt.*;

class Patch extends Button {
    private boolean cooperating; //boolean value which indicates if patch is cooperating
    private double score; //score of the patch
    private boolean changeStrategy;
    private boolean justChanged;
    Patch[] neighbours = new Patch[9]; //array which stores the neighbours of current patch
    
    // returns true if and only if patch is cooperating
    boolean isCooperating() {
        return this.cooperating;
    }
    
    // set strategy to C if isC is true and to D if false
    void setCooperating(boolean isC) {
        this.cooperating = isC; 
        if(this.cooperating) {
            this.setBackground(Color.BLUE); //if patch is cooperating, it makes the patch blue
        } else {
            this.setBackground(Color.RED); //if patch is deflecting, it makes the patch red
        }
    }
    
    // change strategy from C to D and vice versa
    void toggleStrategy() {
        if(this.cooperating) {
            this.setBackground(Color.PINK);
        } else {
            this.setBackground(Color.CYAN);
        }
        this.cooperating = !cooperating; //changes value of cooperating to opposite value
        this.justChanged = true; //strategy was toggled, so justChanged is true
    }

    //
    void setChangeStrategy(boolean bool) {
        this.changeStrategy = bool;
    }

    boolean changedStrategy() {
        return this.changeStrategy;
    }

    public boolean getJustChanged() {
        return this.justChanged;
    }
    
    // return score of this patch in current round
    double getScore() {
        return this.score;
    }

    //sets the score of the patches to new score
    void setScore(double score) {
        this.score = this.score + score; 
    }

    //resets the score of the patches
    void resetScore() {
        this.score = 0.0; //resets score, sets score to 0
    }
}
