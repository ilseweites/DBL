// Cellulitis TEMPLATE
// Homework Assignment 3 2ip90 
/**
 * @name(s) Casper Bloemhof, Lisa Verhoeven
 * @id(s)   //1569473, 1576607
 * @group   //36?
 * @date    20sept2020
 */

import java.util.Scanner;
import java.util.Arrays;

class Cellulitis2 {
  Scanner scanner = new Scanner(System.in);

  String letter;
  int L;
  int G;
  boolean[] currentGeneration; //boolean array for initial storing false/true elements
  boolean[] nextGeneration; //boolean array for storing element for next line
  char[] firstGenerationStar; //char array to print the stars/paces according to input
  char[] nextGenerationStar; //char array to print the next line of stars/spaces
  int startPosition;

  char[] starSpace = new char[8]; //making array to convert universal pattern input to stars/spaces
  boolean[] booleans = new boolean[8]; //making array to convert stars/spaces to true/false, respectively

  void readInput(){ // void to read letter, L and G from input + assigning lengths to arrays
    letter = scanner.next();
    L = scanner.nextInt();
    currentGeneration = new boolean[L + 2];
    firstGenerationStar = new char[L];
    nextGeneration = new boolean[L + 2];
    nextGenerationStar = new char[L];
    G = scanner.nextInt();
  }

  void drawFirstGeneration(){ // void to print the stars/spaces from initial input
    if (scanner.next().equals("init_start")) {
      Arrays.fill(firstGenerationStar, ' '); //fill empty spots in array with spaces to prevent having no initial spaces
      while (scanner.hasNextInt()) {
      startPosition = scanner.nextInt();
       if (startPosition>L) { //ignore integer(s) that is/are out of bounds
        break;
      }
      currentGeneration[startPosition] = true; //changing elements at given initial positions to true
      firstGenerationStar[startPosition - 1] = '*'; //changing spaces in array to stars at given positions
      }
    }
    System.out.println(firstGenerationStar);
  } 


  void initialArraysForU(){ //converting the patterns(0's and 1's) from input to elements in arrays
    if (scanner.next().equals("init_end")) {
    for (int i = 0; i < 8; i++){ //setting up array with stars/spaces 
    int binary = scanner.nextInt(); //reading the 0's and 1's from input after "init_end"
    if (binary == 1) {
      starSpace[i] = '*';
      } else if (binary == 0) {
        starSpace[i] = ' ';
      }
    }
  }

  for (int i = 0; i < starSpace.length; ++i) { //setting up array with true/false instead of star/space
    if (starSpace[i] == '*') {
      booleans[i] = true;
    } else if (starSpace[i] == ' ') {
      booleans[i] = false;
    }
  }
}
  void drawGenU() { //void to print changes
    for (int t = 0; t < L; t++) { //call to if-statements for every cell
      extractedU(t); 
  }
  for (int i = 0;i < L+1; i++) { //let the next generation be the current generation in the next step
    currentGeneration[i] = nextGeneration[i];
  }
  System.out.println(nextGenerationStar);
}

    void extractedU(int t) { //void in order to change elements according to patterns
      if (currentGeneration[t + 1] == true) {
        if (currentGeneration[t] == false && currentGeneration[t + 2] == false) {
          nextGeneration[t + 1] = booleans[2]; 
          nextGenerationStar[t] = starSpace[2];
        } else if (currentGeneration[t] == false && currentGeneration[t+2] == true) {
          nextGeneration[t + 1] = booleans[3];
          nextGenerationStar[t] = starSpace[3];
        } else if (currentGeneration[t] == true && currentGeneration[t+2] == false) {
          nextGeneration[t + 1] = booleans[6];
          nextGenerationStar[t] = starSpace[6];
        } else if (currentGeneration[t] == true && currentGeneration[t+2] == true) {
          nextGeneration[t + 1] = booleans[7];
          nextGenerationStar[t] = starSpace[7];
        }
      } else if (currentGeneration[t + 1] == false) {
        if (currentGeneration[t] == false && currentGeneration[t + 2] == false) {
          nextGeneration[t + 1] = booleans[0];
          nextGenerationStar[t] = starSpace[0];
        } else if (currentGeneration[t] == false && currentGeneration[t+2] == true) {
          nextGeneration[t + 1] = booleans[1];
          nextGenerationStar[t] = starSpace[1];
        } else if (currentGeneration[t] == true && currentGeneration[t+2] == false) {
          nextGeneration[t + 1] = booleans[4];
          nextGenerationStar[t] = starSpace[4];
        } else if (currentGeneration[t] == true && currentGeneration[t+2] == true) {
          nextGeneration[t + 1] = booleans[5];
          nextGenerationStar[t] = starSpace[5];
        }
      }
    }

    void drawU() { //call void to print changes for every every generation
      for(int i = 0; i < (G - 2); i++) {
        drawGenU();
      }
    }

  void drawNextGenA(){
      for(int t = 0; t < L; t++) {
        extractedA(t);
      }
      for (int i = 0;i< L+1; i++) {
        currentGeneration[i] = nextGeneration[i];
      }
      System.out.println(nextGenerationStar);
    }

    void extractedA(int t) {
        if (currentGeneration[t + 1] == true) {
          if(currentGeneration[t] == true ^ currentGeneration[t + 2] == true) {
            nextGeneration[t + 1] = true;
            nextGenerationStar[t] = '*';
          } else {
            nextGeneration[t + 1] = false;
            nextGenerationStar[t] = ' ';
          }
        } else if (currentGeneration[t + 1] == false) {
          if(currentGeneration[t] == false && currentGeneration[t + 2] == false) {
            nextGeneration[t + 1] = false;
            nextGenerationStar[t] = ' ';
          } else {
            nextGeneration[t + 1] = true;
            nextGenerationStar[t] = '*';
        }
      }
    }
      
  void drawA() {
    for(int i = 0; i < (G - 2); i++) {
      drawNextGenA();
    }
  }

  void drawNextGenB(){
    for(int t = 0; t < L; t++) {
      extractedB(t);
    }
    for (int i = 0;i< L+1; i++) {
      currentGeneration[i] = nextGeneration[i];
    }
    System.out.println(nextGenerationStar);
  }

  void extractedB(int t) {
    if (currentGeneration[t + 1] == true) {
      if(currentGeneration[t + 2] == true) {
        nextGeneration[t + 1] = false;
        nextGenerationStar[t] = ' ';
      } else if (currentGeneration[t + 2] == false) {
        nextGeneration[t + 1] = true;
        nextGenerationStar[t] = '*';
      }
    } else if (currentGeneration[t + 1] == false) {
      if(currentGeneration[t] == true ^ currentGeneration[t + 2] == true) {
        nextGeneration[t + 1] = true;
        nextGenerationStar[t] = '*';
      } else {
        nextGeneration[t + 1] = false;
        nextGenerationStar[t] = ' ';
      }
    }
 }
void drawB() {
  for(int i = 0; i < (G - 2); i++) {
    drawNextGenB();
  }
}

  void run(){ //void to determine the automaton that should be executed
    // TODO Insert your code here
    readInput();
    drawFirstGeneration();
    if (letter.equals("A")) {
      drawNextGenA();
      drawA();
    } else if (letter.equals("B")) {
      drawNextGenB();
      drawB();
    } else if (letter.equals("U")) {
      initialArraysForU();
      drawGenU();
      drawU();
    }
  }
  
  public static void main(String[] args) { 
    new Cellulitis2().run();
  }
}
