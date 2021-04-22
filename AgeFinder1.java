/**
 * @IlseWeites
 * @01/09/2020
 * 
 */
public class AgeFinder1 {
    int dateOfBirth = 19930623;
    int currentDate = 20140524;

    void show(){
        System.out.println("You are " + (currentDate-dateOfBirth)/10000 + " years old");
    }
        public static void main(String[] args) {
            (new AgeFinder1()).show();
        }
    
}
