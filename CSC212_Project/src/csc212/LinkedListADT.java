package csc212;

import java.util.ArrayList;
import java.util.List;

public class LinkedListADT {
    private Node head;

    private class Node {
        Contact contact;
        Node next;

        public Node(Contact contact) {
            this.contact = contact;
        }
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node current = head;
        Node prev = null;

        while (current != null && current.contact.compareTo(contact) < 0) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            newNode.next = head;
            head = newNode;
        } else {
            prev.next = newNode;
            newNode.next = current;
        }
    }

    public Contact searchByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equals(name)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    public List<Contact> searchByFirstName(String firstName) {
        List<Contact> contacts = new ArrayList<>();
        Node current = head;
        while (current != null) {
            String[] names = current.contact.getName().split(" ");
            if (names.length > 0 && names[0].equalsIgnoreCase(firstName)) {
                contacts.add(current.contact);
            }
            current = current.next;
        }
        return contacts;
    }

    public void deleteContact(String name) {
        if (head == null) return;

        if (head.contact.getName().equals(name)) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null && !current.contact.getName().equals(name)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        }
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        Node current = head;
        while (current != null) {
            contacts.add(current.contact);
            current = current.next;
        }
        return contacts;
    }
}
