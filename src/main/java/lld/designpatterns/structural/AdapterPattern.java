package lld.designpatterns.structural;

public class AdapterPattern {


    /*
    This pattern involves a single class, known as the adapter, which is responsible for
     joining functionalities of independent or incompatible interfaces.



     Components of Adapter Design Pattern
     1.Target interface
     2. Adaptee : the client code cannot directly use due to interface mismatches.
     3. Adapter : bridge
     4. Client


    Let’s consider a scenario where we have an existing system that uses
    a LegacyPrinter class with a method named printDocument()
    which we want to adapt into a new system that expects
    a Printer interface with a method named print().
    We’ll use the Adapter design pattern to make these two interfaces compatible.

     */
}


class Client{

    public static void main(String[] args) {

        Target t = new Adapter();
        t.print();

    }

}

interface Target{

    void print();

}

class Adapter implements Target{

    private Printer printer;

    @Override
    public void print() {
        printer.legacyPrinter();
    }
}

class Printer{

    void legacyPrinter(){
        System.out.println("Print");

    }

}
