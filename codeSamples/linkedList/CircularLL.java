class CircularLL {
    // external pointer to point to the last node of list
    // last .next = head
    // Why last and not head? insertion at beginning & end can be done in O(1)
    public Node last = null;

    public class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void driverMethod() {
        insertNodeEmpty(10);
        insertBeginning(7);
        insertEnd(20);
        insertBetween(7, 9);
        traverse();
    }

    public void insertNodeEmpty(int i) {
        if (last == null) {
            // last is the new node, which points to itself
            Node n = new Node(i);
            last = n;
            last.next = n;
        }
    }

    public void traverse() {
        Node temp = last.next;
        if (last != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != last.next);
        }
    }

    public void insertBeginning(int i) {
        if (last == null)
            insertNodeEmpty(i);

        Node n = new Node(i);
        n.next = last.next;
        last.next = n;
    }

    public void insertEnd(int i) {
        if (last == null)
            insertNodeEmpty(i);

        Node n = new Node(i);
        n.next = last.next;
        last.next = n;
        last = n;

    }

    public void insertBetween(int searchVal, int k) {
        if (last != null) {
            Node temp, searchNode;
            searchNode = last.next;

            do {
                if (searchNode.data == searchVal) {
                    temp = new Node(k);
                    temp.next = searchNode.next;
                    searchNode.next = temp;

                    if (searchNode == last)
                        last = temp;
                }
                searchNode = searchNode.next;
            } while (searchNode != last.next);

        }
    }
}
