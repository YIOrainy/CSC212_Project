package CSC212_Project; // This specifies the package to which this class belongs.

// This specifies the package to which this class belongs.

public class LinkedListADT<T extends Comparable<T>> {

    // Private fields to store the head, current node, and size of the linked list.
    private Node<T> head;
    private Node<T> current;
    public int size;

    // Constructor to initialize the linked list with an empty state.
    public LinkedListADT() {
        size = 0;
        head = current = null;
    }

    // Method to check if the linked list is empty.
    public boolean empty() {
        return head == null;
    }

    // Method to check if the current node is the last node in the linked list.
    public boolean last() {
        return current.next == null;
    }

    // Method to check if the linked list is full (always returns false in this implementation).
    public boolean full() {
        return false;
    }

    // Method to set the current node to the first node in the linked list.
    public void findFirst() {
        current = head;
    }

    // Method to set the current node to the next node in the linked list.
    public void findNext() {
        current = current.next;
    }

    // Method to retrieve the data stored in the current node.
    public T retrieve() {
        return current.data;
    }

    // Method to update the data stored in the current node.
    public void update(T val) {
        current.data = val;
    }

    // Method to insert a new node with data at the end of the linked list.
    public void insertAtEnd(T val) {
        if (empty()) {
            current = head = new Node(val);
        } else {
            while (current.next != null)
                current = current.next;

            current.next = new Node(val);
            current = current.next;
        }
        size++;
    }

    // Method to insert a new node with data in sorted order in the linked list.
    public boolean insertSort(T val) {

        Node<T> tmp;
        if (empty()) {
            current = head = new Node(val);
        } else {
            if (head.getData().compareTo(val) > 0) {
                tmp = new Node(val);
                tmp.setNext(head);
                head = tmp;
            } else {
                Node<T> prev = null;
                current = head;

                while ((current != null) && (current.getData().compareTo(val) <= 0)) {
                    prev = current;
                    current = current.getNext();
                }
                tmp = new Node(val);
                if (current != null) {
                    tmp.next = current;
                    prev.next = tmp;
                    current = tmp;
                } else
                    current = prev.next = tmp;
            }
        }
        size++;
        return true;
    }

    // Method to search for a node with a specific value in the linked list.
    public boolean search(T val) {
        if (head == null)
            return false;

        Node<T> node = head;
        while ((node != null) && (node.getData().compareTo(val) != 0))
            node = node.getNext();
        if ((node != null) && (node.getData().compareTo(val) == 0)) {
            current = node;
            return true;
        }
        return false;
    }

    // Method to remove a node with a specific value from the linked list.
    public T remove(T val) {

        if (search(val) == false)
            return null;

        T data = current.getData();

        if (current == head) {
            head = head.next;
        } else {
            Node tmp = head;

            while (tmp.next != current)
                tmp = tmp.next;
            tmp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;
        size--;
        return data;
    }

    // Method to print all elements in the linked list.
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + "    ");
            p = p.next;
        }
        System.out.println("");
    }
}
