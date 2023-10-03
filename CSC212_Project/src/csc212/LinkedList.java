package csc212;

public class LinkedList<T extends Comparable<T>> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.getNext();
	}

	public T retrieve() {
		return current.getData();
	}

	public void update(T e) {
		current.setData(e);
	}

	public boolean full() {
		return false;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.getNext() == null;
	}

	public void insert(T val) {
		Node<T> newNode = new Node<T>(val);
		if (empty()) {
			head = current = newNode;
			return;

		}
		if (head.getData().compareTo(val) > 0) {
			newNode.setNext(head);
			head = newNode;
			return;
		} else {
			current = head;
			Node<T> p = null;
			while (current != null && current.getData().compareTo(val) < 0) {
				p = current;
				current = current.getNext();
			}
			p.setNext(newNode);
			newNode.setNext(current);
			current = newNode;
		}
	}

	public void remove() {
		if (current == head) {
			head = head.getNext();
		} else {
			Node<T> tmp = head;

			while (tmp.getNext() != current)
				tmp = tmp.getNext();

			tmp.setNext(current.getNext());
		}

		if (current.getNext() == null)
			current = head;
		else
			current = current.getNext();
	}

	
}
