import java.util.Scanner;

public class Product {
    Scanner sc=new Scanner(System.in);
    int number;//numberjustread
    int multiplication;
    int entered;

    public void run() {
        entered = 0;
        multiplication = 1;
        System.out.println("Type your numbers, terminated by a 0");
        while (sc.hasNextInt()) {
            number = sc.nextInt();
            if (number != 0) {
            multiplication *= number;
            entered++;
            } else if(number == 0) {
            break;
        }
        }

        System.out.println("Multiplication is "+ multiplication );
        System.out.println("The amount of numbers entered is " + entered);
    }

    public static void main(String[]a) {
        (new Product()).run();
    }
}
