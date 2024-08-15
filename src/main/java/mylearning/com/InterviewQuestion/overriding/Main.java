package mylearning.com.InterviewQuestion.overriding;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animalDog= new Dog();
        Dog dog= new Dog();

        System.out.println(animal.number);
        System.out.println(animalDog.number);
        System.out.println(dog.number);

        animal.makeSound();
        animalDog.makeSound();
        dog.makeSound();


    }


}
