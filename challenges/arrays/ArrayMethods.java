import java.util.ArrayList;
import java.util.List;

public class ArrayMethods{
  
  public static int[] convertToArray(int x){
    int[] returnArray = convertToArray(Integer.toString(x));
    return returnArray;
  }
  
  public static int[] convertToArray(long x){
    int[] returnArray = convertToArray(Long.toString(x));
    return returnArray;
  }

  public static int[] convertToArray(String s){
    int[] returnArray = new int[s.length()];
    for (int index = 0; index < s.length(); index++){
      returnArray[index] = s.charAt(index)- '0';
    }
    return returnArray;
  }

  public static int[] sumOfArrays(int[] array1, int[] array2){

    //check if indexes have correct values
    for(int x=0; x<array1.length; x++){
      if(array1[x] > 9 || array1[x] < 0){
        System.out.println("array 1 has a wrong value at index " + x);
        return null;
      }
    }
    for(int x=0; x<array2.length; x++){
      if(array2[x] > 9 || array2[x] < 0){
        System.out.println("array 2 has a wrong value at index " + x);
        return null;
      }
    }

    List<Integer> sumArrayList = new ArrayList<Integer>();
    int[] returnArray;
    Integer sum = 0;
    boolean aboveTen = false;
    int indexA1 = array1.length-1,  indexA2 = array2.length-1;

    //the part where both arrays are equal in length
    for(; indexA1 >= 0 && indexA2 >= 0; indexA1--, indexA2--){
      sum = array1[indexA1] + array2[indexA2];

      if(aboveTen){
        sum++;
        aboveTen = false;
      }
      if(sum >= 10){
        aboveTen = true;
        sum -= 10;
      }
      sumArrayList.add(0, sum);
    }

    // arrays unequal in length

    // array 1 was longer
    if(indexA1 >= 0){
      for(; indexA1 >= 0; indexA1--){
        sum = array1[indexA1];
        if(aboveTen){
          sum++;
          aboveTen = false;
        }
        if(sum >= 10){
          aboveTen = true;
          sum -= 10;
        }
        sumArrayList.add(0, sum);
      }
      if(aboveTen){
        sumArrayList.add(0, 1);
        aboveTen = false;
      }
    }

    // array 2 was longer
    if(indexA2 >= 0){
      for(; indexA2 >= 0; indexA2--){
        sum = array2[indexA2];
        if(aboveTen){
          sum++;
          aboveTen = false;
        }
        if(sum >= 10){
          aboveTen = true;
          sum -= 10;
        }
        sumArrayList.add(0, sum);
      }
      if(aboveTen){
        sumArrayList.add(0, 1);
        aboveTen = false;
      }
    }

    //if arrays were equal in size but aboveTen on the last digits was still true
    if(aboveTen){
      sumArrayList.add(0, 1);
      aboveTen = false;
    }

    //create the final array to return
    returnArray = new int[sumArrayList.size()];
    for(int x = 0; x<returnArray.length; x++){
      returnArray[x] = sumArrayList.get(x);
    }
    
    return returnArray;
  }





  //Print section
  public static void printArray(int[] array){
    for(int x = 0; x < array.length; x++){
      System.out.print(array[x]);
    }
    System.out.print("\n");
  }
  
  public static void printArray(Integer[] array){
    for(int x = 0; x < array.length; x++){
      System.out.print(array[x]);
    }
    System.out.print("\n");
  }

}