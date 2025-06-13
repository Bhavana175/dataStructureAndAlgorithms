package lld.hasmap;

public class Main {

    public static void main(String[] args) {
        HashMapLLD<Integer, String> myMap = new HashMapLLD<>();


        myMap.put(1,"abc");
        myMap.put(4,"bhavana");

        System.out.println(myMap);
        System.out.println(myMap.get(2));
        System.out.println(myMap.get(1));
    }
}
