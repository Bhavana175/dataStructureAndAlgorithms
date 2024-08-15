package mylearning.com.interviewMorganStanley;

import java.util.List;

public final class Test {

    /*
morgan stanley
   immutable
   custom impl --> Test two var --> list Of String , Custom Object Employee emp{name, id}
     */

    final List<String> list ;
   final Employee emp;

    // no setter

    public Test(List<String> list, Employee emp) {
        this.list = list;
        // deep copy
        this.emp = emp;
    }

    public List<String> getList() {
        return list;
    }

    public Employee getEmp() {
        Employee temp = new Employee();

        return emp;
    }
}
