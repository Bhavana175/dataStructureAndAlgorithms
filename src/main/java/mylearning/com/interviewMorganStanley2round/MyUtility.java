package mylearning.com.interviewMorganStanley2round;

public class MyUtility {


  //  private MyUtility(){}
    public static void  myMethod(){
        System.out.println("MyUtility ");
    }


}
class Test extends MyUtility{


}

class Main{

    public static void main(String[] args) {

        Test.myMethod();

      //  MyUtility.myMethod();
    // 25
        /*
        5 --> 5 race (25 H)--> top 3 from each -->  15 H (3 race)--> 9 H-> 2 race --> 1  (11 race total)


         */
    }
}
