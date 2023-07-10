// An exception for stack-full errors.
class StackFullException extends Exception{
  int size;
  
  StackFullException(int s){
    size = s;
  }
  
  public String toString(){
    return "\nStack is full. Maximum size is " + size;
  }
}