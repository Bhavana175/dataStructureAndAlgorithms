package mylearning.com.interfaces;
//this is correct  test extends c implements A, B
public class Test extends C implements A,B {

    public static void main(String[] args) {

    }

}

 class Test2  implements A,B {

    public static void main(String[] args) {

        // can not assign value as value is already final
        //public static final value
       //    A.value= 20;  : wrong

        System.out.println(A.value);
    }

}

interface A{
int value =10;
}

interface B{

}
class C{


}
