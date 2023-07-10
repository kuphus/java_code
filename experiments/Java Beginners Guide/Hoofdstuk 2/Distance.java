/*
 * This program computes your distance to a large object.
 *
 */

class Distance {
  public static void main(String args[]){
    int soundSpeed = 1100;          // Holds the speed of sound in feet per second
    double distance;                // Holds de distance of the object
    double interval = 7.2;          // Holds the time interval in seconds

    distance = (soundSpeed * interval)/2;    // Distance is the speed of sound in seconds times the time interval. Since this computes the round-trip time, it is divided by two for a one way distance.
    System.out.println("The lightning strike is " + distance + " feet away.");
  }
}