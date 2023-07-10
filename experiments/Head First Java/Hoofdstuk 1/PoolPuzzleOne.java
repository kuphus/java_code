/* pool puzzle 
 * output:
 * a noise
 * annoys
 * an oyster
 *
 * gedachte gang: a/n en spatie flexibel inzetten , dan "oise", "noys", en " oyster"
 */
 

 /* mogelijkheden, allen eenmaal te gebruiken
  * System.out.print(" ");   System.out.print("a");  System.out.print("n");   System.out.print("an");
  * x > 0    x < 1   x > 1    x > 3     x < 4
  * x = x+1;  x = x+2;  x = x-2;  x = x-1;
  * System.out.print("noys");  System.out.print("oise");  System.out.print(" oyster"); System.out.print("annoys");  System.out.print("noise");
  */

class PoolPuzzleOne{
  public static void main(String[] args){
    int x = 0;

    while( /*bla twee opties: x<1 en x<4*/ x < 4    ){
      /*bla */    System.out.print("a");
      if( x<1){
        /*bla */  System.out.print(" ");
      }

      /*bla */   System.out.print("n");
      
      if( /*bla */ x > 1 ){
        /*bla */    System.out.print(" oyster");
        /*bla */    x = x+2;
      }
      if( x == 1){
        /*bla */ System.out.print("noys");
      }
      if( /*bla */ x < 1 ){
        /*bla */ System.out.print("oise");
      }
      System.out.println("");
      /*bla */   x = x+1;
    }
  }
}