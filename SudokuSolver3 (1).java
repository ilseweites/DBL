/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by Ilse Weites 1563343
 * and Marlou Hoogstraate 1564870
 * as group 119
 * 30/09/2019
 */

class SudokuSolver {

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
        //if there is a duplicate in the row, column, box or asterisk, it returns true
        if(rowConflict(r, d) == true || columnConflict(c, d) == true || boxConflict(r, c, d) == true || asteriskConflict(r, c, d) == true) {
            return true;
        }
        return false; //if there is no conflict return false
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        // TODO
        //loop which checks if given number is in conflict with the row
        for (int c = 0; c < 9; c++) { 
            //if number is already in the row, it returns true
                if (d==grid[r][c]){
                    return true;
                } 
        }
        return false; //if number is not already in row, it returns false
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        // TODO
        //loop which checks if given number is in conflict with the column
        for (int r = 0; r < 9; r++) { 
            //if number is already in the column, it returns true
                if (d==grid[r][c]){
                    return true;
                } 
        }
        return false; //if number is not already in column, it returns false
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        // TODO
        int rstart; //row where the current empty spot is in
        int cstart; //column where the current empty spot is in

        //It checks it which box column the coordinate is
        //if c<=2 the coordinate is in the first box column
        if (c<=2){ 
            cstart=0; //it sets cstart to 0 
         //if c>=6 the coordinate is in the thirth box column
        } else if (c>=6) {
            cstart=6; //it sets cstart to 6
         //if the the statements above aren't true, the coordinate is in the second box column
        } else {
            cstart=3; //it sets cstart to 3
        }
        
        //It checks it wich box row the coordinate is
        //if r<=2 the coordinate is in the first box row
        if (r<=2){
            rstart=0; //it sets cstart to 0
        //if r>=6 the coordinate is in the thirth box row
        } else if (r>=6) {
            rstart=6; //it sets cstart to 6
        //if the the statements above aren't true, the coordinate is in the second box column
        } else {
            rstart=3; //it sets cstart to 3
        }       

