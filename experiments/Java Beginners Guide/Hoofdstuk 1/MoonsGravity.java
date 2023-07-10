/* This program calculates your effective weight on the moon.
 *
 */
 
class MoonsGravity {
  public static void main(String args[]){
    double weight;               //holds weight on earth in kilos
    double moonWeight;           //holds weight on moon in kilos

    weight = 82;
    moonWeight = weight * 0.17;  //converts weight to monweight
    
    System.out.println("Your weight of " + weight + " kilos would give you an effective weight on the moon of " + moonWeight + " kilos.");
  }
}