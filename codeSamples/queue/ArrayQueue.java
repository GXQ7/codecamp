public class ArrayQueue {

    int[] queue;
    int size, front, rear, capacity;

    public ArrayQueue(int capacity) {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int front() {
        if (!isEmpty())
            return queue[front];
        else
            return -1;
    }

    public int rear() {
        if (isEmpty())
            return queue[rear];
        else
            return -1;
    }

    public int enqueue(int i) {
        size++;
        if (!isFull()) {
            queue[rear] = i;
            rear++;
            return i;
        }
        else return -1;
    }

    public int dequeue() {
        if (!isFull()){
        int tempFront = queue[front];
        front++;
        size--;
        return tempFront;
        }
        else return -1;
    }

}
