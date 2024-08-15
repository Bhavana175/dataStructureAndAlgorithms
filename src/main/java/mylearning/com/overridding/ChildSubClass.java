package mylearning.com.overridding;

public class ChildSubClass extends ParentSuperClass {

    public static void main(String[] args) {

        ChildSubClass ch = new ChildSubClass();
        ChildSubClass ch1 = new ChildSubClass(5);
        ch1.printNum();
        ch.foo(3);

    }

    private int num = 2;

    ChildSubClass() {
        super();    // to call default parent constructor
        // super("Call Parent");    // to call parameterised constructor.
        System.out.println("Child class default Constructor");

    }

    ChildSubClass(int num) {
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

    //@Override
    public static void foo(int n) {
        System.out.println("child class foo!" + n);
        //Calls foo method of Parent class inside the Overriden foo method of Child class.
    }
}
