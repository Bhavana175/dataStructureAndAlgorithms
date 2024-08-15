package mylearning.com.objectclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        // create object with 4 ways
        //with new keyword
        Test t = new Test();

        //Class.forName(String className) method, new instance

      /*  try {
            Test obj = (Test) Class.forName
            ("com.practice.programs.learning.objectclass.Test").newInstance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

       // CLONE METHOD FROM OBJECT CLASS
        Test t1 = (Test) t.clone();
String filename= "";
       //deserialization technique
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);
        Object obj = in.readObject();
    }

}
