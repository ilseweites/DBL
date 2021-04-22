import java.util.Arrays;

public class Bubble {
    int length = 99;
    int lengthDivided;
    int newLength;
    boolean[] cyclists;
    boolean[] testGroup1;
    boolean[] testGroup2;
    double infectedD;

    void pickRandomCyclist() {
        infectedD = Math.random() * ((100 - 0) + 1) + 0;
        int infectedInt = (int) infectedD;
        if (infectedInt < 100) {
            testGroup1[infectedInt] = true;
            cyclists[infectedInt] = true;
        }
        System.out.println(infectedInt);
    }

    void divideInGroups() {
        while (cyclists.length > 1) {
        for(int i = 0; i < 7; i++) {
            lengthDivided = length/2;
            testGroup1 = Arrays.copyOfRange(cyclists, 0, lengthDivided);
            testGroup2 = Arrays.copyOfRange(cyclists, lengthDivided, length);
            length = lengthDivided;

            for(int t = 0; t < lengthDivided; t++) {
                if (testGroup1[t] == true) {
                    cyclists = testGroup1;
                } else {
                    cyclists = testGroup2;              
            } 
            System.out.println(Arrays.toString(cyclists));   
        }
    }
}
}















    void run() {
        pickRandomCyclist();
        divideInGroups();
    }

    public static void main(String[] args) { 
        new Bubble().run();
      }
}
