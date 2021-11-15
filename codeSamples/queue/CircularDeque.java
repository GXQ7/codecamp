public class CircularDeque {

    int[] queue;
    int size, front, rear, capacity;

    public CircularDeque(int capacity) {
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
        this.queue = new int[capacity];
    }
    public boolean isEmpty() {
        return (front == -1)? true: false;
    }
    public boolean isFull() {
        if(!isEmpty()){
        return (rear + 1) % capacity == front;
        }
        return false;
    }
    public int getFront() {
        if (!isEmpty()) {
            return queue[front];
        }
        return -1;
    }
    public int getRear() {
        if (!isEmpty()) {
            return queue[rear];
        }
        return -1;
    }
    public void insertfront(int key) {
        if (!isFull()) {
            size++;
            if (front == -1) { 
                front = 0;
                rear = 0;
            } else if (front == 0) { 
                front = capacity - 1;
            } else {
                front -= 1;
            }
            queue[front] = key;
        }
    }
    public void insertrear(int key) {
        if (!isFull()) {
            size++;
            if (rear == -1){// no elements in queue
                front = 0;
                rear = 0;
            }
            else if (rear == capacity - 1) { // rear is at capacity, wrap by setting the rear to 0
                rear = 0;
            } 
            else {
                rear += 1;
            }
            queue[rear] = key;
        }
    }
    public void deletefront() {
        if (!isEmpty()) {
            size--;
            if (front == rear) { // only one element in queue
                front = -1;
                rear = -1;
            } else if (front == capacity - 1) // front is at end wrap to beginning
                front = 0;
            else
                front++;
        }
    }
    public void deleterear() {
        if (!isEmpty()) {
            size--;
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (rear == 0)
                rear = capacity - 1;
            else
                rear -= 1;
        }
    }
}
