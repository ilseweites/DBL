/**
 * Circle
 * by Ilse Weites 1563343
 * and Marlou Hoogstraate 1564870
 * as group 119
 */
import java.util.Scanner; //imports scanner function
 
class Circle {
    Scanner sc = new Scanner(System.in); //defines scanner
 
    public void run() {
        //TODO implement the program for the assignment
            double xM1; //x-coordinate middlepoint circle 1
            double yM1; //y-coordinate middlepoint circle 1
            double r1; //radius circle 1
            double xM2; //x-coordinate middlepoint circle 2
            double yM2; //y-coordinate middlepoint circle 2
            double r2; //radius circle 2
            double xP; //x-coordinate point
            double yP; //y- ooordinate point
            double dMp1; //distance between middlepoint circle 1 and the given point
            double dMp2; //distance between middlepoint circle 2 and the given point
            double dXmP1; //distance x-coordinate middlepoint circle 1 and x-coordinate given point
            double dYmP1; //distance y-coordinate middlepoint circle 1 and y-coordinate given point
            double dXmP2; //distance x-coordinate middlepoint circle 2 and x-coordinate given point
            double dYmP2; //distance y-coordinate middlepoint circle 2 and y-coordinate given point
 
            xM1 = sc.nextDouble(); //reads given input for x-coordinate circle 1
            yM1 = sc.nextDouble(); //reads given input for y-coordinate circle 1
            r1 = sc.nextDouble(); //reads given input for radius circle 1
            xM2 = sc.nextDouble(); //reads given input for x-coordinate circle 2
            yM2 = sc.nextDouble(); //reads given input for y-coordinate circle 2
            r2 = sc.nextDouble(); //reads given input for radius circle 2
            xP = sc.nextDouble(); //reads given input for x-coordinate given point
            yP = sc.nextDouble(); //reads given input for y-coordinate given point
            
            dXmP1 = Math.pow(xP - xM1, 2); //calculates distance x-coordinates
            dYmP1 = Math.pow(yP - yM1, 2); //calculates distance y-coordinates
            dMp1 = Math.sqrt(dXmP1 + dYmP1); //calculates distance middlepoint circle 1 and point
 
            dXmP2 = Math.pow(xP - xM2, 2); //calculates distance x-coordinates
            dYmP2 = Math.pow(yP - yM2, 2); //calculates distance y-coordinates
            dMp2 = Math.sqrt(dXmP2 + dYmP2); //calculates distance middlepoint circle 2 and point
 
            if(r1<=0 && r2<=0 || r1<=0 && r2>0 || r1>0 && r2<=0) {
                System.out.println("input error"); //radius can't be smaller than 0 otherwise it will print error
            } else if (dMp1 <= r1 && dMp2 <= r2) { //point lies within both circles
                System.out.println("The point lies in both circles"); //prints that point lies in both circles
                } else if (dMp1 <= r1 && dMp2 > r2) { //point lies in first circle
                    System.out.println("The point lies in the first circle"); //prints that point lies in circle1
                     } else if (dMp1 > r1 && dMp2<= r2) { //point lies in second circle
                         System.out.println("The point lies in the second circle"); //prints that point lies in circle2
                         } else if (dMp1 > r1 && dMp2 > r2) { //point lies in neither circle
                            System.out.println("The point does not lie in either circle"); //prints that point lies in no circle
                }
            }
        //END TODO
        
 
    public static void main(String[] args) {
        (new Circle()).run();
    }
}

