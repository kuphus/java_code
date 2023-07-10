/* code magnets          curly brackets may be added when needed
 * output:
 * bang bang ba-bang
 * ding ding da-ding
 */


 // d.playSnare();
 
 // DrumKit d = new DrumKit();
 
 /* boolean topHat = true;
  * boolean snare = true;
  */
  
 /* void playSnare(){
  *   System.out.println("bang bang ba-bang");
  * }
  */
 
 // public static void main(String[] args){

 /* if(d.snare == true){
  *   d.playSnare();
  * }
  */

 // d.snare = false;

 // class DrumKitTestDrive{

 // d.playTopHat();

 // class DrumKit{

 /* void playTopHat(){
  *   System.out.println("ding ding da-ding");
  * }
  */
  
class DrumKit{
  boolean topHat = true;
  boolean snare = true;

  void playTopHat(){
    System.out.println("ding ding da-ding");
  }
  void playSnare(){
    System.out.println("bang bang ba-bang");
  }
}

class DrumKitTestDrive{
  public static void main(String[] args){
    DrumKit d = new DrumKit();

    
    d.playSnare();
    d.playTopHat();
    
    d.snare = false;
    if(d.snare == true){
      d.playSnare();
    }
  
  }
}