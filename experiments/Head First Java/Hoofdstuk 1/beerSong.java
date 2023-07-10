/* 
 * make the 99 bottles of beer song
 */
 
class beerSong{
  public static void main(String[] args){
    
    int beerCounter = 99; //beer counter

    // lyrics are the same until 2 bottles remain
    while(beerCounter > 2){
      System.out.println(beerCounter + " bottles of beer on the wall, " + beerCounter + " bottles of beer.");
      System.out.println("Take one down and pass it around, " + (beerCounter-1) + " bottles of beer on the wall.");
      System.out.println();    // empty line after each verse
      beerCounter--;           //decrement
    }
    if(beerCounter == 2){    // slight variation in lyrics
      System.out.println(beerCounter + " bottles of beer on the wall, " + beerCounter + " bottles of beer.");
      System.out.println("Take one down and pass it around, " + (beerCounter-1) + " bottle of beer on the wall.");
      System.out.println();    // empty line after each verse
      beerCounter--;           //decrement
    }
    //at this point beerCounter = 1
    if(beerCounter == 1){    // slight variation in lyrics
      System.out.println(beerCounter + " bottle of beer on the wall, " + beerCounter + " bottle of beer.");
      System.out.println("Take one down and pass it around, no more bottles of beer on the wall.");
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
