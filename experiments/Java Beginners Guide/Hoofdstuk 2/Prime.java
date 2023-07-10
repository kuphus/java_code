/* Find prime nubers between 2 and 100.
 * Een prime number is groter dan 1 en enkel deelbaar door 1 en door zichzelf.
 */

class Prime{
  public static void main(String args[]){
    int i,x;   // gebruikt om te zoeken naar priemgetallen
    boolean Priem;    // de truc is dat een getal een priemgetal is, tenzij het tegendeel is bewezen (falsificatie).

    //buitenloop loopt door de getallen 2 tm 100
    for(i=2; i <= 100; i++){
      Priem = true;
      /*bepalen of getal i een priemgetal is door de mogelijke getallen waar het door kan delen af te lopen
       * 2 <= 2/2 is niet waar, dus voor i=2 wordt de loop niet doorlopen, en 2 dus niet afgedaan als priemgetal.
       * 2 <= 3/2 dito
       *******************vanaf hier wordt voor alle getallen de loop doorlopen **********************************
       * 2 <= 4/2 , 4%2 is gelijk 0, dus geen priemgetal
       * 2 <= 5/2 , 5%2 is niet gelijk aan 0, 5%3 is niet gelijk aan 0, 5%4 is niet gelijk aan 0, binnenloop wordt afgebroken, niet afgedaan als priemgetal
       */
      for(x=2; x <= i/x ; x++){
        if((i%x)==0){
          Priem = false;
        }
      }
      if(Priem){
        System.out.println(i + " is een priemgetal.\t");
      }
    }
  }
}