package csc212;

public class Node {
	private Contact data;
	private Node next;

	public Node(Contact data) {
		this.data = data;
		next = null;
	}

	public void setData(Contact data) {
		this.data = data;
	}

	public Contact getData() {
		return this.data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return this.next;
	}
}
