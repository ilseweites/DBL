// Cellulitis TEMPLATE
// Homework Assignment 3 2ip90 
/**
 * Circle
 * by Ilse Weites 1563343
 * and Marlou Hoogstraate 1564870
 * as group 119
 * 23/09/2019
 */

import java.util.Scanner;
import java.util.Arrays;

class Cellulitis {
  Scanner scanner = new Scanner(System.in); //defines scanner

  char letter; //first letter of input which indicates which program to run
  int L; //length of the row
  int G; //amount of rows
  boolean[] currentRow; //boolean array of the current row
  boolean[] nextRow; //boolean array of the next row
  char[] firstRowStar; //char array of the first row in stars and spaces
  char[] nextRowStar; //char array of the next rows in stars and spaces
  int startTrue; //position for which the first row has to be true
  char[] uStar = new char[8]; //char array for the universal program in stars and spaces
  boolean[] uBoolean = new boolean[8]; //boolean array for the universal program

  //reads input 
  void readInput(){
    letter = scanner.next().charAt(0); //reads first letter for the programs
    L = scanner.nextInt(); //reads input for the length of the rows
    currentRow = new boolean[L + 2]; //creates current row of length L with two border cells
    firstRowStar = new char[L]; //creates first row in stars and spaces in length L
    nextRow = new boolean[L + 2]; //creates next rows of length L with two border cells
    nextRowStar = new char[L]; //creates next rows in stars and spaces in length L
    G = scanner.nextInt(); //reads input for the amount of rows
  }

  //generates first given row
  void initialRow(){
    //reads input in between init_start and init_end
    if (scanner.next().equals("init_start")) {
      Arrays.fill(firstRowStar, ' '); //fills first row with spaces
      //loop which chekcs if there are still int left
      while (scanner.hasNextInt()) {
        startTrue = scanner.nextInt(); //every next int is saved in startPosition
        //if the read int is higher than the length of the row this int won't be count
        if (startTrue > L) {
          break; //when this happens the program brakes
        }
      currentRow[startTrue] = true; //at the startposition it turns the boolean value from false to true
      firstRowStar[startTrue - 1] = '*'; //changes the spaces at startposition to stars
      }
    }
    System.out.print(firstRowStar); //prints out the first row in stars and spaces
  } 

  //generates first given row for universal program
  void initialRowU(){ 
    //reads input after init_end
    if (scanner.next().equals("init_end")) {
      Arrays.fill(uStar, ' '); //fills first row with spaces
      //loop which runs for the amount of int given
      for (int i = 0; i < 8; i++){ 
        int startValueU = scanner.nextInt(); //every next int is saved in startValueUniversal
        //if the next given int is 1, it prints a star
        if (startValueU == 1) {
          uStar[i] = '*'; //changes the spaces to stars for every given 1 found 
          uBoolean[i] = true; //changes the boolean value at startValueUniversal to true for every given 1 found
        } 
      }
    }
  }

  //generates every new row when given letter is U
  void drawRowsU() { 
    //loop which checks values of boolean array and appoints the true and false value for next row 
    for (int t = 0; t < L; t++) { 
      ifU(t); //calls for if-statements which are stored in void
    }

    //loop which changes the current row to the next row for every new step
    for (int i = 0;i < L+1; i++) { 
      currentRow[i] = nextRow[i]; //current row at position i is changed to the last given next generation
    }
    System.out.println(nextRowStar); //prints out the new rows
  }

  //checks value at index and changes the value index for the next row according to the 8 given patterns
  void ifU(int t) { 
    //if the value at t is true, it checks its neighbouring cells 
    if (currentRow[t + 1] == true) { 
      trueIfU(t); //calls to the nested if-statements to check neighbouring cells
    //if the value at t is false, it checks its neigbouring cells
    } else if (currentRow[t + 1] == false) { 
      falseIfU(t); //calls to the nested if-statements to check neighbouring cells
    }
  }

  //checks value neigbouring cells when current cell is false
  private void falseIfU(int t) {
    //if both neighbours are false, execute pattern 000
    if (currentRow[t] == false && currentRow[t + 2] == false) { 
      nextRow[t + 1] = uBoolean[0]; //takes given value for pattern 000
      nextRowStar[t] = uStar[0]; //changes to space or star at index t
    //if only the right neighbour is true, execute pattern 001
    } else if (currentRow[t] == false && currentRow[t+2] == true) { 
      nextRow[t + 1] = uBoolean[1]; //takes given value for pattern 001
      nextRowStar[t] = uStar[1]; //changes to space or star at index t
    //if only the left neighbour is true, execute pattern 100
    } else if (currentRow[t] == true && currentRow[t+2] == false) { //pattern 100 1
      nextRow[t + 1] = uBoolean[4]; //takes given value for pattern 100
      nextRowStar[t] = uStar[4]; //changes to space or star at index t
    //if both neighbours are true, execute pattern 101
    } else if (currentRow[t] == true && currentRow[t+2] == true) { //pattern 101
      nextRow[t + 1] = uBoolean[5]; //takes given value for pattern 101
      nextRowStar[t] = uStar[5]; //changes to space or star at index t
    }
  }

