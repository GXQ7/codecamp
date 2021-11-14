public class LinkedListQueue {
    
    QueueNode front, rear;

    public class QueueNode{
        int data;
        QueueNode next;

        public QueueNode(int key){
            this.data = key;
            next = null;
        }
    }
    public void enqueue(int i) {
        QueueNode newNode = new QueueNode(i);
        if (rear == null){
            // no elements in queue - new node is both front & rear
            front = rear = newNode;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public void dequeue() {
        if (front == null){
            return;
        }
        front = front.next;
        rear = (front == null)? null : rear;
    }
}
