class Stable {
  Animal animal1;
  
  Stable() {
  } 
  
  void farm() {
    animal1 = new Animal();
    
    animal1.getTrough().fill(4);
    animal1.eat();
    animal1.getTrough().give();
    animal1.eat();
    animal1.getTrough().give();
    
    print();
  }
  
  void print() {
    animal1.print();
  }
  
  public static void main(String[] args) {
    Stable stable = new Stable();
    stable.farm();
  }
}

class Animal {
  String name = "noname";
  int stomach;    // number of meals
  Trough trough; // the trough of this animal
  
  // constructor
  Animal() {
    this.trough = new Trough();
    stomach = 0;
  }
    
  Trough getTrough() {
    return trough;
  } 
  
  void eat() {
    stomach = stomach + 1;
  }
  
  void print() {
    System.out.printf("Animal %s has eaten %d meals.\n", name, stomach); 
    trough.print();
  }
}

class Trough {
  int contents; // number of meals
  
  Trough() {
    this.contents = 0;
  }
  
  void fill(int m) {
    contents = contents + m;
  }
  
  void give() {
    contents = contents - 1;
  }
  
  void print() {
    System.out.printf("The trough still has %d servings.\n", contents);
  }
}


