package mylearning.interview;

public class Solution {
    /*
    create Singleton class
     */

    static Solution solution;

    private Solution(){}

    public synchronized static Solution getInstance(){

        if(Solution.solution ==null){
            return new Solution();
        }
       return solution;
    }

    public Solution getSolution() {
        return solution;
    }

    /*

    two class
    A {get();}
    B {get();}
    C implements A,B

    get(){


    }

    A obj = new C();
    B obj = new C();

     */

}
