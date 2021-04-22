import java.util.Scanner;

public class TemperatureConversion {
    
    public static void run () {
        Scanner sc = new Scanner(System.in);
        String choice;
        double fahrenheit;
        double celsius; 
        double n = 0;

        for(int i = 0; i < n; i++) {
            System.out.println("Give a temperature in Celsius or Fahrenheit or type q to quit");
            choice = sc.next();

            if (choice.contains("q") ) {
                break;
            } else if (choice.contains("C") && sc.hasNextDouble()) {
                celsius = sc.nextDouble();
                fahrenheit = celsius/1.8 + 32;
                String.format("The temperature in Fahrenheit is %.1f", fahrenheit);
            } else if (sc.hasNextDouble()) {
                fahrenheit = sc.nextDouble();
                celsius = (fahrenheit - 32)/1.8;
                String.format("The temperature in Celsius is %.1f", celsius);
            }
        }
    }
    
    public static void main(String[]a) {
        (new TemperatureConversion()).run();
    }    
}
