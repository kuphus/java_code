/* Write a program that copies a text file.
 * In the process, have it convert all spaces ' ' into hyphens '-'.
 * Use the byte stream file classes. Use the traditional
 * approach to closing a file by explicitly calling close().
 */
 
 
import java.io.*;

class HyphenFile{
  public static void main(String[] args) throws IOException{
    FileInputStream fin = null;
    FileOutputStream fout = null;
    int i;
    
    //First make sure that both files have been specified.
    if(args.length != 2){
      System.out.println("Usage: HyphenFile file1 file2");
      return;
    }
    
    //Hyphen the file
    try{
      //Attempt to open the files.
      fin = new FileInputStream(args[0]);
      fout = new FileOutputStream(args[1]);
      
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
    finally{
      try{
        if(fin != null){
          fin.close();
        }
      }
      catch(IOException exc){
        System.out.println("Error Closing Input File");
      }
      try{
        if(fout != null){
          fout.close();
        }
      }
      catch(IOException exc){
        System.out.println("Error Closing Output File");
      }
    }
  }
}
