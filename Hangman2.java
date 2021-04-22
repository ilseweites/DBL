// Hangman TEMPLATE
// Homework Assignment 2 2ip90 
/**
 * @Ilse Weites & Marlou Hoogstraate //TODO
 * @1563343 & 1564870   //TODO
 * @119   //TODO
 * @10/09/2020   //TODO
 */

import java.util.Random;
import java.util.Scanner;

class Hangman2 {
  Scanner scanner = new Scanner(System.in);
  
  void play(){
    //Secret words
    String[] bagOfWords = new String[]{"the", "walrus", "and", "carpenter", "were", "walking", "close", "at", "hand"};
    
    //Initialize the random number generator
    System.out.println("Type an arbitrary number");
    int seed = scanner.nextInt();
    Random random = new Random(seed);
    
    //Select a secret word
    String secret = bagOfWords[random.nextInt(bagOfWords.length)];
    
    // TODO Insert your code here 
    int falseAttempts = 0; //amount of false attempts
    char[] emptySecretWord = new char[secret.length()];
    char[] secretWord = secret.toCharArray();

    for(int i = 0; i < secret.length(); i++) {
      emptySecretWord[i] = '_';
    }

    System.out.println(emptySecretWord);


    while (falseAttempts < 10) {
      char letter = scanner.next().charAt(0);

      for(int i = 0; i < secret.length(); i = i + 1) {
        if(secret.indexOf(letter) != -1) {
          int position = secret.indexOf(letter);
          int position2 = secret.lastIndexOf(letter);
          emptySecretWord[position] = letter;
          emptySecretWord[position2] = letter;
          System.out.println(emptySecretWord);
        } else {
          falseAttempts = falseAttempts + 1;
          System.out.println(emptySecretWord);
        }

        }
        if (emptySecretWord.equals(secretWord)) {
          System.out.println("Well done, you won!");
        }

        if (falseAttempts >= 10) {
          System.out.println("Unlucky, you lost!");
          System.out.println("The secret word was: " + secret);
        }
      }

    }
  
    
  public static void main(String[] args) { 
    new Hangman2().play();
  }
}
