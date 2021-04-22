import java.util.Scanner;

public class PieceOfCake {
    Scanner sc = new Scanner(System.in);

    public void run() {
        double piAproxx = 4.0;
        double iterations = 0.0;
        int i = 0;

        System.out.println("Give number of iterations");
        int n = sc.nextInt();

        while (i < n) {
            piAproxx = 4 + (Math.pow((-1), n) * 4) / (3 + 2 * (n - 1));
            i = i + 1;
        }
        System.out.println("Pi approximates " + piAproxx);
    }

    public static void main(String[]args){
        (new PieceOfCake()).run();
     }

}
