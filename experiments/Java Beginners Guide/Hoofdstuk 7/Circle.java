// subclass of TwoDShape for circles.

class Circle extends TwoDShape{
  
  //simple default constructor
  Circle(){
    super();
  }
  
  //constructor 2
  Circle(double x){
    super(x, "circle"); //call superclass constructor
  }
  
  //constructor with object
  Circle(Circle ob){
    super(ob);      // object is passed to superclass TwoDShape constructor
  }
  
  double area(){
    // area for circle is radius x radius x pi
    return (getWidth() /2) * (getWidth() /2) * 3.1416;
  }
}