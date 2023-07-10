
interface I { }

class A implements I{
    public String toString(){ return "in a"; }
}

class B extends A{
    public String toString(){ return "in b"; }
}


public class refClass {

    public static void main(String[] args) {
        B b = new B();
        A a = b;
        I i = a;
        I i2 = new A();


        System.out.println(i);
        System.out.println((B)a);
        System.out.println(b);
        System.out.println("-------------");
        System.out.println(i2);
    }
}
//What will be printed when the above code is compiled and run?