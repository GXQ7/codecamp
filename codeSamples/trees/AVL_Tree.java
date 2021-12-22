/**
 * An implementation of an AVL tree; a special binary tree which self balances
 * to ensure logarithmic operations
 */

public class AVL_Tree<T extends Comparable<T>> {
    public Node root;
    private int nodeCount;

    public class Node {
        T value;
        Node right, left;
        int balanceFactor;
        int height;
        Node root;

        Node(T value) {
            this.value = value;
            balanceFactor = 0;
        }
    }

    // method to recursively search tree
    private boolean containsRecursive(Node node, T value) {
        // base case - reached bottom & value not found
        if (node.value == null)
            return false;
        // using a comparator for branching
        int cmp = value.compareTo(node.value);
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

    // private method to recursively add value in BT
    private Node addRecursive(Node node, T value) {
        // base case: leaf node - found placement for node creation
        if (node == null)
            return new Node(value);

        int cmp = value.compareTo(node.value);

        // dig into left subtree by calling method with left child as focus node
        if (cmp < 0)
            node.left = addRecursive(node.left, value);

        // dig into right subtree with right child as focus node
        else if (cmp > 0)
            node.right = addRecursive(node.right, value);

        // update height & balance factor
        updateTreeInvariants(node);
        // rebalance tree
        return balance(node);
    }

    // rebalancing a BF of +/- 2
    private Node balance(Node node) {
        // Left heavy subtree.
        if (node.balanceFactor == -2) {

            // Left-Left case.
            if (node.left.balanceFactor <= 0) {
                return leftLeftCase(node);

                // Left-Right case.
            } else {
                return leftRightCase(node);
            }

            // Right heavy subtree needs balancing.
        } else if (node.balanceFactor == +2) {

            // Right-Right case.
            if (node.right.balanceFactor >= 0) {
                return rightRightCase(node);

                // Right-Left case.
            } else {
                return rightLeftCase(node);
            }
        }
        return node;
    }

    private Node rightLeftCase(Node node) {
        return null;
    }

    private Node rightRightCase(Node node) {
        return null;
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node);
        return leftLeftCase(node);
    }

    private Node leftLeftCase(Node node) {
        return rightRotation(node);
    }

    private Node rightRotation(Node node) {
        return null;
    }

    private Node leftRotation(Node node) {
        return null;
    }

    private void updateTreeInvariants(Node node) {
        int rightHeight = (node.left == null) ? -1 : node.left.height;
        int leftHeight = (node.right == null) ? -1 : node.right.height;
        node.height = 1 + Math.max(rightHeight, leftHeight);
        node.balanceFactor = rightHeight - leftHeight;
    }

    public boolean isEmpty() {
        return (nodeCount == 0) ? true : false;
    }

    //TODO: Delete 

    // helper method to get the min value from the right subtree
    private Node getMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // // a method to get the height of the tree
    // public int height() {
    //     if (root == null)
    //         return 0;
    //     // Math only supports log base 10, calculating base 2 indirectly
    //     // int height = (int)(Math.log(nodeCount) / Math.log(2));
    //     return root.height;
    // }

}