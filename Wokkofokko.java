/**
 * @author Jan Heemstra
 * Homework assignment, with comments for explanation.
 */

import java.util.Scanner;

public class Wokkofokko {
    Scanner scanner = new Scanner(System.in);
    
    int l;//The length of the row of cells
    int g;//The number of generations to be displayed
    boolean[] row;//The row that is currently in use
    boolean[] newRow;//The buffer row that is used to store each new row before applying it
    boolean[] universalRule;//Rules the system adheres to
    
    void queryLG() {//Assign values to L and G, and initiate boolean array
        l = scanner.nextInt();
        g = scanner.nextInt();
        row = new boolean[l+2];
        
        scanner.next();//User will input init_start
        
        int i;
        while(scanner.hasNextInt()) {
            i = scanner.nextInt();
            if (i > l) {
                break;//Avoid out of bounds exceptions (also thank heaven this is not C)
            }
            row[i] = true;
        }
        scanner.next();//User will input init_end
    }
    
    void universalItem(int i) {//locates what rule to apply to row[i]
        int index = 0;//Binary index to locate right rule to apply
        if (row[i+1]) {
            index += 1;
        }
        if (row[i]) {
            index += 2;
        }
        if (row[i-1]) {
            index += 4;
        }
        newRow[i] = universalRule[index];//applies rule in row buffer
    }
    
    void universalRow() {
        newRow = new boolean[l+2];
        for(int i = 1; i <= l; i++) {//print one row
            if (row[i]) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            
            universalItem(i);
        }
        for(int i = 1; i <= l; i++) {//Copy buffer into active row.
            row[i] = newRow[i];//TODO optimize by switching active row to buffer row
        }
        System.out.println();//start a new line for the next row
    }

    void modeA() {//code for mode A
        queryLG();//Query L and G
        universalRule = new boolean[8];//describe A through universal automation
        universalRule[1] = true;
        universalRule[3] = true;
        universalRule[4] = true;
        universalRule[5] = true;
        universalRule[6] = true;
        for(int i = 0; i < g; i++) {//Compute all rows
            universalRow();
        }
    }
    
    void modeB() {//code for mode B
        queryLG();//Query L and G
        universalRule = new boolean[8];//describe B through universal automation
        universalRule[1] = true;
        universalRule[2] = true;
        universalRule[4] = true;
        universalRule[6] = true;
        for(int i = 0; i < g; i++) {//Compute all rows
            universalRow();
        }
    }
    
    void queryU() {
        universalRule = new boolean[8];
        for(int i = 0; i < universalRule.length; i++) {//Save universal automation data to universalRule array
            int j = scanner.nextInt();
            if (j == 1) {
                universalRule[i] = true;
            }
        }
    }
    
    void modeUniverse() {
        queryLG();//Query L and G
        queryU();//Query universal automation
        for(int i = 0; i < g; i++) {//Compute all rows
            universalRow();
        }
    }
    
    void start() {
        String mode = scanner.next();//Query the mode in which the program runs
        // Initiate right automation according to input
        if(mode.equals("A")) {
            modeA();
        } else if (mode.equals("B")) {
            modeB();
        } else {
            modeUniverse();
        }
    }
    
    static public void main(String[] Args) {
        new Wokkofokko().start();
    }
}
