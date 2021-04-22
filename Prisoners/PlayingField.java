/**
 * COMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * 
 * @author Ilse Weites 1563343
 * @author Marlou Hoogstraate 1564870
 * assignment group 119
 * 
 * assignment copyright Kees Huizing
 */

import java.util.Random;
import javax.swing.JPanel;
import java.awt.*;

class PlayingField extends JPanel {
    
    private int gridWidth = 50; //Sets grid width to 50
    private int gridLength = 50; //Sets grid length to 50
    private Patch[][] grid = new Patch[gridWidth][gridLength]; //makes Patchgrid of length and width of grid
    private double alpha = 1; //Defection award factor

    //Random number generator
    private static final long SEED = 37L; //Seed (starting point) for random number generator; any number goes
    public static final Random random = new Random(SEED); //Randomizes the sequance of numbers
    
    //Fills the grid with patches
    public void fillGrid() { 
        //Loops that run for every index(x,y) of the grid
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                grid[x][y] = new Patch(); //Creates individual patch for every index of grid
            }
        }
    }

    //Appoints random boolean values to every patch
    public void randomPatch() {
        //Loops that run for every index(x,y) of the grid
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                grid[x][y].setCooperating(random.nextBoolean()); //Calls back to setCooperating to set random boolean value for index
            }
        }
    }

    //Adds every neighbour to every patch
    public void addNeighbours(){
        //Loops that run for every index(x,y) of the grid
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                createNeighbourhood(x, y); //for every index(x,y) of grid all neighbouring patches are stored
            }
        }
    }

    //looks for neighbouring patches and stores their indexes
    public void createNeighbourhood(int r, int c) {
        int row; //row in which current patch is in
        int col; //col in which current patch is in
        int i = 0; //Int which indicates the number of the neighbour (used for neighbour array)
        //Loop which runs for the indexes(x,y) of the neighbours
        for(int x = r - 1; x <= r + 1; x++) {
            for(int y = c - 1; y <= c + 1; y++) {
                row = x; //Row in which neighbouring patch is in is changed to x value of neighbour
                col = y; //Row in which neighbouring patch is in is changed to y value of neighbour
                //If there is no left neighbour inside grid
                if(x < 0) {
                    row = gridWidth - 1; //Takes patch on opposite of grid as left neighbour
                }
                //If there is no upper neighbour inside grid
                if(y < 0) {
                    col = gridLength - 1; //Takes patch on opposite of grid as upper neighbour
                }
                //If there is no right neighbour inside grid
                if(x >= gridWidth){
                    row = 0; //Takes patch on opposite of grid as right neighbour
                }
                //If there is no lower neighbour inside grid
                if(y >= gridLength){
                    col = 0; //Takes patch on opposite of grid as lower neighbour
                }
                grid[r][c].neighbours[i] = grid[row][col]; //Sets index of neighbour according to changes given above
                i++; //Increases number of neighbour (repeats same steps for next neighbour)
            }
        }
    }

    //Calculates the score of every patch
    public void calculateScore() {
        //Loops that run for every index(x,y) of the grid
        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridLength; y++) {
                if(grid[x][y].isCooperating()) { //If the grid is cooperating
                    for(Patch neighbour : grid[x][y].neighbours) { //Checks for every neighbour
                        //If neighbour is cooperating gives score 1.0
                        if(neighbour.isCooperating() && (neighbour != grid[x][y])) {
                            grid[x][y].setScore(1.0);
                        } 
                    }
                //If the patch is defecting
                } else {
                    for(Patch neighbour : grid[x][y].neighbours) { //Checks for all neighbours
                        //If neighbour is cooperating gives score alpha
                        if(neighbour.isCooperating() && (neighbour != grid[x][y])) {
                            grid[x][y].setScore(alpha);
                        }
                    }
                }
            }
        }
    }

    //Determines next strategy 
    public void ifNextStrategy(int x, int y) {
        Patch highestPatch = grid[x][y]; //Initiliazes highest patch in neighbourhood
        double highestScore = 0; //Initializes highestScore 

        //Loop which runs for every neighbouring patch of current patch at index(x,y)
        for (Patch neighbour : grid[x][y].neighbours) {
            //If neighbouring score is equal to current score
            if (neighbour.getScore() == highestScore) {
                if (random.nextBoolean()) {
                    highestPatch = neighbour; //Chooses random highest scoring neighbour
                }
            } 
            //If neighbouring score is higher than current highscore
            if (neighbour.getScore() > highestScore) {
                highestScore = neighbour.getScore(); //Stores the new highscore
                highestPatch = neighbour; //Sets the highest scoring patch to the new patch
            }
        }
        //If strategy of current patch is not equal to the strategy of the highest scoring patch
        if(grid[x][y].isCooperating() != highestPatch.isCooperating()) {
            grid[x][y].setChangeStrategy(true); //Changes strategy of patch to strategy of highest scoring patch
        } else {
            grid[x][y].setChangeStrategy(false); //If strategy of patch is equal, strategy will remain the same
        }
    }

    /**
     * calculate and execute one step in the simulation 
     */
    public void step() {
        //Loops that run for every index(x,y) of the grid
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                //If patch has just changed,
                //it changes the color of the patch back to one of the two initial colors
                if(grid[x][y].getJustChanged()) {
                    if(grid[x][y].isCooperating()) { //If patch is cooperating change color to blue
                        grid[x][y].setBackground(Color.BLUE); 
                    }
                } else { //If patch is deffecting change color to red
                    grid[x][y].setBackground(Color.RED); 
                }
            }
        }

        //Loops that run for every index(x,y) of the grid
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                grid[x][y].resetScore(); //Resets the score of the patch
            }
        }

        calculateScore(); //Calculates score for each patch

        //Loops that run for every index(x,y) of the grid
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                ifNextStrategy(x, y); //Determines if patch has to change for next step
            }
        }

        //Loops that run for every index(x,y) of the grid
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                //If the patch has to change
                if(grid[x][y].changedStrategy()) {
                    grid[x][y].toggleStrategy();  //Changes strategy to opposite strategy
                    grid[x][y].setChangeStrategy(false); //Sets boolean value back to false

                }
            }
        }
    }
    
    //Sets value of alpha for patch
    public void setAlpha( double alpha ) {
        this.alpha = alpha;
    }
    
    //Returns alpha of patch
    public double getAlpha( ) {
        return this.alpha;
    }

    //Returns width (x) of grid
    public int getGridWidth() {
        return this.gridWidth;
    }

    //Returns length (y) of grid
    public int getGridLength() {
        return this.gridLength;
    }

    //Returns patch at index in grid
    public Patch getPatch(int x, int y) {
        return grid[x][y];
    }
        
    
    // return grid as 2D array of booleans
    // true for cooperators, false for defectors
    // precondition: grid is rectangular, has non-zero size and elements are non-null
    public boolean[][] getGrid() {
        boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[0].length; y++ ) {
                resultGrid[x][y] = grid[x][y].isCooperating();
            }
        }
        
        return resultGrid; 
    }
    
    // sets grid according to parameter inGrid
    // a patch should become cooperating if the corresponding
    // item in inGrid is true
    public void setGrid( boolean[][] inGrid) {
        for (int x = 0; x < inGrid.length; x++) {
            for (int y = 0; y < inGrid[0].length; y++) {
                grid[x][y].setCooperating(inGrid[x][y]);
            }
        }       
    }   
}

