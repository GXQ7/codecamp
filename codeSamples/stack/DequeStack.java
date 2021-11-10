import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStack {
    Deque<Integer> stack = new ArrayDeque<>();

    public boolean isEmpty(){
        return stack.size() == 0;
    }

    public int push(int n) {
         boolean pushed = stack.offerLast(n);
         return (pushed)? n : -1;
    }

    public int peek() {
        Integer top = stack.peek();
        return (top == null) ? -1 : top;
    }

    public int pop(){
        if (!isEmpty()){
            return stack.pop();
        }
        else return -1;
    }
}
    

