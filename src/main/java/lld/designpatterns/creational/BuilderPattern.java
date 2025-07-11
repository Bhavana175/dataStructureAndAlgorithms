package lld.designpatterns.creational;

public class BuilderPattern {

    /*
    Method Chaining is used to invoke multiple methods
    on the same object which occurs as a single statement
     */
}

class Student {

    private int id;

    private String name;

    public Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;

    }

    public static class Builder {

        private int id;

        private String name;

        private Builder() {
        }

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

class MainClient{

    public static void main(String[] args) {

    Student s= Student.Builder.getInstance().setId(1223).setName("abc").build();

    Student s1 = Student.Builder.getInstance().setId(111).build();

        System.out.println(s);
        System.out.println(s1);


    }
}
