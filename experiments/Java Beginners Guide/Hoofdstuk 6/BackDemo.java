//Write a recursive method that displays the contents of a string backwards.

class Backwards{
   String str;

   //constructor
   Backwards(String s){
     str = s;
   }
   
   //recursive method
   void backward(int index){
     //stopconditie is wanneer het laatste character van de string is bereikt, zolang dat niet is bereikt gaan we recursief verder zoeken.
     if(index != str.length()-1 ){
       backward(index+1);
     }
     //hier is het laatste character gevonden en starten we met printen
     System.out.print(str.charAt(index));

   }

}


// demo main class
class BackDemo{
  public static void main(String[] args){
    Backwards s = new Backwards("This is a test");
    
    s.backward(0);

  }
}