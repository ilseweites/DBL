/**
 * @IlseWeites
 * @02/09/2020
 * 
 */
public class LeapYear {
    void show () {
        int year=2400;
        boolean LeapYear = (year%4==0 && year%100==0 && year%400==0);

        if (LeapYear) {
            System.out.println("The year " + year + " is a leap year");
        }
        else {
            System.out.println("The year " + year + " is not a leap year");
        } 
}
    public static void main (final String[] args) {
        (new LeapYear()).show();
    }
}
