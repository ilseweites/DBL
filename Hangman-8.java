/**
 * Hangman
 * by Ilse Weites 1563343
 * and Marlou Hoogstraate 1564870
 * as group 119
 */

import java.util.Random;
import java.util.Scanner;

class Hangman {
    Scanner scanner = new Scanner (System.in);

    void play() {
        String letter; // The given letter
        int index; // Location of the given letter in secret word
        int falseAttempts; //False attempts
        
        //secret words
        String [] bagOfWords = new String[]{"the", "walrus", "and", "carpenter", "were", "walking", "close", "at", "hand" };

        //Initialize the random number generator
        System.out.println("Type an arbitrary number");
        int seed = scanner.nextInt();
        Random random = new Random (seed);

        //Select a secret word
        String secret = bagOfWords[random.nextInt(bagOfWords.length)];
        
        //TODO Insert your code here
        String secretUnderscore = secret.replaceAll(".", "_"); //Secret word in underscore
        System.out.println(secretUnderscore); //Print secret word in underscore
        
        falseAttempts=0; //Amount of false attempts at the start of the game

        //This loop looks for each given letter if it is in the secret word and checks it location
        //and it stops when more than 10 false attempts are made
        while (falseAttempts < 10) {     
             letter = scanner.next(); //Reads the given letter
             index = 0; //Index starts at 0
                 //Checks if the letter is in the word multiple times
                 while (index >=0){
                     index = secret.indexOf(letter,index); //Finds location of the letter
                     //If the letter is in the word it changes the underscore for the letter
                     if (index >=0){
                         secretUnderscore = secretUnderscore.substring(0, index) 
                                          + letter
                                          + secretUnderscore.substring(index + 1); 
                         index++;
                          //If the letter is not in the word it counts the false attempts
                         }else if (secret.indexOf(letter) == -1){
                             falseAttempts++;

                         }
                     }
            
             //It print the interim score 
             if (falseAttempts != 10) {
                System.out.println(secretUnderscore); //prints the alteration of the letters
             }

             //If all the given letters are found it prints victory message
             if (secret.equals(secretUnderscore)) {
                 System.out.println("Well done, you won!");
                 break; //stops the program when you have won

             }
             //If there are more then 10 false attempt it prints loser message
             else if (falseAttempts==10){
                 System.out.println("Unlucky, you lost!");
                 System.out.println("The secret word was: " + secret);
             } 
         }       
     }

    public static void main(String[] args) {
        (new Hangman()).play();
    }
}
