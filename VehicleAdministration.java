class VehicleAdministration { 
  Vehicle[] vehicles; 
  Car[] cars;
  
  void administrate() { 
    vehicles = new Vehicle[1]; 
    vehicles[0] = new Vehicle(123); 
    cars = new Car[1];
    cars[0] = new Car("petrol");
    cars[1] = new Car("car");

    printVehicles();  
    printCars(); 
  }
  
  void printVehicles() { 
    for ( Vehicle v : vehicles ) { 
      System.out.println( "--------------------------------" ); 
      System.out.println(v); 
    } 
    
    System.out.println( "--------------------------------" ); 
  } 

  void printCars() {
    for (Car c : cars) {
      System.out.println( "--------------------------------" ); 
      System.out.println(c); 
    }

    System.out.println( "--------------------------------" ); 
  }
  
  public static void main( String[] a ) { 
    VehicleAdministration va = new VehicleAdministration(); 
    va.administrate();
  }
}