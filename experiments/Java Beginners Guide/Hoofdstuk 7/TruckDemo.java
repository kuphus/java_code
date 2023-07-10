 /* Vehicle class will be extended by Truck class
  */
  
class Vehicle{
  private int passengers;       // number of passengers.
  private int fuelcap;          // fuel capacity in gallons.
  private int mpg;              // fuel consumption in miles per gallon.

  //Constructor for Vehicle.
  Vehicle(int p, int f, int m){
    passengers = p;
    fuelcap = f;
    mpg = m;
  }

  //Return the range.
  int range(){
    return mpg * fuelcap;
  }
  
  //Compute fuel needed for a given distance.
  double fuelneeded(int miles){
    return (double) miles / mpg;
  }
  
  //Accessoe methods for instance variables
  int getPassengers(){ return passengers; }
  void setPassengers(int p){ passengers = p; }
  int getFuelcap(){ return fuelcap; }
  void setFuelcap(int f){ fuelcap = f; }
  int getMpg(){ return mpg; }
  void setMpg(int m){ mpg = m; }
}

//Extend Vehicle to create a Truck specialization.
class Truck extends Vehicle{
  private int cargocap;     // cargo capacity in pounds
  
  //Constructor for Truck
  Truck(int p, int f, int m, int c){
    // Initialize Vehicle members first using Vehicles constructor
    super(p, f, m);
    //instance variables of Truck
    cargocap = c;
  }
  
  //Accessor methods of Truck
  int getCargo(){ return cargocap; }
  void setCargo(int c){ cargocap = c; }
}

//Extend Vehicle to create an Off-road vehicle class
class Offroad extends Vehicle{
  private int groundClearance;         // ground clearance in inches
  //etc, etc.
}

//main class
class TruckDemo{
  public static void main(String[] args){
  
    //Construct some trucks
    Truck semi = new Truck(2, 200, 7, 44000);
    Truck pickup = new Truck(3, 28, 15, 2000);
    double gallons;
    int dist = 252;
    
    gallons = semi.fuelneeded(dist);
    
    System.out.println("Semi can carry " + semi.getCargo() + " pounds.");
    System.out.println("To go " + dist + " miles semi needs " + gallons + " gallons of fuel.\n");

    gallons = pickup.fuelneeded(dist);

    System.out.println("Pickup can carry " + pickup.getCargo() + " pounds.");
    System.out.println("To go " + dist + " miles pickup needs " + gallons + " gallons of fuel.\n");

  }
}