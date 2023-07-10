class Propagate{
  public static void main(String[] args){
    Propagate obj = new Propagate();
    try{
      System.out.println(obj.reverse(args[0]));
    }
    catch(IllegalArgumentException e){
      System.out.println("No blank argument!");
    }
    catch(Exception e){
      System.out.println("Something went wrong!");
      e.printStackTrace();
    }
    finally{
      System.out.println("Main has finished");
    }
  }
  
  public String reverse(String s){
    String reverseString = "";
    if(s.length() == 0){
      throw new IllegalArgumentException();
    }
    for(int l = s.length()-1; l >= 0; l--){
      reverseString += s.charAt(l);
    }
    return reverseString;
  }
}