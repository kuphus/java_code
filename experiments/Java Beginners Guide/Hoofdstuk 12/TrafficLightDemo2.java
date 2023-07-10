/* Improved version of try this 12-1 from Self-test
 * Simulation of a traffic light that uses an enumeration to describe the light's color
 */

// An enumeration of the colors of a traffic light
enum TrafficLightColor{
  RED(12000), GREEN(10000), YELLOW(2000);
  
  private int delay;
  
  TrafficLightColor(int d){
    delay = d;
  }
  
  int getDelay(){
    return delay;
  }
}

//A computerized traffic light
class TrafficLightSimulator implements Runnable{
  private TrafficLightColor tlc;       //holds the traffic light color
  private boolean stop = false;        //set to true to stop the simulation
  private boolean changed = false;     //true when the light has changed
  
  TrafficLightSimulator(TrafficLightColor init){
    tlc = init;
  }
  
  TrafficLightSimulator(){
    tlc = TrafficLightColor.RED;
  }
  
  //Start up the light
  public void run(){
    while(!stop){
      try{
        /* hier is het simpeler geworden
        switch(tlc){
          case GREEN:
            Thread.sleep(10000);          //green for 10 seconds
            break;
          case YELLOW:
            Thread.sleep(2000);           //yellow for 2 seconds
            break;
          case RED:
            Thread.sleep(12000);          //red for 12 seconds
            break;
        }*/
        Thread.sleep(tlc.getDelay());
      }
      catch(InterruptedException exc){
        System.out.println(exc);
      }
      changeColor();
    }
  }

  //Change color
  synchronized void changeColor(){
    switch(tlc){
      case RED:
        tlc = TrafficLightColor.GREEN;
        break;
      case YELLOW:
        tlc = TrafficLightColor.RED;
        break;
      case GREEN:
        tlc = TrafficLightColor.YELLOW;
    }
    
    changed = true;
    notify(); //signal that the light has changed
  }
  
  //Wait until a light change occurs
  synchronized void waitForChange(){
    try{
      while(!changed){
        wait();       //wait for light to change
      }
      changed = false;
    }
    catch(InterruptedException exc){
      System.out.println(exc);
    }
  }
  
  //Return current color
  synchronized TrafficLightColor getColor(){
    return tlc;
  }
  
  //Stop the traffic light
  synchronized void cancel(){
    stop = true;
  }
}


class TrafficLightDemo2{
  public static void main(String[] args){
    TrafficLightSimulator tl = new TrafficLightSimulator(TrafficLightColor.GREEN);
    Thread thrd = new Thread(tl);
    thrd.start();
    
    for(int i=0; i<9; i++){
      System.out.println(tl.getColor());
      tl.waitForChange();
    }
    
    tl.cancel();
  }
}