import java.util.Random;

public class Airplane {

    public void run(){
    int passengers = 99;
    boolean[] airplane = new boolean[99];
    int[] emptyAirplane = new int[99];
    int[] waitingPassengers = new int[99];
    int firstSeat = 0;

    Random random = new Random (firstSeat);
    firstSeat = emptyAirplane[random.nextInt(emptyAirplane.length)];
    airplane[firstSeat] = true;
    
    //banaan 
    for(int i = 0; i < 99; i++) {
        if(airplane[i] == false) {
            airplane[i] = true;
        }
        System.out.println();
        }
    }


    public static void main(String[] args) {
        (new Airplane()).run();
    }
}
