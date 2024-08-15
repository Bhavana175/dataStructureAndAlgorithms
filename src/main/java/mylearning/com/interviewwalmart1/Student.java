package mylearning.com.interviewwalmart1;

import java.util.Objects;

public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}







/*

class Bird {

  // ...

  double getSpeed() {

    switch (type) {

      case EUROPEAN:

        return getBaseSpeed();

      case AFRICAN:

        return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;

      case NORWEGIAN_BLUE:

        return (isNailed) ? 0 : getBaseSpeed(voltage);

    }

    throw new RuntimeException("Should be unreachable");

  }

}



 */


interface Bird {

    double getSpeed();

}

class  European implements Bird{

    @Override
    public double getSpeed() {
        return 0;
    }
}
