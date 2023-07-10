class strTest{
  public static void main(String[] args){
    String s1 = "bla";
    System.out.println("bla" == s1);
    System.out.println(" bla" == s1);
    
    String x = null;
    //System.out.println(x);
    String x2 = x + s1;
    char g = 'g';
    System.out.println(x2);
    System.out.println(x2==s1);
    x += g;
    System.out.println("char erbij: " +x);
    //////////////////////////////////////////////
    System.out.println("------------------------------------");
    //////////////////////////////////////////////
    String go = "go";
    String od = "od";
    String good = "good";
    
    System.out.println(good == (go+od));
    String good2 = go+od;
    System.out.println(good == good2);

    StringBuilder test = new StringBuilder("test");

    System.out.println(test.toString());
    //////////////////////////////////////////////
    System.out.println("------------------------------------");
    //////////////////////////////////////////////
    
    int index = 1;
    String[] strArr = new String[5];
    String myStr = strArr[index];
    System.out.println(myStr);
  }
  

}