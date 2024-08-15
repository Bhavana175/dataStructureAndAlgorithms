package mylearning.com.animals;

import com.overridding.ChildSubClass;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAnimal {


    public static void main(String[] args) {

        // Example of Dynamic method dispatch or Runtime Polymorphism
        Mammal m = new Dog(4);
        m.shout();

        m = new Cat(2);
        m.shout();


        int arr[] = {1,2,3,4,5};

        int [] abc =new  int [5];

        try{
            System.out.println("yooo");
        } finally {
            System.out.println("gooo");
        }

        try{
            System.out.println("noooo");
        }finally {
            System.out.println("gooo");
        }

        ArrayList<ChildSubClass> ar = new ArrayList<ChildSubClass>();

        //int newCapacity = oldCapacity + (oldCapacity >> 1);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("SNEH");
        arrayList.add("BHAVANA");
        Object[] objects = arrayList.toArray();

        System.out.println(objects[0] + " = " + objects[1]);
        // 10
        // 10 + 5
        // 15 + 7 = 22

        HashMap<String, String> hm = new HashMap<>();


        Integer i = 1111;
    }
}
