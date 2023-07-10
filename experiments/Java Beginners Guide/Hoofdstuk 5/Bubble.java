/* an excersise in sorting arrays, specifically this will be a Bubble sort
 * method (repeated comparison). The number of passes required is equal to
 * one less than the number of elements in the array.
 */

class Bubble{
   public static void main(String[] args){
     int[] nums = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
     int a,b, t;
     int size = 10; //number of elements to sort

     //display array before sorting
     System.out.print("Original array is:");
     for(int i=0; i < size; i++){
       System.out.print(" " + nums[i]);
     }
     System.out.println();

     //This sorts the array with Bubble sort
     System.out.println("Sorting...");
     for(a=1; a<size; a++){        //process repeats until entire array is sorted
       System.out.println("Ronde " + a);
       for(b=size-1; b>=a; b--){   //inner loop checks adjacent elements
         if(nums[b-1] > nums[b]){  //if out of order
           //exchange elements
           t = nums[b-1];
           nums[b-1] = nums[b];
           nums[b] = t;
         }
       System.out.println("Array:" + nums[0] + ", " + nums[1] + ", " + nums[2] + ", " + nums[3] + ", " + nums[4] + ", " + nums[5] + ", " + nums[6] + ", " + nums[7] + ", " + nums[8] + ", " + nums[9]);
       }

     }
     //lege regel tussen sorteren en uiteindelijk array
     System.out.println();

     //display array after sorting
     System.out.print("Sorted array is:");
     for(int i=0; i < size; i++){
       System.out.print(" " + nums[i]);
     }
     System.out.println();

   }

}