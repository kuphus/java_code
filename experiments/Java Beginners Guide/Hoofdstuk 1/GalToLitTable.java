/*
 * Try This 1-2
 * This program has a conversion table from gallons to liters.
 * Call this program GalToLitTable.java
 */
class GalToLitTable {
  public static void main(String args[]){
    double gallons, liters;  //holds the number of gallons and liters
    int counter;             //line counter

    counter = 0;             //initialize counter
    for(gallons = 1; gallons <= 100 ; gallons++){
      liters = gallons * 3.7854;    //convert to liters
      System.out.println(gallons + " gallons is " + liters + " liters.");

      counter++;           //increment line counter
      if(counter == 10){
        System.out.println();     //print empty line every 10 lines
        counter = 0;     //reset line counter
      }
    }
  }
}