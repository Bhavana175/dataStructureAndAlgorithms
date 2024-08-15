package mylearning.com.abstractexample;


public class Child extends Parent {

    public static void main(String[] args) {
        System.out.println("H"+"a");
        System.out.println('H'+'a');



        Parent ch = new Child();
        Child ch1 = new Child(5);
        ch1.printNum();
        ch.foo(3);


    }

    private int num = 2;

    Child() {
        super();    // to call default parent constructor
        // super("Call Parent");    // to call parameterised constructor.
        System.out.println("Child class default Constructor");

    }

    Child(int num) {
        //super();    // to call default parent constructor
        super("Call Parent");    // to call parameterised constructor.
        System.out.println("Child class param Constructor" + num);

    }

    void printNum() {
        System.out.println(num);
        System.out.println(super.num); //prints the value of num of parent class
        //super.foo();
    }

    @Override
    public void fooException(int n) {
        System.out.println("Parent class foo!" + n);
    }


    public void fooabstractMethod(int n){} ;

    //@Override
    public static void foo(int n) {
        System.out.println("child class foo!" + n);
        //Calls foo method of Parent class inside the Overriden foo method of Child class.
    }
}
