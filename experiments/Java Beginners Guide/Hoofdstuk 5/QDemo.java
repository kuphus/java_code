// make a queue engine

class Queue{
  char[] q; //array of chars
  int putloc, getloc;   //the put and get indices

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

// demonstrate the Queue class
class QDemo{
  public static void main(String[] args){
    Queue bigQ = new Queue(100);
    Queue smallQ = new Queue(4);
    char ch;
    int i;
    
    System.out.println("Using bigQ to store the alphabet.");
    //put some numbers into bigQ
    for(i=0; i<26 ; i++){
      bigQ.put((char) ('A' + i));
    }
    
    //retrieve and display elements from BigQ
    System.out.println("Contents of BigQ: ");
    for(i=0; i<26; i++){
      ch = bigQ.get();
      if(ch != (char) 0){
        System.out.print(ch);
      }
    }
    
    System.out.println("\n");
    
    System.out.println("Using smallQ to generate errors.");
    //Now, use smallQ to generate some errors
    for(i=0; i<5; i++){
      System.out.print("Attempting to store " + (char) ('Z' - i));
      smallQ.put((char) ('Z' -i));
      System.out.println();
    }
    System.out.println();
    
    //more errors on smallQ
    System.out.print("Contents of smallQ: ");
    for(i=0; i<5; i++){
      ch = smallQ.get();
      if(ch != (char) 0){
        System.out.print(ch);
      }
    }

  }
}