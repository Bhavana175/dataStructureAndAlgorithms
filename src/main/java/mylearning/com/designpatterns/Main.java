package mylearning.com.designpatterns;

public class Main {

    public static void main(String[] args) {



        Employee e2 = Employee.builder().id(123).build();
        System.out.println(e2);
        Employee e3 = Employee.builder().id(123).name("abababa").build();
        System.out.println(e3);


        XYZ x2 = XYZ.builder().id(22).build();
        System.out.println(x2);
        XYZ x3 = XYZ.builder().id(21).name("xyz").build();
        System.out.println(x3);
    }

}
