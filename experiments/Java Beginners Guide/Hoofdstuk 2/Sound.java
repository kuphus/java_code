/*
 * This program computes how far away, in feet,
 * a listener is from a lightning strike.
 */
 
class Sound {
  public static void main(String args[]){
    int soundSpeed = 1100;           // Holds the speed of sound in feet per second
    double distance;          // Holds de distance of the lightning strike
    double interval = 7.2;          // Holds the time interval in seconds

    distance = soundSpeed * interval;    // Distance is the speed of sound in seconds times the time interval.
    System.out.println("The lightning strike is " + distance + " feet away.");
  }
}