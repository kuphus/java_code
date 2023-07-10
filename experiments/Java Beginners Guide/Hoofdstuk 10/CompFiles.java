/* try this 10.1
 * Compare 2 files
 * To use this program, specify 2 names of the files to be compared on the command line.
 * java CompFile FIRST.TXT SECOND.TXT
 */
 
import java.io.*;

class CompFiles{
  public static void main(String[] args){
    int i=0, j=0, index=0;
    
    //first make sure that both files have been specified
    if(args.length != 2){
      System.out.println("Usage: CompFiles file1 file2");
      return;
    }
    
    //Compare the files
    try(FileInputStream f1 = new FileInputStream(args[0]); FileInputStream f2 = new FileInputStream(args[1])){
      //check the contents of each file
      do{
        index++;
        i = f1.read();
        j = f2.read();
        
        /* optie toe voegen om de "case" van characters te negeren 
         * door de te kijken of het verschil tussen de twee tekens 32 (decimaal is)
         * dan kan het verschil worden genegeerd
         */
        if(i != j){
          break;
        }
      }while(i != -1 && j != -1);
      
      if(i != j){
        System.out.println("Files differ at the " + index + " character.");
      }
      else{
        System.out.println("Files are the same.");
      }
    }
    catch(IOException exc){
      System.out.println("I/O Error: " + exc);
    }
  }
}