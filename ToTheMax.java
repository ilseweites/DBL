/**
 * @author Ilse Weites
 * @date 06/09/2020
 * To the max ex.2.2
 */

import java.util.Scanner;

public class ToTheMax {
    Scanner sc = new Scanner(System.in);

        public void calcToTheMax() {
        int x;
        int y;
        int z;

        System.out.println("Give three integers");
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();

        if (x > y && x > z) {
            System.out.println("The maximum value is " + x);
        } else if (x < y && y > z) {
            System.out.println("The maximum value is " + y);
        } else if (x < y && y < z) {
            System.out.println("The maximum value is " + z);
        }
    }
    public static void main(String[] args) {
        (new ToTheMax()).calcToTheMax();
}
}