/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by <<TODO YOUR NAME AND ID HERE>>
 * and <<TODO YOUR PARTNERS NAME AND ID HERE>>
 * as group <<TODO GROUP NUMBER HERE>>
 */
class TheBigSol {

    int SUDOKU_SIZE = 9;          // Size of the grid.
    int SUDOKU_MIN_NUMBER = 1;    // Minimum digit to be filled in.
    int SUDOKU_MAX_NUMBER = 9;    // Maximum digit to be filled in.
    int SUDOKU_BOX_DIMENSION = 3; // Dimension of the boxes (sub-grids that should contain all digits).

    int[][] grid = new int[][] {  // The puzzle grid; 0 represents empty.
        { 0, 1, 0,   0, 0, 0,    0, 3, 6 },    // One solution.
        { 0, 0, 0,   7, 0, 0,    0, 0, 0 },
        { 7, 0, 0,   0, 0, 0,    1, 0, 0 },

        { 2, 0, 0,   0, 0, 3,    0, 0, 0 },
        { 0, 0, 9,   0, 0, 0,    0, 0, 2 },
        { 0, 0, 0,   0, 0, 0,    0, 4, 8 },

        { 0, 0, 4,   0, 0, 9,    0, 0, 1 },
        { 3, 7, 0,   1, 0, 0,    0, 0, 0 },
        { 0, 0, 0,   0, 0, 0,    6, 0, 0 },
    };

    int[][] solution = grid;

    int solutionCounter = 0; // Solution counter

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {
        // TODO
        if (rowConflict(r, d) || columnConflict(c, d) || boxConflict(r, c, d) || asteriskConflict(r, c, d)){
            return true;
        }
        return false;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        // TODO
        for(int i = 0; i < SUDOKU_MAX_NUMBER; i++){
            if(grid[r][i] == d){
                return true;
            }
        }
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        // TODO
        for(int i = 0; i < SUDOKU_MAX_NUMBER; i++){
            if(grid[i][c] == d){
                return true;
            }
        }
        return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        // TODO
        int startRow = (r/SUDOKU_BOX_DIMENSION) * SUDOKU_BOX_DIMENSION;
        int endRow = startRow + SUDOKU_BOX_DIMENSION;
        
        int startColumn = (c/SUDOKU_BOX_DIMENSION) * SUDOKU_BOX_DIMENSION;
        int endColumn = startColumn + SUDOKU_BOX_DIMENSION;

        for(int i = startRow; i < endRow; i++){
            for(int j = startColumn; j < endColumn; j++){
                if(grid[i][j] == d){
                    return true;
                }
            }
        }
        return false;
    }
	
	// Is there a conflict in the asterisk when we fill in d?
    // Delete this comment and add your asteriskConflict method in its place.
    boolean checkForAsterisk(int r, int c){
        if((r == 2 || r ==6) && (c == 2 || c == 6) || ((r == 1 || r == 7) && c == 4) || (r == 4 && (c == 1 || c == 4 || c == 7))){
            return true;
        }
        return false;
    }

    boolean asteriskConflict(int r, int c, int d){
        if(checkForAsterisk(r, c)){
           if(d == grid[2][2] || d == grid[1][4] || d == grid[2][6] || d == grid[4][1] || d == grid[4][4] || d == grid[4][7] || d == grid[6][2] || d == grid[7][4] || d == grid[6][6]){
                return true;
            }
        }
        return false;
    }
	
	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
      
        for (int row = 0; row < SUDOKU_SIZE; row++) {
            for (int column = 0; column < SUDOKU_SIZE; column++) {
                if (grid[row][column] == 0) {
                    return new int[]{row, column};
                }
            }

        }

    
        return new int[]{-1, -1};
    }



    void count(int row, int column){
        // TODO
        for(int i = 1; i <= SUDOKU_MAX_NUMBER; i++ ){
            if(!givesConflict(row, column, i)){
                grid[row][column] = i;
                if(row == 8 && column == 8){
                    solutionCounter++;
                   
                } else {
                    
                    int[] coordinates = findEmptySquare();
                    int r = coordinates[0];
                    int c = coordinates[1];
                    count(r, c);
                }
            } 
           
        }
        grid[row][column] = 0;
    }
  


  
    // Find all solutions for the grid, and stores the final solution.
    boolean solve() {
        // TODO
            for (int row = 0; row < SUDOKU_SIZE; row++) {
                for (int column = 0; column < SUDOKU_SIZE; column++) {
                    if (grid[row][column] == 0) {
                        for (int k = SUDOKU_MIN_NUMBER; k <= SUDOKU_MAX_NUMBER; k++) {
                            if (!givesConflict(row, column, k)) {
                                grid[row][column] = k;

                                if(solve()){
                                    return true;
                                }else{
                                    grid[row][column] = 0;
                                }
                            }
                        }
                      return false;
                    }
                }
            }
          
            
         return true;
    }

    // Print the sudoku grid.
    void print() {
    System.out.println("+-----------------+");
        for(int i = 0; i < SUDOKU_SIZE; i++){
            if(i == 3 || i == 6){
                System.out.println("+-----------------+"); 
            }
            System.out.print("|");
            for(int j = 0; j < SUDOKU_SIZE; j++){
                if(j == 2 || j == 5 || j == 8){
                    System.out.print(grid[i][j] + "|");
                }else if(((i == 1 || i == 7) && j ==3) || ((i == 2 || i == 6) && j == 1) || (i == 4 && (j == 0 || j == 3 || j == 6))){
                    System.out.print(grid[i][j] + ">");
                }else if(((i == 1 || i == 7) && j == 4) || ((i == 2 || i == 6) && j == 6) || (i == 4 && (j == 1 || j == 4 || j == 7))){
                    System.out.print(grid[i][j] + "<");
                } else{
                System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    System.out.println("+-----------------+");
    }

    // Run the actual solver.
    void solveIt() {
        // TODO
        int[] coordinates = findEmptySquare();
                    int r = coordinates[0];
                    int c = coordinates[1];
                    count(r, c);
        if (solutionCounter>1) {
        System.out.println(solutionCounter);
        }
        solve();
        if (solutionCounter == 1) { 
        print();
        }
      
      
    }

    public static void main(String[] args) {
        (new TheBigSol()).solveIt();
    }
}
