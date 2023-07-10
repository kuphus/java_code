public class Spock{
  public static void main(String[] args){
    int mask = 0;
    int count = 0;
    boolean x = ((5<7) || (++count < 10));
    System.out.println("x is: " + x + " en count is: " + count);
    /*
    if( ((5<7) || (++count < 10)) | mask++ < 10 ) mask = mask + 1;
    if(  (6>8) ^ false)                           mask = mask + 10;
    if( !(mask > 1) && ++count > 1)               mask = mask + 100;
    System.out.println(mask + " " + count);
    */
  }
}