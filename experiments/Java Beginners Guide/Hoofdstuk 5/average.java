/* write a program that uses an array to find the average of 10 double values. 
 * Use any 10 values you like.
 */
 
 
class average{
  public static void main(String[] args){
    double[] array = {34, 523, -123, 765, 2.64, - 754.5433, 34.634, 35456.4, 456342.356734, -4754.4534};
    
    double sum = 0;
    
    for(int i=0; i<array.length ; i++){
      sum += array[i];
    }
    System.out.println("The average of these 10 numbers is: " + sum / array.length);
  }
}