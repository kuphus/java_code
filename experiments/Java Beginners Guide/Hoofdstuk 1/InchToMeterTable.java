/* 
 * This program has a conversion table
 * of inches to meters.
 */
 
class InchToMeterTable {
  public static void main(String args[]){
    double inch, meter;
    int counter;

    counter = 0;
    for(inch = 1; inch <= 144; inch++){
      // 1 meter is 39.37 inch -> 1 / 39.37 = 0.02540005
      meter = inch * 0.02540005;
      System.out.println(inch + " inches is " + meter + " meter.");

      counter++;
      if(counter == 12){
        System.out.println();
        counter = 0;
      }
    }
  }
}