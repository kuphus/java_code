// make a queue engine  , but safer

class Queue{
  private char[] q; //array of chars
  private int putloc, getloc;   //the put and get indices

  Queue(int size){      // constructor
    q = new char[size];    //create a new char-array of size size
    putloc = getloc = 0;   //this shows the array is empty until one value changes
  }
  
  //Construct a Queue from a Queue.
  Queue(Queue ob){
    putloc = ob.putloc;
    getloc = ob.getloc;
    q = new char[ob.q.length];
    
    //copy elements
    for(int i=getloc; i< putloc; i++){
      q[i] = ob.q[i];
    }
  }
  
  //Construct a Queue with initial values.
  Queue(char a[]){
    putloc = 0;
    getloc = 0;
    q = new char[a.length];
    
    for(int i=0; i < a.length ; i++){
      put(a[i]);
    }
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

//Demonstrate the Queue class.
class QDemo2{
  public static void main(String[] args){
    //construct 10-element empty queue
    Queue q1 = new Queue(10);
    
    char name[] = {'T', 'o', 'm'};
    //construct queue from array
    Queue q2 = new Queue(name);
    
    char ch;
    int i;
    
    //put some characters into q1
    for(i=0; i<10; i++){
      q1.put((char) ('A' + i));
    }
    
    //construct queue from another queue
    Queue q3 = new Queue(q1);
    
    //show the queues
    System.out.print("Contents of q1: ");
    for(i=0; i<10; i++){
      ch = q1.get();
      System.out.print(ch);
    }
    
    System.out.println("\n");
    
    System.out.print("Contents of q2: ");
    for(i=0; i<3; i++){
      ch = q2.get();
      System.out.print(ch);
    }
    
    System.out.println("\n");
    
    System.out.print("Contents of q3: ");
    for(i=0; i<10; i++){
      ch = q3.get();
      System.out.print(ch);
    }
  }
}