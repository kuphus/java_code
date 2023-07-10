/* 
 * make the 99 bottles of beer song
 */
 
class beerSong2{
  public static void main(String[] args){
    
    int beerCounter = 99; //beer counter
    String bottles = "bottles";

    // lyrics are the same until 2 bottles remain
    while(beerCounter > 0){
      if(beerCounter == 1){
        bottles = "bottle";
      }
      System.out.println(beerCounter + " " + bottles + " of beer on the wall, " + beerCounter + " " + bottles + " of beer.");

      if((beerCounter-1) >=1){
        if((beerCounter-1) == 1){
          bottles = "bottle";
        }
        System.out.println("Take one down and pass it around, " + (beerCounter-1) + " " + bottles + " of beer on the wall.");
      }

      if((beerCounter-1) == 0){
        System.out.println("Take one down and pass it around, no more bottles of beer on the wall.");
      }
      System.out.println();    // empty line after each verse
      beerCounter--;           //decrement
    }

    //at this point beerCounter = 0
    if(beerCounter == 0){    // slight variation in lyrics
      System.out.println("No more bottles of beer on the wall, no more bottles of beer.");
      System.out.println("Go to the store and buy some more, 99 bottles of beer on the wall.");
      System.out.println();    // empty line after each verse
    }
  }
}
