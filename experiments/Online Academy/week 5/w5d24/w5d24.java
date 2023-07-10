/* Maak een programma met daarin een array met een aantal artikelen, 
 * bijvoorbeeld een stoel, tafel, bank, kast enzovoort. Zorg dat al 
 * deze artikelen netjes op het scherm worden getoond door middel van 
 * een for-loop.
 */
 
class w5d24{
   public static void main(String[] args){
     String[] obj = {"stoel", "bank", "tafel", "kast", "bed"};
     for(String t : obj){
       System.out.println(t);
     }                               
   }
}