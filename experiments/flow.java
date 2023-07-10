class flow{
  public static void main(String[] args){
    float f1 = 12.4f;
    short s1 = (short)f1;
    System.out.println(s1);
    
    float f2 = 130.5f;
    short s2 = (short)f2;
    System.out.println(s2);
    
    byte b1 = (byte)f2;
    System.out.println(b1);

    new flow().Print();
  }
  void Print(){
    String s;
    System.out.println("Print methode");
  }

}