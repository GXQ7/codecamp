public class BinaryTree {
    Node root, parent;

    public class Node {
        public int data;
        public Node leftChild, rightChild;

        public Node(int key) {
            this.data = key;
        }
    }

    public void add(int value){
        root = addRecursive(root, value);
    }

    public Node addRecursive(Node focus, int value) {
        if (focus == null)
            return new Node(value);
        if (value < focus.data)
            focus.leftChild = addRecursive(focus.leftChild, value);
        else if (value > focus.data)
            focus.rightChild = addRecursive(focus.rightChild, value);
        else
            return focus;
        return focus;
    }

    public boolean findNodeRecursive(Node focus, int value) {
        if (root.data == value)
           return true;
        return (focus.data < value)? findNodeRecursive(focus.leftChild, value) : findNodeRecursive(focus.rightChild, value);
    }

    public boolean delete(Node n) {
        return false;
    }
}