  //checks value neigbouring cells when current cell is true
  private void trueIfU(int t) {
    //if both neighbours are false, execute pattern 010
    if (currentRow[t] == false && currentRow[t + 2] == false) {
      nextRow[t + 1] = uBoolean[2]; //takes given value for pattern 010
      nextRowStar[t] = uStar[2]; //changes to space or star at index t
    //if only the right neighbour is true, execute pattern 011
    } else if (currentRow[t] == false && currentRow[t+2] == true) {
      nextRow[t + 1] = uBoolean[3]; //takes given value for pattern 011
      nextRowStar[t] = uStar[3]; //changes to space or star at index t
    //if only the left neighbour is true, execute pattern 110
    } else if (currentRow[t] == true && currentRow[t+2] == false) {
      nextRow[t + 1] = uBoolean[6]; //takes given value for pattern 110
      nextRowStar[t] = uStar[6]; //changes to space or star at index t
    //if both neighbours are true, execute pattern 111
    } else if (currentRow[t] == true && currentRow[t+2] == true) {
      nextRow[t + 1] = uBoolean[7]; //takes given value for pattern 111
      nextRowStar[t] = uStar[7]; //changes to space or star at index t
    }
  }
  //draws every generation according to program U
  void drawU() {
    //if the user wants to run program A, B or U
    if (letter == 'A') {
      drawA(); //runs program A
    } else if (letter == 'B'){
      drawB(); //runs program B
    } else {
      initialRowU(); //runs program U for first line
      //loop that runs for the amount of rows, except for the first row
      for(int i = 0; i < (G - 1); i++) {
        drawRowsU(); //calls back to drawOneGenA
     }
    }
  }

  //generates every new row when letter is A
  void drawRowsA(){
      //loop which checks values of boolean array and appoints the true and false value for next row
      for(int t = 0; t < L; t++) {
        ifA(t); //calls for if-statements that are stored in a void
      }
      //loop which changes the current row to the next row for every new step
      for (int i = 0; i < (L + 1); i++) {
        currentRow[i] = nextRow[i]; //current row at position i is changed to the last given next generation
      }
      System.out.println(nextRowStar); //prints out the new rows
  }

  //if statements that check the value at every position and appoint new true or false falue for the next row
  private void ifA(int t) {
    //if the value at t is true, it checks its neighbouring cells
    if (currentRow[t + 1] == true) {
      //if one of the neighbouring cells is true, the cell remains true
      if(currentRow[t] == true ^ currentRow[t + 2] == true) {
        nextRow[t + 1] = true; //current cell remains true
        nextRowStar[t] = '*'; //changes to star at position t
        //if the above is not true, the cell becomes false
      } else {
        nextRow[t + 1] = false; //current cell changes to false
        nextRowStar[t] = ' '; //changes to space at position t
      }
    //if the value at t is false, it checks its neighbouring cells  
    } else if (currentRow[t + 1] == false) {
        //if both neighbouring cells are false, the cell remains false
        if(currentRow[t] == false && currentRow[t + 2] == false) {
          nextRow[t + 1] = false; //current cell remains false
          nextRowStar[t] = ' '; //changes to space at position t
        //if the above is not true, the cell becomes true  
        } else {
          nextRow[t + 1] = true; //changes current cell to true
          nextRowStar[t] = '*'; //changes to star at position t
    }
  }
}
  //draws every generation according to program A
  void drawA() {
    //loop that runs for the amount of rows, except for the first row
    for(int i = 0; i < (G - 1); i++) {
      drawRowsA(); //calls back to drawOneGenA
    }
  }

  //generates every new row when letter is B
  void drawRowsB(){
    //loop which checks values of boolean array and appoints the true and false value for next row
    for(int t = 0; t < L; t++) {
      ifB(t); //calls for if-statements which are stored in void
    }
    //loop which changes the current row to the next row for every new step
    for (int i = 0; i < (L + 1); i++) {
      currentRow[i] = nextRow[i];
    }
    System.out.println(nextRowStar); //prints out the new rows
}

  //if statements that check the value at every position and appoint new true or false falue for the next row
  private void ifB(int t) {
    //if the value at t is true, it checks its neighbouring cells
    if (currentRow[t + 1] == true) {
      //if right neighbouring cell is true, cell becomes false
      if(currentRow[t + 2] == true) {
        nextRow[t + 1] = false; //changes cell to false
        nextRowStar[t] = ' '; //changes to space at position t
        //if the above is not true, the cell remains true
      } else if (currentRow[t + 2] == false) {
        nextRow[t + 1] = true; //cell remains true
        nextRowStar[t] = '*'; //changes to star at position t
      }
     //if the value at t is false, it checks its neighbouring cells 
    } else if (currentRow[t + 1] == false) {
      //if one of the neighbouring cells is true, cell becomes true
      if(currentRow[t] == true ^ currentRow[t + 2] == true) {
        nextRow[t + 1] = true; //changes cell to true
        nextRowStar[t] = '*'; //changes to star at position t
      //if the above is not true, cell remains false 
      } else {
        nextRow[t + 1] = false; //changes cell to false
        nextRowStar[t] = ' '; //changes to space at position t
      }
    }
 }
  //draws every generation according to program A
  void drawB() {
    //loop that runs for the amount of rows, except for the first row
    for(int i = 0; i < (G - 1); i++) {
      drawRowsB(); //calls back to drawOneGenA
    }
  } 
  //prints out new line
  void printLn() {
    System.out.println(); //print new line
  }

  //executes entire program by calling out the previous voids
  void run(){
    // TODO Insert your code here
    readInput(); //calls back to readInput to read the given input
    initialRow(); printLn(); //calls back to draw first generation and then afterwards prints a new line
    //runs program through U
    drawU();
  }
  
  public static void main(String[] args) { 
    new Cellulitis().run();
  }
}
