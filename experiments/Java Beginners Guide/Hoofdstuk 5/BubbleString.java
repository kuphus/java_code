/* an excersise in sorting arrays, specifically this will be a Bubble sort
 * method (repeated comparison). The number of passes required is equal to
 * one less than the number of elements in the array.
 */

class BubbleString{
   public static void main(String[] args){
     String[] strs = {"hello", "this", "is", "A", "test", "for", "arrays", "of", "strings", "!"};
     int a,b; 
     String t;
     int size = strs.length; //number of elements to sort

     //display array before sorting
     System.out.print("Original array is:");
     for(int i=0; i < size; i++){
       System.out.print(" " + strs[i]);
     }
     System.out.println();

     //This sorts the array with Bubble sort
     System.out.println("Sorting...");
     for(a=1; a<size; a++){        //process repeats until entire array is sorted
       System.out.println("Ronde " + a);
       for(b=size-1; b>=a; b--){   //inner loop checks adjacent elements
         if(strs[b-1].compareTo(strs[b]) > 0 ){  //if out of order
           //exchange elements
           t = strs[b-1];
           strs[b-1] = strs[b];
           strs[b] = t;
         }
       System.out.println("Array:" + strs[0] + ", " + strs[1] + ", " + strs[2] + ", " + strs[3] + ", " + strs[4] + ", " + strs[5] + ", " + strs[6] + ", " + strs[7] + ", " + strs[8] + ", " + strs[9]);
       }

     }
     //lege regel tussen sorteren en uiteindelijk array
     System.out.println();

     //display array after sorting
     System.out.print("Sorted array is:");
     for(int i=0; i < size; i++){
       System.out.print(" " + strs[i]);
     }
     System.out.println();

   }

}