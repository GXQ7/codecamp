class DoublyLL {
	Node head;

	static class Node {
		int data;
		Node next;
		Node previous;

		Node(int d) {
			data = d;
			next = null;
			previous = null;
		}
	}

	public static void main(String[] args) {

		DoublyLL llist = new DoublyLL();
		llist.head = new Node(1);
		insertNewNodeAfter(llist.head, new Node(2));
		insertNewNodeAfter(llist.head.next, new Node(3));

		llist.head = insertNodeBeginning(llist.head, new Node(7));
		Node n = new Node(23);
		insertNodeEnd(llist.head, n);
		printList(llist.head);
		System.out.println();
		insertNewNodeBefore(n, new Node(26));
		printList(llist.head);

	}

	private static Node insertNodeBeginning(Node head, Node newNode) {
		newNode.next = head;
		head.previous = newNode;
		head = newNode;
		return head;
	}

	private static Node insertNodeEnd(Node list, Node node) {
		if (list == null)
			return node;

		Node temp = list;
		while (temp.next != null) {
			temp = temp.next;
		}
		// when the next node is null break from loop
		node.previous = temp;
		temp.next = node;
		return list;
	}

	private static void insertNewNodeAfter(Node prevNode, Node newNode) {

		if (prevNode == null)
			return;

		// link with old next node
		newNode.next = prevNode.next;

		if (prevNode.next != null) {
			newNode.next.previous = newNode;
		}
		// link with previous node
		newNode.previous = prevNode;
		prevNode.next = newNode;
	}

	private static void insertNewNodeBefore(Node node, Node newNode){
		if (node == null)
			return;
		//set up new node
		newNode.previous = node.previous;
		newNode.next = node;
		//unlink
		node.previous.next = newNode;
		node.previous = newNode;

	}

	public static void printList(Node head) {
		Node n = head;
		Node last = null;
		while (n != null) {
			System.out.print(n.data + " ");
			last = n;	//setting last reference variable to utilise in traversing backwards
			n = n.next;
		}
		//traverse backwards
		// while (last != null) {
		// 	System.out.print(last.data + " ");
		// 	last = last.previous;
		// }
	}
}
