/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by Ilse Weites 1563343
 * and Marlou Hoogstraate 1564870
 * as group 119
 * 30/09/2019
 */

class SudokuSolverWokko {

    int SUDOKU_SIZE = 9;          // Size of the grid.
    int SUDOKU_MIN_NUMBER = 1;    // Minimum digit to be filled in.
    int SUDOKU_MAX_NUMBER = 9;    // Maximum digit to be filled in.
    int SUDOKU_BOX_DIMENSION = 3; // Dimension of the boxes (sub-grids that should contain all digits).

    int[][] grid = new int[][] {  // The puzzle grid; 0 represents empty.
        { 0, 9, 0,   7, 3, 0,    4, 0, 0 }, 
        { 0, 0, 0,   0, 0, 0,    5, 0, 0 },
        { 3, 0, 0,   0, 0, 6,    0, 0, 0 },

        { 0, 0, 0,   0, 0, 2,    6, 4, 0 },
        { 0, 0, 0,   6, 5, 1,    0, 0, 0 },
        { 0, 0, 6,   9, 0, 7,    0, 0, 0 },

        { 5, 8, 0,   0, 0, 0,    0, 0, 0 },
        { 9, 0, 0,   0, 0, 3,    0, 2, 5 },
        { 6, 0, 3,   0, 0, 0,    8, 0, 0 },
    };

    int solutionCounter = 0; // Solution counter

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {
        if(rowConflict(r, d) == true || columnConflict(c, d) == true || boxConflict(r, c, d) == true || asteriskConflict(r, c, d) == true) {
            return true;
        }
        return false;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        // TODO
        for (int c = 0; c < 9; c++) { 
            //System.out.print(grid[r][c]);
                if (d==grid[r][c]){
                    return true;
                } 
        }
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        // TODO
        for (int r = 0; r < 9; r++) { 
            //System.out.print(grid[r][c]);
                if (d==grid[r][c]){
                    return true;
                } 
        }
        return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        // TODO
        int rstart;
        int cstart;

        if (c<=2){
            cstart=0;
        } else if (c>=6) {
            cstart=6;
        } else {
            cstart=3;
        }
        
        if (r<=2){
            rstart=0;
        } else if (r>=6) {
            rstart=6;
        } else {
            rstart=3;
        }       

        for (r = rstart; r<rstart+3; r++) { 
            for (c=cstart; c<cstart+3; c++){
                if (d==grid[r][c]){
                    return true;
                } 
            }
        }
        return false;
    }

    boolean asteriskConflict(int r, int c, int d){
        boolean validCell = false;
        if (r==4 && c==4) {
            validCell = true;
        } else if (r==2 && c==2){
            validCell = true;
        } else if (r==6 && c==2){
            validCell = true;
        } else if (r==6 && c==6){
            validCell = true;
        } else if (r==2 && c==6){
            validCell = true;
        } else if (r==4 && c==1){
            validCell = true;
        } else if (r==7 && c==4){
            validCell = true;
        } else if (r==4 && c==7){
            validCell = true;
        } else if (r==1 && c==4){
            validCell = true;
        }

        if(validCell==true) {
            if (d==grid[4][4]) {
                return true;
            } else if (d==grid[2][2]){
                return true;
            } else if (d==grid[6][2]){
                return true;
            } else if (d==grid[6][6]){
                return true;
            } else if (d==grid[2][6]){
                return true;
            } else if (d==grid[4][1]){
                return true;
            } else if (d==grid[7][4]){
                return true;
            } else if (d==grid[4][7]){
                return true;
            } else if (d==grid[1][4]){
                return true;
            } 
        return false;
        }
    return false;
    }
	
	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        for (int r = 0; r < 8; r++) { 
            for (int c=0; c<8; c++) { 
                if (grid[r][c]==0){
                    //System.out.println(r + "and" + c);
                    return new int[]{r, c};  
                }
            }
        }
        return new int[]{-1, -1};
    }
    

    // Find all solutions for the grid, and stores the final solution.
    boolean solve() {
        //TODO
        for (int r=0; r<SUDOKU_SIZE; r++) {
            for (int c=0; c<SUDOKU_SIZE; c++) {
                if (grid[r][c]==0) {
                    for (int d = SUDOKU_MIN_NUMBER; d <= SUDOKU_MAX_NUMBER; d++) {
                        if (!givesConflict(r, c, d)) {
                            grid[r][c] = d;
                            //System.out.println("row : " + r +" Col : " + r +" value : " +grid[r][c] + "|");
                            if(solve()){
                                return true;
                            } else {
                                grid[r][c]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    void print(int N) {
        for(int i = 0; i < N; i++) {
            if (i % 3 == 0) {
                System.out.println("+-----------------+");
            }
            System.out.print("|");
            for (int j = 0; j < N; j++) {
                if (j == 2 || j == 5 || j == 8) {
                    System.out.print(grid[i][j] + "|");
                } else if((((i == 1 || i == 7) && j == 3) || ((i == 2 || i == 6) && j == 1) || (i == 4 && (j == 0 || j == 3 || j == 6)))) {
                    System.out.print(grid[i][j] + ">");
                } else if ((((i == 1 || i == 7) && j == 4) || ((i == 2 || i ==  6) && j == 6) || (i == 4 && (j == 1 || j == 4 || j == 7)))) {
                    System.out.print(grid[i][j] + "<");
                } else { 
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        } 
        System.out.println("+-----------------+");       
    }

    // Run the actual solver.
    void solveIt() {
        print(SUDOKU_SIZE);
            if (solve()==true) {
                print(SUDOKU_SIZE);
            } else {
                System.out.println("No solution");
            }
    }

    public static void main(String[] args) {
        (new SudokuSolverWokko()).solveIt();
    }
}