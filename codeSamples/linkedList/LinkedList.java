import java.security.NoSuchAlgorithmException;

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
		insertNewNode(second, new Node(40));
		llist.head = insertNodeBeginning(llist.head, new Node(7));
		insertNodeEnd(llist.head, new Node(8));
		System.out.println();
		printNodes(llist.head);

	}

	private static void deleteNodeWithPosition(Node list, int position) {
		//list is empty
		if (list == null)
		return;

		Node prev = list;
		//if the head needs to be removed
		if (position == 0)
		list = prev.next;

		//loop until the node before the node to be deleted 
		for (int j = 0; prev != null && j < position -1; j++) {
			prev = prev.next;
		}

		//position is more than the amount of nodes
		if (prev == null || prev.next == null)
		return;

		//storing pointer to node after the node to be deleted
		Node nextNode = prev.next.next;
		//unlinking node to be deleted
		prev.next = nextNode;
	}


	private static Node insertNodeBeginning(Node head, Node newNode){
		newNode.next = head;
		return newNode;

	}

	private static Node insertNodeEnd(Node list, Node node) {
		if (list == null)
			return node;
		Node temp = list;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
		return list;
	}

	private static void insertNewNode(Node prevNode, Node newNode) {

		if (prevNode == null)
			return;

		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	public static void printNodes(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
}
