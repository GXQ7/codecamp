public class LinkedListDequeue {

    QueueNode front, rear;

    public class QueueNode {
        int data;
        QueueNode next, previous;

        public QueueNode(int key) {
            this.data = key;
            next = null;
            previous = null;
        }
    }

    public void enqueue(int i) {
        QueueNode newNode = new QueueNode(i);
        if (front == null) {
            front = rear = newNode;
            newNode.previous = front;
            
        } else {
            rear.next = newNode;
            rear = newNode;
            newNode.previous = rear.previous;
        }
    }

    public void dequeue() {
        if (front == null) {
            return;
        }
        front = front.next;
        rear = (front == null) ? null : rear;
    }
}
