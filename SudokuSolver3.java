/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by Ilse Weites 1563343
 * and Marlou Hoogstraate 1564870
 * as group 119
 * 30/09/2019
 */

class SudokuSolver3 {

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
        //if there is a duplicate in the row, column, box or asterisk, it returns false
        if(rowConflict(r, d) == false || columnConflict(c, d) == false || boxConflict(r, c, d) == false || asteriskConflict(r, c, d) == false) {
            return false; 
        }
        return true; //if there is no conflict return true
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        // TODO
        //loop which checks if given number is in conflict with the row
        for (int c = 0; c < 9; c++) { 
                //if number is already in the row, it returns false
                if (d==grid[r][c]){ 
                    return false; 
                } 
        }
        return true; //if number is not already in row, it returns true
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        // TODO
        //loop which checks if given number is in conflict with the column
        for (int r = 0; r < 9; r++) {
            //if number is already in the column, it returns false 
                if (d==grid[r][c]){
                    return false;
                } 
        }
        return true; //if number is not already in column, it returns true
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        // TODO
        int rstart; //row where the current empty spot is in
        int cstart; //column where the current empty spot is in


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
        //loop which runs for the length of the box (horizontal)
        for (r = rstart; r<rstart+3; r++) { 
            //loop which runs for the length of the box (vertical)
            for (c=cstart; c<cstart+3; c++){
                //if the number is already in the box, it returns false
                if (d==grid[r][c]){
                    return false;
                } 
            }
        }
        return true; //if the number is not in the box, it returns true
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
                return false;
            } else if (d==grid[2][2]){
                return false;
            } else if (d==grid[6][2]){
                return false;
            } else if (d==grid[6][6]){
                return false;
            } else if (d==grid[2][6]){
                return false;
            } else if (d==grid[4][1]){
                return false;
            } else if (d==grid[7][4]){
                return false;
            } else if (d==grid[4][7]){
                return false;
            } else if (d==grid[1][4]){
                return false;
            } 
        return true;
        }
    return true;
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
        //loop which runs for length of sudoku grid (horizontal)
        for (int r=0; r<SUDOKU_SIZE; r++) {
            //loop which runs for the length of the sudoku grid (vertical)
            for (int c=0; c<SUDOKU_SIZE; c++) {
                //looks if the number at current index is a 0
                if (grid[r][c]==0) {
                    //loop which checks possible solutions for this index between 1 and 9
                    for (int d = SUDOKU_MIN_NUMBER; d <= SUDOKU_MAX_NUMBER; d++) {
                        //if the number does not give a conflict the 0 at this index changes to the number
                        if (!givesConflict(r, c, d)) {
                            grid[r][c] = d; //changes 0 in array to the found number

                            if(solve()){
                                return false;
                            } else {
                                grid[r][c]=0;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    void print(int N) {
        //loop which runs for length of sudoku grid (horizontal)
        for(int i = 0; i < N; i++) {
            //prints horizontal divider between each box
            if (i % 3 == 0) {
                System.out.println("+-----------------+"); //prints horizontal divider
            }
            System.out.print("|"); //prints left edge of the grid
            //loop which runs for the length of the sudoku grid (vertical)
            for (int j = 0; j < N; j++) {
                //prints the right edge of each box with the number left to the right edge
                if (j == 2 || j == 5 || j == 8) {
                    //if the current index is a 0, print an empty spot
                    if(grid[i][j] == 0){
                        System.out.print(" " + "|"); 
                    } else {
                    System.out.print(grid[i][j] + "|");
                    }
                //prints left asteriks indication with the number in the asteriks
                } else if((((i == 1 || i == 7) && j == 3) || ((i == 2 || i == 6) && j == 1) || (i == 4 && (j == 0 || j == 3 || j == 6)))) {
                    //if the current index is a 0, print an empty spot
                    if(grid[i][j] == 0){
                        System.out.print(" " + ">"); 
                    } else {
                    System.out.print(grid[i][j] + ">");
                    }
                //prints right asteriks indication with the number in the asteriks
                } else if ((((i == 1 || i == 7) && j == 4) || ((i == 2 || i ==  6) && j == 6) || (i == 4 && (j == 1 || j == 4 || j == 7)))) {
                    if(grid[i][j] == 0){
                        System.out.print(" " + "<"); 
                    } else {
                    System.out.print(grid[i][j] + "<");
                    }
                //prints all the other numbers for which the above does not apply
                } else { 
                    if(grid[i][j] == 0){
                        System.out.print(" " + " "); 
                    } else {
                    System.out.print(grid[i][j] + " ");
                    }
                }
            }
            System.out.println(); //prints next line for each row
        } 
        System.out.println("+-----------------+"); //prints bottom edge     
    }

    // Run the actual solver.
    void solveIt() {
        print(SUDOKU_SIZE);
        solve();
        print(SUDOKU_SIZE);
    }
    
    public static void main(String[] args) {
        (new SudokuSolver3()).solveIt();
    }
}
