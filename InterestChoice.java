/**
 * @author Ilse
 * @date 04/09/2020
 * Interest Choice ex.2.1
 */

import java.util.Scanner;

 public class InterestChoice { 
    Scanner sc = new Scanner(System.in);

    public void calcInterestChoice() {
        double balance;
        System.out.println("Give balance");
        balance = sc.nextDouble();
        if (balance>=10000) {
            balance=((balance * 3.0 / 100.0) + balance);
            System.out.println("After a year your balance will be " + balance);
        } else if (balance>=0) {
            balance=((balance * 2.5 / 100.0) + balance);
            System.out.println("After a year your balance will be " + balance);
            } else if (balance<=0) {
                    balance=((balance * 0.95 / 100.0) + balance);
                    System.out.println("After a year your balance will be " + balance);
                }
        }
        public static void main(String[] args) {
            ( new InterestChoice() ).calcInterestChoice();
        }

    }
