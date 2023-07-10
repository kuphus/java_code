/* The ASCII lowercase letters are separated from the uppercase letters by 32.
 * Thus, to convert a lowercase letter to uppercase, subtract 32 from it. Use this
 * information to write a program that reads characters from the keyboard. Have it
 * convert all lowercase letters to uppercase, and all uppercase letters to lowercase,
 * displaying the result. Make no changes to any other character. Have the program
 * stop when the user enters a period. At the end, have the program display the number
 * of changes that have taken place.
 */

class Ascii{
  public static void main(String[] args)
  throws java.io.IOException{

  char ch;
  int verandering = 0;
  
  System.out.println("Geef uw invoer en sluit af met een .");
    do{
      ch = (char) System.in.read();
      if(ch >= 'a' & ch <= 'z'){
        ch -= 32;
        verandering++;
        System.out.print(ch);
      }
      else if(ch >= 'A' & ch <= 'Z'){
        ch += 32;
        verandering++;
        System.out.print(ch);
      }
      else{
        System.out.print(ch);
      }
    }while(ch != '.');

    System.out.println("\nHet aantal veranderingen in uw invoer waren: " + verandering);

    // !!!! Beter dan het antwoord in het boek!!!!

  }
}