        //loop which runs for the length of the box (horizontal)
        for (r = rstart; r<rstart+3; r++) { 
            //loop which runs for the length of the box (vertical)
            for (c=cstart; c<cstart+3; c++){
                //if the number is already in the box, it returns true
                if (d==grid[r][c]){
                    return true;
                } 
            }
        }
        return false;  //if the number is not in the box, it returns false
    }

    boolean asteriskConflict(int r, int c, int d){
        boolean validCell = false; //Sets initial value of valid cell to false
        //It looks for each coordinate if it is in the asterisk,
        //if this is the case it return validCell true.
        if (r==4 && c==4) { //checks for coordinate (4,4)
            validCell = true;
        } else if (r==2 && c==2){ //checks for coordinate (2,2)
            validCell = true;
        } else if (r==6 && c==2){ //checks for coordinate (6,2)
            validCell = true;
        } else if (r==6 && c==6){ //checks for coordinate (6,6)
            validCell = true;
        } else if (r==2 && c==6){ //checks for coordinate (2,6)
            validCell = true;
        } else if (r==4 && c==1){ //checks for coordinate (4,1)
            validCell = true;
        } else if (r==7 && c==4){ //checks for coordinate (7,4)
            validCell = true;
        } else if (r==4 && c==7){ //checks for coordinate (4,7)
            validCell = true;
        } else if (r==1 && c==4){ //checks for coordinate (1,4)
            validCell = true;
        }

        //If the coordinate is inside the astrisk,
        //it checks if it in conflict with the other numbers inside the asterisk,
        //if this is the case it returns true. 
        if(validCell==true) {
            if (d==grid[4][4]) { //checks for coordinate (4,4)
                return true;
            } else if (d==grid[2][2]){ //checks for coordinate (2,2)
                return true;
            } else if (d==grid[6][2]){ //checks for coordinate (6,2)
                return true;
            } else if (d==grid[6][6]){ //checks for coordinate (6,6)
                return true;
            } else if (d==grid[2][6]){ //checks for coordinate (2,6)
                return true;
            } else if (d==grid[4][1]){ //checks for coordinate (4,1)
                return true;
            } else if (d==grid[7][4]){ //checks for coordinate (7,4)
                return true;
            } else if (d==grid[4][7]){ //checks for coordinate (4,7)
                return true;
            } else if (d==grid[1][4]){ //checks for coordinate (1,4)
                return true;
            } 
        return false; //if this is not the case return false
        }
    return false; //if this is not the case return false
    }
	
	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        //Loop which runs for the length of the row
        for (int r = 0; r < SUDOKU_SIZE; r++) { 
            //Loop which runs for the length of the column
            for (int c=0; c < SUDOKU_SIZE; c++) { 
                //if the current square is empty it makes the coordinate of the current square
                if (grid[r][c]==0){
                    return new int[]{r, c};  
                }
            }
        }
        //if there are no empty squares left it picks coordinate (-1,-1) and then the program stops
        return new int[]{-1, -1}; 
    }

    void count(int row, int column){
        // TODO
        for(int i = 1; i <= SUDOKU_SIZE; i++ ){
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
        //TODO
        //loop which runs for length of sudoku grid (horizontal)
        for (int r=0; r<SUDOKU_SIZE; r++) {
            //loop which runs for the length of the sudoku grid (vertical)
            for (int c=0; c<SUDOKU_SIZE; c++) {
                //looks if the number at current index is a 0
                if (grid[r][c]==0) {
                    //loop which checks possible solutions for this index between 1 and 9
                    for (int d = SUDOKU_MIN_NUMBER; d <= SUDOKU_MAX_NUMBER; d++) {
                        //if the number does not give a conflict, the 0 at this index changes to the number
                        if (!givesConflict(r, c, d)) {
                            grid[r][c] = d; //changes 0 in array to the found number
    
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

    void print() {
        //loop which runs for length of sudoku grid (horizontal)
        for(int i = 0; i < SUDOKU_SIZE; i++) {
            //prints horizontal divider between each box
            if (i % 3 == 0) {
                System.out.println("+-----------------+"); //prints horizontal divider
            }
            System.out.print("|"); //prints left edge of the grid
            //loop which runs for the length of the sudoku grid (vertical)
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                //prints the right edge of each box with the number left to the right edge
                if (j == 2 || j == 5 || j == 8) {
                    //if the current index is a 0, it prints an empty spot and a |
                    if(grid[i][j] == 0){
                        System.out.print(" " + "|"); 
                    //if this is not the case, it prints the number at the index and a |
                    } else {
                    System.out.print(grid[i][j] + "|");
                    }
                //prints left asteriks indication with the number in the asteriks
                } else if((((i == 1 || i == 7) && j == 3) || ((i == 2 || i == 6) && j == 1) || (i == 4 && (j == 0 || j == 3 || j == 6)))) {
                    //if the current index is a 0, it prints an empty spot and a >
                    if(grid[i][j] == 0){
                        System.out.print(" " + ">"); 
                    //if this is not the case, it prints the number at the index and a >
                    } else {
                    System.out.print(grid[i][j] + ">");
                    }
                //prints right asteriks indication with the number in the asteriks
                } else if ((((i == 1 || i == 7) && j == 4) || ((i == 2 || i ==  6) && j == 6) || (i == 4 && (j == 1 || j == 4 || j == 7)))) {
                    //if the current index is a 0, it prints an empty spot and a <
                    if(grid[i][j] == 0){
                        System.out.print(" " + "<"); 
                    //if this is not the case, it prints the number at the index and a <
                    } else {
                    System.out.print(grid[i][j] + "<");
                    }
                //prints all the other numbers for which the above does not apply
                } else { 
                    //if the current index is a 0, it prints an empty spot with a space
                    if(grid[i][j] == 0){
                        System.out.print(" " + " "); 
                    //if this is not the case, it prints the number at the index and a space
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
        (new SudokuSolver()).solveIt();
    }
}