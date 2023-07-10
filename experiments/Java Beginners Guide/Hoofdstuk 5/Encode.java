// use XOR to encode and decode a message

class Encode{
  public static void main(String[] args){
    String msg = "This is a test";
    String encMsg = "";
    String decMsg = "";
    String key = "AbCdEfGh";
    int j;
    
    System.out.print("Original message: ");
    System.out.println(msg);
    
    //encode the message
    j = 0;
    for(int i=0; i < msg.length(); i++){
      encMsg = encMsg + (char) (msg.charAt(i) ^ key.charAt(j));
      j++;
      if(j == 8){
        j = 0;
      }
    }
    
    System.out.print("Encoded message: ");
    System.out.println(encMsg);
    
    //decode the message
    j = 0;
    for(int i=0; i < msg.length(); i++){
      decMsg = decMsg + (char) (encMsg.charAt(i) ^ key.charAt(j));
      j++;
      if(j == 8){
        j = 0;
      }  
    }
    
    System.out.print("Decoded message: ");
    System.out.println(decMsg);
  }
}