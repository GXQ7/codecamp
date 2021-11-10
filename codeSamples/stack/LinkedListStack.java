import java.util.LinkedList;

public class LinkedListStack {

    private LinkedList<Integer> stack;

    public LinkedListStack(LinkedList<Integer> emptyStack){

        this.stack = emptyStack;
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public int push(int n) {
        stack.add(n);
        return n;
    }

    public int pop() {
       return (isEmpty())? -1 : stack.removeLast();
    }

    public int peek() {
        Integer lastElement = stack.peekLast();
        return (lastElement == null)? -1 : (int)lastElement;
    }

    
}
