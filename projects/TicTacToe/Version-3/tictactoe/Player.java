//package tictactoe;

class Player{
 private int number;
 private String userSymbol;
 
 public Player(String u){
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