class testWhile{
  public static void main(String[] args){
  int age = 0;
  outer:
    while(age <= 21){
      if(age == 16){
        System.out.println("Get your driver's license");
        age++;
        continue outer;
      }
      else{
        System.out.println("Another year");
      }
      age++;
    }
  }
}