/* poolpuzzle 2 ; you may use snippets more than once
 * output:
 * helloooo...
 * helloooo...
 * helloooo...
 * helloooo...
 * 10
 *
 * Bonus: if the last line of output was 24 instead of 10
 * how would you complete the puzzle?
 *
 * Solution for number 10
 * while(x < 4){
 *   e1.hello();
 *   e1.count = e1.count + 1;
 *   if(x == 4){
 *     e2.count = e2.count + 1;
 *   }
 *   if(x < 4){
 *     e2.count = e2.count + e1.count;
 *   }
 *   x = x+1;
 * }
 *
 * Snippets:
 * e1 = e1 + 1;  e1 = count + 1;  e1.count = count + 1;  e1.count = e1.count + 1;
 * x   y   e2   count
 * x < 4   x < 5   x > 0   x > 1
 * Echo   Tester   echo()   count()   hello()
 * e2 = e1;  Echo e2;  Echo e2 = e1;  Echo e2 = new Echo();
 * x == 3    x == 4
 */

class /* */ Echo{
  int /* */ count = 0;
  void /* */ hello() {
    System.out.println("helloooo...");
  }
}

public class EchoTestDrive{
  public static void main(String[] args){
    Echo e1 = new Echo();
    /* voor 24 is dit de belangrijkste stap*/  Echo e2 = e1;
    int x = 0;
    

    while(/* */ x < 4){
      e1.hello();
      /* */   e1.count = e1.count + 1;
      if(/* */ x == 3){
        e2.count = e2.count + 1;
      }
      if(/* */ x > 0){
        e2.count = e2.count + e1.count;
      }
      x = x+1;
    }
    System.out.println(e2.count);
  }
}


