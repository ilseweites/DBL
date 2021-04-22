class Vehicle {
  int registrationNumber;

  Vehicle(int registrationNumber) {
    this.registrationNumber = registrationNumber;
  }
  
  class Car {
    String fuelType;
    String vehicleType;
    
    Vehicle(String fuelType, String vehicleType) {
      this.fuelType = fuelType;
      this.vehicleType = vehicleType;
    }
  }
  
  @Override
  public String toString() {
    return "Vehicle with reg.nr. " + registrationNumber;
    return "Vehicle type : " + vehicleType;
    return "Fuel type: " + fuelType;
  }
}