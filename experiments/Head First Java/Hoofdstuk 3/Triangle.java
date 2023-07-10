/* poolpuzzle 3 ; you may use snippets more than once
 * output:
 * triangle 0, area = 4.0
 * triangle 1, area = 10.0
 * triangle 2, area = 18.0
 * triangle 3, area = ____  28.0
 * y = _____________   4, t5 area = 343.0
 *
 * Bonus: use snippets to fill the missing output
 *
 * Snippets:
 * Triangle[] ta = new Triangle(4);        Triangle ta = new[] Triangle[4];     Triangle[] ta = new Triangle[4];
 * x    y
 * area    ta.area    ta.x.area    ta[x].area
 * 4, t5 area = 18.0    4, t5 area = 343.0    27, t5 area = 18.0    27, t5 area = 343.0
 * ta[x] = setArea();    ta.x = setArea();    ta[x].setArea();
 * int x;    int y;    int x = 0;    int x = 1;    int y = x;
 * 28.0    30.0
 * x = x + 1;    x = x + 2;    x = x - 1;
 * ta = new Triangle();    ta[x] = new Triangle();    ta.x = new Triangle();
 * ta.x    ta(x)    ta[x]
 * x < 4    x < 5
 */
 
 
class Triangle{
  double area;
  int height;
  int length;
  public static void main(String[] args){
    /* */   Triangle[] ta = new Triangle[4];
    /* */   int x = 0;
    while( /* */ x < 4 ){
      /* */ ta[x] = new Triangle();
      /* */ ta[x].height = (x + 1) * 2;
      /* */ ta[x].length = x + 4;
      /* */ ta[x].setArea();
      System.out.print("triangle "+x+", area");
      System.out.println(" = " + /* */ ta[x].area);
      /* */ x = x + 1;
    }
    /* */ int y = x;
    x = 27;
    Triangle t5 = ta[2];
    ta[2].area = 343;
    System.out.print("y = " + y);
    System.out.println(", t5 area = "+ t5.area);
  }
  void setArea(){
    /* */area = (height * length) / 2;
  }
}