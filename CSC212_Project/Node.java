package CSC212_Project;

public class Node<T>{

    public T data; // Data stored in the node.
    public Node<T> next; // Reference to the next node in the linked list.

    // Default constructor: Initializes data and next to null.
    public Node () {
        data = null;
        next = null;
    }

    // Constructor with data parameter: Initializes data with the provided value,
    // and sets next to null (indicating that this node is initially not connected
    // to any other node).
    public Node (T val) {
        data = val;
        next = null;
    }

    // Setters/Getters...

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}