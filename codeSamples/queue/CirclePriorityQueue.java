public class CirclePriorityQueue {

    QueueNode[] queue;
    int size, front, rear, capacity;

    public CirclePriorityQueue(int capacity) {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = capacity;
        this.queue = new QueueNode[capacity];
    }

    public class QueueNode {
        String data;
        int priority;

        QueueNode(String data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void insert(String i, int priority) {
        if (isFull()) {
            queue[(rear + 1) % size] = new QueueNode(i, priority);
        } else {
            queue[rear] = new QueueNode(i, priority);
            rear++;
            size++;
        }
    }

    public int getHighestPriority() {
        int max = -1;
        for (int i = 0; i < size; i++) {
            if (queue[i].priority > max)
                max = queue[i].priority;
        }
        return max;
    }

    public void deleteHighestPriority() {
        int max = getHighestPriority();
        for (int i = 0; i < size; i++) {
            if (queue[i].priority == max) {
                queue[i] = (queue[++i] == null)? null : queue[++i]; 
            }
        }
        size--;
    }
}
