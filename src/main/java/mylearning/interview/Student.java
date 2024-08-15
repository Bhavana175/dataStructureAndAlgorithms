package mylearning.interview;

public final class Student {

    final int id;
    final String name;
   // no setter method

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        //deep copy
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
