// invoer tot . is ingevoerd. Tel het aantal spaties

class Spatie{
  public static void main(String[] args)
  throws java.io.IOException{

    char ch;
    int spatie = 0;
    
    System.out.println("Geef uw invoer en sluit af met een .");
    do{
      ch = (char) System.in.read();
      if(ch == ' '){
        spatie += 1;
      }
    }while(ch != '.');

    System.out.println("Het aantal spaties in uw invoer waren: " + spatie);
  }
}