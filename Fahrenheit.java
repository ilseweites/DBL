/**
 * @IlseWeites
 * @02/09/2020
 * 
 */
import java.util.Scanner;

public class Fahrenheit {
    Scanner sc = new Scanner(System.in);
    public void calcInterest() { 
        double Fahrenheit;
        double Celsius;

        System.out.println("Give temperature in Fahrenheit");
        Fahrenheit = sc.nextDouble();

        Celsius = (Fahrenheit - 32) / 1.8;

        System.out.println("The temperature in Celsius is " + Celsius);
    }

    public static void main(String[] args) {
        ( new Fahrenheit() ).calcInterest();
    }
}
