/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by <<TODO YOUR NAME AND ID HERE>>
 * and <<TODO YOUR PARTNERS NAME AND ID HERE>>
 * as group <<TODO GROUP NUMBER HERE>>
 */

class SudokuSolver {

    int SUDOKU_SIZE = 9;          // Size of the grid.
    int SUDOKU_MIN_NUMBER = 1;    // Minimum digit to be filled in.
    int SUDOKU_MAX_NUMBER = 9;    // Maximum digit to be filled in.
    int SUDOKU_BOX_DIMENSION = 3; // Dimension of the boxes (sub-grids that should contain all digits).

    int[][] grid = new int[][] {  // The puzzle grid; 0 represents empty.
        { 0, 9, 0,   7, 3, 0,    4, 0, 0 },    // One solution.
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

    int[][] asterisk = new int[][] {
        {2,2}, {4,1}, {6,2}, {1,4}, {4,4}, {7,4}, {2,6}, {6,6}, {4,7},
    };

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {
        if(rowConflict(r, d) == true || columnConflict(c, d) == true || boxConflict(r, c, d) == true) {
            return true;
        }
        return false;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        for(int i = 0; i < SUDOKU_SIZE; i++) {
            if (grid[r][i] == d) {
                return true;
            }
        }
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        for(int i = 0; i < SUDOKU_SIZE; i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
        return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        for(int i = 0; i < SUDOKU_BOX_DIMENSION; i++) {
            for(int j = 0; j < SUDOKU_BOX_DIMENSION; j++) {
                for(r = i * 3; r < (i * 3 + 3); r++) {
                    for(c = j * 3; c < (j * 3 + 3); c++) {
                        if (grid[r][c] == d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
	
	// Is there a conflict in the asterisk when we fill in d?
	// Delete this comment and add your asteriskConflict method in its place.
	
	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        // TODO
        return new int[]{-1, -1};
    }

    // Find all solutions for the grid, and stores the final solution.
    void solve() {
        // TODO
    }

    // Print the sudoku grid.
    void printInitial(int N) {
        for(int i = 0; i < N; i++) {
            if (i % 3 == 0) {
                System.out.println("+-----------------+");
            }
            for (int j = 0; j < N; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                } 
                if ((j + 1) % 3 == 0 || (j + 2) % 3 == 0) {
                    System.out.print(" ");
                }
                if (grid[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.print("|");
            System.out.println();
        } 
        System.out.println("+-----------------+");       
    }

    // Run the actual solver.
    void solveIt() {
        printInitial(SUDOKU_SIZE);
        givesConflict(0, 0, 1);
    }

    public static void main(String[] args) {
        (new SudokuSolver()).solveIt();
    }
}
