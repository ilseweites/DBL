
import java.util.Scanner;
import java.util.Random;


public class ApproximatePi {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    public void run(){
        double n;
        double x;
        double y;
        int t = 0;

        System.out.println("How many points taken? ");
        n = sc.nextInt();


        for(int i = 0; i < n; i++){
            x = Math.random();
            y = Math.random();
            if(Math.sqrt((Math.pow(x, 2.0) + Math.pow(y, 2.0))) <= 1){
                t++;
            }
        }
        double pi = (4 * t) / n;
        
        System.out.println(String.format("Pi equals %.12f", pi));
    }




    public static void main(String[]args){
        (new ApproximatePi()).run();
     }
}

