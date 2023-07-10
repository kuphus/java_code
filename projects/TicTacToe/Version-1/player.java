class player{
 private int number;
 private String userSymbol;
 
 public player(String u){
   userSymbol = u;
 }

 public void setNumber(int n){
   number = n;
 }
 public int getNumber(){
   return number;
 }
 public void setUserSymbol(String s){
   userSymbol = s;
 }
 public String getUserSymbol(){
   return userSymbol;
 }
}