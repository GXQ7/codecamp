import java.util.Stack;

public class JavaClassStack{

    Stack<Integer> stack = new Stack<Integer>();
    
    public boolean isEmpty(){
        return stack.empty();
    }

    public int push(int n) {
        return stack.push(n);
    }

    public int peek() {
        if (!isEmpty()){
            return stack.peek();
        }
        else return -1;
    }

    public int pop(){
        if (!isEmpty()){
            return stack.pop();
        }
        else return -1;
    }
}