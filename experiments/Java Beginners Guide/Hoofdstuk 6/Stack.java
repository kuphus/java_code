/* make a stack engine, but safer   (first in last out)
 * with exceptions this time
 */

// Exception for stack-full errors.
class StackFullException extends Exception{
  int size;
  
  StackFullException(int s){
    size = s;
  }
  
  public String toString(){
    return "\nStack is full. Maximum size is " + size;
  }
}

// Exception for stack-empty errors.
class StackEmptyException extends Exception{
  
  public String toString(){
    return "\nStack is empty.";
  }
}

class Stack{
  private char[] q; //array of chars
  private int top;   //top of the stack, also the amount of char's stored

  Stack(int size){      // constructor
    q = new char[size];    //create a new char-array of size size
    top = 0;   //index 0 is still the top of the stack
  }

  //Create a Stack from a Stack
  Stack(Stack ob){
    top = ob.top;
    q = new char[ob.q.length];
    
    //copy elements
    for(int i=0; i<top; i++){
      q[i] = ob.q[i];
    }
  }
  
  //Construct a stack with initial values.
  Stack(char a[]){
    q = new char[a.length];
    
    for(int i=0; i<a.length; i++){
      try{
        push(a[i]);
      }
      catch(StackFullException exc){
        System.out.println(exc);
      }
    }
  }

  //put a character into the stack
  void push(char ch)throws StackFullException{
    if(top==q.length){           // check for stack-full condition, if putloc is one past the last location in the q array
      throw new StackFullException(q.length);
    }
    q[top++] = ch;                 //ch is stored at index top, and top is incremented afterwards. So top is always the value where the next element will be stored
  }

  //get a character from the stack
  char pop() throws StackEmptyException{
    if(top == 0){             //if getloc and putloc both index the same element, the stack is assumed to be empty
      throw new StackEmptyException();
    }
    return q[--top];       //element at index getloc is returned, afterwards getloc is incremented, so putloc also has the value of the next element to be retrieved
  }
}
