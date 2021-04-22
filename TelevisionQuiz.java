import java.util.Scanner;

import jdk.internal.jshell.tool.resources.l10n;

import java.util.Random;

public class TelevisionQuiz {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public void run() {
        int box1;
        int box2;
        int box3;
        int n;

        System.out.println("How many tries ");
        n = sc.nextInt();
        box1 = 0;
        box2 = 0;
        box3 = 0;

        for(int i = 0; i < n; i++){
            box1 = (int) (Math.round(Math.random()));
            if (box1 == 1) {
                box1 = 1;
                box2 = 0;
                box3 = 0;
            } else {
                box2 = (int) (Math.round(Math.random()));
            } if (box2 == 1) {
                box1 = 0;
                box2 = 1;
                box3 = 0;
            } else {
                box1 = 0;
                box2 = 0;
                box3 = 1;
            }
        
        System.out.println(box1 + " " + box2 + " " + box3);
        }
    }
    public static void main(String[]a) {
        (new TelevisionQuiz()).run();
    }
}
