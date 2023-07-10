public class test{
  public static void main(String[] args){
    parameter x = new parameter();
    int[] intArray = {2,5,9};
    x.myMethod(intArray, 3, 8);
  }
}


class parameter{
  public void myMethod(int[] number, int... moreNumbers){
    for(int num: number){
      System.out.println(num);
    }
    if(moreNumbers.length > 0){
      for(int numVar: moreNumbers){
        System.out.println(numVar);
      }
    }
  }
}