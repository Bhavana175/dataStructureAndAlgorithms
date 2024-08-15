package mylearning.com.serializationde;

import java.io.Serializable;

public class ObjectToByteStream implements Serializable {

    public static void main(String[] args) {
        SuperClass obj = new SubClass();

        obj.m1();
    }

    //ObjectToByteStream p = new ObjectToByteStream();
    //ObjectOutputStream.writeObject(p);

    //ObjectInputStream readObject();

//Serializable is a marker interface it has no data members and methods.
    //it is used to mark a java class so that the object of the java class get certain capabilities

// Cloneable
       // Remote r also marker interface

}
