class zeerLong{
  public static void main(String[] args){
    long s = 30l;
    System.out.println(((Object)s).getClass().getName());
    int x = (int) s;
    System.out.println(((Object)x).getClass().getName());
    //float f = 20.2;      // mag niet zonder f
    //System.out.println(((Object)f).getClass().getName());
    int x2 = x * (int)s;
    
    byte b = 5;
    short xxx = 15;
    xxx += b;
    System.out.println(xxx);
  }
}