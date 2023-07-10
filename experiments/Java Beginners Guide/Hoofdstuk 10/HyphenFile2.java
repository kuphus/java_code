/* Write a program that copies a text file.
 * In the process, have it convert all spaces ' ' into hyphens '-'.
 * Use the byte stream file classes. Use the traditional
 * approach to closing a file by explicitly calling close().
 */
 
 
import java.io.*;

class HyphenFile2{
  public static void main(String[] args) throws IOException{
    int i;

    //First make sure that both files have been specified.
    if(args.length != 2){
      System.out.println("Usage: HyphenFile file1 file2");
      return;
    }

    //Hyphen the file
    try( FileReader fin = new FileReader(args[0]) ;
         FileWriter fout = new FileWriter(args[1])){

      do{
        i = fin.read();
        //Convert ' ' into '-'
        if((char)i == ' '){
          i = '-';
        }
        if(i != -1){
          fout.write(i);
        }
      }while(i != -1);
    }
    catch(IOException exc){
      System.out.println("I/O Error: " + exc);
    }

  }
}
