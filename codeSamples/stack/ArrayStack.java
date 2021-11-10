public class ArrayStack {

    private static final int MAX = 100;
    private int top;
    private int[] stack = new int[MAX];

    public ArrayStack() {
        this.top = -1;
    }

    public int push(int n) {
        if (top >= (MAX - 1)) {
            return -1; // stack overflow
        } else {
            stack[++top] = n; // updating top position & pushing onto stack
            return n;
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else return -1; // stack underflow
    }

    public int peek() {
        if (!isEmpty()) 
            return stack[top];
        else return -1; // stack underflow
    }
    
    public boolean isEmpty() {
        return top == -1;
    }

}