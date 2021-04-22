public class StarWriter {

    public String letter = "*";

    public void printStars(int numStars) {
        for (int i = 0; i < numStars; i++){
            letter = letter + "*";
        }
    }
    public void nl() {
        System.out.println();
    }

    public void printSpaces(int n) {
        String spaces = " ";
        for(int i = 0; i < n; i++) {
            spaces = spaces + " ";
        }
        System.out.printf(spaces);
    }
    public void printH() {
        letter = letter.replace("*", "H");
        printStars(3); printSpaces(3); printStars(3); nl();
        printStars(3); printSpaces(3); printStars(3); nl();
        printStars(10); nl();
        printStars(10); nl();
        printStars(3); printSpaces(3); printStars(3); nl();
        printStars(3); printSpaces(3); printStars(3); nl();
    }

    public void printE() {
        letter = letter.replace("*", "E");
        printStars(10); nl();
        printStars(3); nl();
        printStars(6); nl();
        printStars(3); nl();
        printStars(3); nl();
        printStars(10); nl();
    }

    public void printL() {
        letter = letter.replace("*", "L");
        printStars(3); nl();
        printStars(3); nl();
        printStars(3); nl();
        printStars(3); nl();
        printStars(10); nl();
        printStars(10); nl();
    }

    public void printO() {
        letter = letter.replace("*", "O");
        printStars(10); nl();
        printStars(10); nl();
        printStars(3); printSpaces(3); printStars(3); nl();
        printStars(3); printSpaces(3); printStars(3); nl();
        printStars(10); nl();
        printStars(10); nl();
    }

    public void write() {
        printH(); nl();
        printE(); nl();
        printL(); nl();
        printL(); nl();
        printO();
        }
    public static void main(String[] args) {
        (new StarWriter()).write();
    }
}
