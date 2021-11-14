public class CircularQueue {

    int[] queue;
    int size, front, rear, capacity;

    public CircularQueue(int capacity) {
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

            rear = (rear + 1) % size;
            queue[rear] = i;
            return i;
        }
        else return -1;
    }

    public int dequeue() {
        if (!isFull()){
        front = (front + 1) % size;
        size--;
        return front;
        }
        else return -1;
    }

}
