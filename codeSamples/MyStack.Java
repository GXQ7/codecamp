public class MyStack {
	private int[] entry; 
	private int top; 
	private final int maxSize = 100; 
	private final String emptyStackMsg = "Stack is empty";
	private final String fullStackMsg = "Stack is full";

	public MyStack() { 
		entry = new int[maxSize];
		top = -1;
	} 
	

	public boolean isEmpty() {
		return (top == -1)? true: false;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println(emptyStackMsg);
            return -1;
		} else
			return entry[top]; 
	}

	public void pop() {
		if (isEmpty()) { 
			System.out.println(emptyStackMsg);
			System.exit(1);
		} else
			top--;
	}

	public void push(int item) {
		if (top == maxSize - 1) { 
			System.out.println(fullStackMsg); 
			System.exit(1); 
		} else {
			top++;
			entry[top] = item; 
		}
	}

} 
