package lld.stack;

public class Main {
    public static void main(String[] args) {
        try {
            StackImpl<Integer> stack = new StackImpl<>();
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.display();
            stack.pop();
            stack.display();
            stack.pop();
            stack.display();
            stack.pop();
            stack.display();
            stack.pop();
            stack.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
