package mylearning.com.animals;

public class Cat implements Mammal{

    int limbs;

    Cat(int limbs) {
        this.limbs = limbs;
    }

    public void shout() {
        System.out.println("MEOOOOWWWWW");
    }

}
