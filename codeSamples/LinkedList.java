class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {

		LinkedList llist = new LinkedList();
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		llist.head.next = second;
		second.next = third;
		printNodes(llist.head);
		insertNode(new Node(40));
		insertNode(new Node(60));
		insertNode(new Node(70));
		deleteNodeWithKey(2);
		deleteNodeWithPosition(4);

	}

	private static void deleteNodeWithPosition(int i) {
	}

	private static void deleteNodeWithKey(int i) {
	}

	private static Node insertNodeBeginning(Node head, Node newNode){
		newNode.next = head;
		return newNode;
	}

	private static Node insertNodeEnd(Node head, Node node) {
		if (head == null)
			return node;
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
		return head;
	}

	private static void insertNodeMiddle(Node node) {

	}

	public static void printNodes(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
}
