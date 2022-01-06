import java.util.LinkedList;
import java.util.Queue;

/**
 * A BST implementation, allowing any comaprable data within the tree.
 * Supported operations: Add, Contains, Delete, Height, Traversal's (preorder, inorder, postorder & level order)
 * 
 */

public class BinaryTree<T extends Comparable<T>> {
    // BST is a rooted tree, maintaining the root node
    Node root = null;

    // Keeping track of the number of nodes within the tree
    int nodeCount = 0;
    private class Node {
        T key;
        Node left, right;

        public Node(T key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEmpty() {
        return (nodeCount == 0) ? true : false;
    }

    // Adding elemnt into tree. Returns true if successful
    public boolean add(T element) {
        // not allowing duplicate values
        if (contains(element))
            return false;
        else {
            root = addRecursive(root, element);
            nodeCount++;
            return true;
        }
    }

    // method to recursively search tree
    private boolean containsRecursive(Node node, T value) {
        // base case - reached bottom & value not found
        if (node == null)
            return false;
            
        // using a comparator for branching
        int cmp = value.compareTo(node.key);

        // dig into left subtree
        if (cmp < 0)
            return containsRecursive(node.left, value);
        // dig into right subtree
        else if (cmp > 0)
            return containsRecursive(node.right, value);
        // found value
        else
            return true;
    }

    // searches tree for element, returns true if found
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    // private method to recursively add value in BT
    private Node addRecursive(Node node, T value) {
        // base case: leaf node - found placement for node creation
        if (node == null)
            return new Node(value, null, null);

        int cmp = value.compareTo(node.key);

        // dig into left subtree by calling method with left child as focus node
        if (cmp < 0)
            node.left = addRecursive(node.left, value);

        // dig into right subtree with right child as focus node
        else if (cmp > 0)
            node.right = addRecursive(node.right, value);

        return node;
    }

    // method to remove an element from the tree, returns true if deletion is
    // successful
    public boolean delete(T value) {
        // check if tree contaisn value before deletion
        if (contains(value)) {
            root = deleteRecursive(root, value);
            nodeCount--;
            return true;
        } else
            return false;
    }

    private Node deleteRecursive(Node node, T value) {
        // base case - node is null
        if (node.key == null) return null;
        int cmp = value.compareTo(node.key);

        //find phase
        // dig into left subtree
        if (cmp < 0) {
            node.left = deleteRecursive(node.left, value);
        }
        // dig into right subtree
        else if (cmp > 0)
            node.right = deleteRecursive(node.right, value);

        // found node
        else {
            //removal phase 
            // case 1: only a right subtree | no subtree
            //swap node we wish to remove with right child
            if (node.left == null){
            Node rightChild = node.right;
            //destroy node
            node.key = null;
            node = null;
            // return right child
            return rightChild;
            }
            //case 2: only a left subtree | no subtree
            //swap node we wish to remove with left child
            if (node.right == null){
                Node leftChild = node.left;
                //destroy node
                node.key = null;
                node = null;
                // return right child
                return leftChild;
                }

            //case 3: node to be removed has left & right subtree
            // find successor (either the max of left subtree or min of right subtree) 
            // find the smallest value of the right subtree i.e. the leftmost value
            Node temp = getMin(node.right);

            // copy value to the node to be deleted
            node.key = temp.key;

            //remove original value from right subtree, as this value is now a duplciate
            node.right = deleteRecursive(node.right, node.key);

        }
        return node;
    }

    //helper method to get the min value from the right subtree
    private Node getMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }
    //a method to get the height of the tree
    public int getHeight(){
    // Math only supports log base 10, calculating base 2 indirectly
    int height = (int)(Math.log(nodeCount) / Math.log(2));
    return height;
    }

    //Recursive Traversals - these can also be done iteratively

    //prints before recursive calls
    public void preOrder(Node n) {
        if (n == null) return;
        System.out.print(n.key + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    //printing between recursive calls
    public void inOrder(Node n) {
        if (n == null) return;
        inOrder(n.left);
        System.out.print(n.key + " ");
        inOrder(n.right);
    }

    //print after recursive calls
    public void postOrder(Node n) {
        if (n == null) return;
        preOrder(n.left);
        preOrder(n.right);
        System.out.print(n.key + " ");
    }

    //BFS - done iteratively with a queue of nodes left to explore
    public void levelOrder(Node n) {
        Queue<Node> nodesLeftToExplore = new LinkedList<Node>();
        nodesLeftToExplore.add(n);

        while (!nodesLeftToExplore.isEmpty()){
            Node temp = nodesLeftToExplore.element();
            System.out.print(temp.key + " ");
            if (temp.left != null) nodesLeftToExplore.add(temp.left);
            if (temp.right != null) nodesLeftToExplore.add(temp.right);
            nodesLeftToExplore.remove();
        }
    }
}
