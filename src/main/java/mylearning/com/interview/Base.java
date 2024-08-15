package mylearning.com.interview;

public class Base {

}
class Child extends  Base{

}

class BaseService
{
    public void display(Base base)
    {
        System.out.println("in base");
    }
}

class ChildService extends BaseService
{
    public void display(Child child)
    {
        System.out.println("in child");
    }
}
class Main
{

    public static void main(String[] args) {

        Child child = new Child();
        Base base = new Base();
        BaseService baseService= new ChildService();
        baseService.display(child);
        ChildService childService= new ChildService();
        childService.display(base);

    }
}
