// An exception for stack-empty errors.
class StackEmptyException extends Exception{
  
  public String toString(){
    return "\nStack is empty.";
  }
}