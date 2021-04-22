/**
 * @IlseWeites
 * @01/09/2020
 * interest calculation
 */

import java.util.Scanner;

class Interest {
    Scanner sc = new Scanner(System.in);
    
    public void calcInterest() {        
        double balance;  
        double rate;  // percentage 
        double tax;
        double newBalance;
        System.out.println("Give balance");
        balance = sc.nextDouble();
        System.out.println("Your balance is" + balance);
        System.out.println("Give interest rate as percentage ");
        rate = sc.nextDouble();
        
        System.out.print("After a year your balance will be: " +
                          ((balance * rate / 100.0) + balance) );
        System.out.println("Give tax");
        tax = sc.nextDouble();
        newBalance = ((balance * rate / 100.0) + balance);
        System.out.print("After a year you will have to pay: " +
                          (newBalance * tax / 100.0) + "as tax." );

    }
    
    public static void main(String[] args) {
        ( new Interest() ).calcInterest();
    }
}
