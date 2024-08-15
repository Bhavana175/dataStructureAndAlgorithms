package mylearning.com.animals;

public class Dog implements Mammal {

    int limbs;

    Dog(int limbs) {
        this.limbs = limbs;
    }

    public void shout() {
        System.out.println("BHOOOWWWWW");
    }



}
