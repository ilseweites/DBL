/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */

import java.util.Random;
import javax.swing.JPanel;
import java.awt.*;

class PlayingField extends JPanel {
    
    private int gridWidth = 50; //initializes gridwidth
    private int gridLength = 50; //initializes gridlength
    private Patch[][] grid = new Patch[gridWidth][gridLength]; //makes Patchgrid of length and width of grid
    private double alpha = 1; // defection award factor

    // random number genrator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random random = new Random( SEED );  
    
    //fills grid with patches
    public void fillGrid() {
        //for every index(x,y) of grid an individual patch is created
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                grid[x][y] = new Patch();
            }
        }
    }

    //appoints random boolean values to patches
    public void randomPatch() {
        //for every index(x,y) of grid a random boolean value is appointed
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                grid[x][y].setCooperating(random.nextBoolean()); //calls back to setCooperating to set random boolean value
            }
        }
    }

    //creates neighbours for every patch
    public void addNeighbours(){
        //for every index(x,y) of grid all neighbours are stored
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                createNeighbourhood(x, y); 
            }
        }
    }

    //looks for neighbouring patches and stores their indexes
    public void createNeighbourhood(int r, int c) {
        int row; //
        int col;
        int i = 0;
        for(int x = r - 1; x <= r + 1; x++) {
            for(int y = c - 1; y <= c + 1; y++) {
                row = x;
                col = y;
                if(x < 0) {
                    row = gridWidth - 1;
                }
                if(y < 0) {
                    col = gridLength - 1;
                }
                if(x >= gridWidth){
                    row = 0;
                }
                if(y >= gridLength){
                    col = 0;
                }
                grid[r][c].neighbours[i] = grid[row][col];
                i++;
            }
        }
    }

    public void calculateScore() {
        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridLength; y++) {
                for(Patch neighbour : grid[x][y].neighbours) {
                    if(grid[x][y].isCooperating()) {
                        if(neighbour.isCooperating() && (neighbour != grid[x][y])) {
                            grid[x][y].setScore(1.0);
                            } 
                    } else {
                        if(neighbour.isCooperating() && (neighbour != grid[x][y])) {
                                grid[x][y].setScore(alpha);
                        }
                    }
                }
            }
        }
    }

    public void ifNextStrategy(int x, int y) {
        Patch highestPatch = grid[x][y];
        double highestScore = 0;

        for (Patch neighbour : grid[x][y].neighbours) {
            if (neighbour.getScore() == highestScore) {
                if (random.nextBoolean()) {
                    highestPatch = neighbour;
                }
            } 
            if (neighbour.getScore() > highestScore) {
                highestScore = neighbour.getScore();
                highestPatch = neighbour;
            }
        }
        if(grid[x][y].isCooperating() != highestPatch.isCooperating()) {
            grid[x][y].setChangeStrategy(true);
        } else {
            grid[x][y].setChangeStrategy(false);
        }
    }
    
    /**
     * calculate and execute one step in the simulation 
     */
    public void step() {
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                if(grid[x][y].getJustChanged()) {
                    if(grid[x][y].isCooperating()) {
                        grid[x][y].setBackground(Color.BLUE);
                    }
                } else {
                    grid[x][y].setBackground(Color.RED);
                }
            }
        }

        //resets score of patches
        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                grid[x][y].resetScore();
            }
        }

        calculateScore();

        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                ifNextStrategy(x, y);
            }
        }

        for (int x = 0; x < gridWidth; x++ ) {
            for (int y = 0; y < gridLength; y++ ) {
                if(grid[x][y].changedStrategy()) {
                    grid[x][y].toggleStrategy();
                    grid[x][y].setChangeStrategy(false);

                }
            }
        }
    }
    
    public void setAlpha( double alpha ) {
        this.alpha = alpha;
    }
    
    public double getAlpha( ) {
        return this.alpha;
    }

    public int getGridWidth() {
        return this.gridWidth;
    }

    public int getGridLength() {
        return this.gridLength;
    }

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

