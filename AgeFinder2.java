/**
 * @IlseWeites
 * @02/09/2020
 * Age finder exercise 1.6 Find your age!
 */
import java.util.Scanner;

public class AgeFinder2 {
    Scanner sc = new Scanner(System.in);
    int dateOfBirth;
    int currentDate;
    int age;

    void show(){
        System.out.println("Give date of birth yyyymmdd");
        dateOfBirth = sc.nextInt();
        System.out.println("Give current date yyyymmdd");
        currentDate = sc.nextInt();
        age = (currentDate-dateOfBirth)/10000;
        System.out.println("You are " + age + " years old");
    }
        public static void main(String[] args) {
            (new AgeFinder2()).show();
        }
    
}

