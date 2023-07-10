/* make a queue engine  , but safer     (first in first out)
 * putloc staat op 0, daar wordt de eerste 'char' geplaatst waarna putloc op 1 staat, 
 * zodra er een tweede 'char' wordt geplaatst gebeurt dit op index 1 door putloc die op 1 staat, waarna putloc wordt verhoogd naar 2.
 *
 * getloc staat op 0, en loopt zelfstandig de 'char' s af vanaf 0, aangezien dat de first in is/was
 */

class Queue{
  private char[] q; //array of chars
  private int putloc, getloc;   //the put and get indices

  Queue(int size){      // constructor
    q = new char[size];    //create a new char-array of size size
    putloc = getloc = 0;   //this shows the array is empty until one value changes
  }

  //put a character into the queue
  void put(char ch){
    if(putloc==q.length){           // check for queue-full condition, if putloc is one past the last location in the q array
      System.out.println(" - Queue is full.");
      return;
    }
    q[putloc++] = ch;                 //ch is stored at index putloc, and putloc is incremented afterwards. So putloc is always the value where the next element will be stored
  }

  //get a character from the queue
  char get(){
    if(getloc == putloc){             //if getloc and putloc both index the same element, the queue is assumed to be empty
      System.out.println(" -  Queue is empty.");
      return (char) 0;
    }
    return q[getloc++];       //element at index getloc is returned, afterwards getloc is incremented, so putloc also has the value of the next element to be retrieved
  }
}
