package mylearning.com.question;


import java.util.HashMap;
import java.util.Map;

public class MyClass {

    public static void main(String[] args) {

      // input:  5,3,2,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,1,9,1,2,1,12
      // output : 3,2,1,4

        int [] arr = {5,3,2,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,1,9,1,2,1,12};
        MyClass obj = new MyClass();
        obj.getDuplicateItems(arr);
    }
    public void getDuplicateItems(int [] arr){

         HashMap<Integer, Integer> map= new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }

        for (Map.Entry x: map.entrySet()) {
            System.out.println(x.getKey() +"  :"+ x.getValue() );
        }

/*
        Employee
                empId name managerId

                1, aaa, 2
                2, bbb, 3
                3, ccc, 3


       output :
       empId name managerId
        1, aaa, bbb
        2, bbb, ccc
        3, ccc, ccc

    select * from Employee inner join select name from Employee where*/

     //   select * from Employee inner join select name from Employee where */

    }

}
