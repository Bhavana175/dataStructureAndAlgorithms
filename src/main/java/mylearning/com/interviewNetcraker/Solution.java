package mylearning.com.interviewNetcraker;

public class Solution {

    /*

    SELECT name, COUNT(productid) AS q
    FROM stock
    GROUP BY name
    HAVING q < 10 OR q > 50;

    employee list, employee joined after 2015
    employee class , call(), hasEmail(), sendMessage()

     */
    public static void main(String[] args) {

        String s = new String("Ankit");
        s.concat(" abc");
        System.out.println(s);

        String s1 = new String("Ankit");
        String s2 =s1.concat(" abc");
        System.out.println(s2);

        StringBuffer sb = new StringBuffer("Ankit");
        sb.append(" abc");
        System.out.println(sb);

        method(124);
        method(null);

        try{
            System.out.println("try");
          //  System.exit(0);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally block");
        }


        Toy car = new Toy();
        car.play();
        System.gc();
        Toy jeep = new Toy();
        jeep.play();
    }

    public static void method(Object o){
        System.out.println("Object method");
    }

    public static void method(String s){
        System.out.println("String method");
    }

}
class Toy {

    public void play(){
        System.out.println("play ");
    }
    public void finalize(){
        System.out.println("clean ");
    }
}
