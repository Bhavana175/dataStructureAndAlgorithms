package mylearning.com.interfaces;

import ch.qos.logback.core.net.SyslogOutputStream;

public interface ParentInterface {

    //already
    public static final  int num = 10;

    //can not create object of interface
 /*   ParentInterface(){
        System.out.println("Parent class default constructor.");
    }*/

    private void m1(){

        System.out.println("parent private method ");


    }

    public static void fooException(int n) throws IndexOutOfBoundsException{
        System.out.println("Parent class foo!"+n);
    }

      static void foo(int n){
        System.out.println("Parent class foo!"+n);
    }
     default void fooException2(int n) throws IndexOutOfBoundsException{
        System.out.println("Parent class foo!"+n);
    }
      default void foo2(int n){
        System.out.println("Parent class foo!"+n);
    }

     void abstractMethod(int n);

}
