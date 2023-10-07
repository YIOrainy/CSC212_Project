package csc212; // This specifies the package to which this class belongs.

import java.util.ArrayList;
import java.util.List;

// This class represents a singly linked list with operations specific to Contact objects.
public class LinkedListADT {
    private Node head; // This represents the first node in the linked list.

    // This class represents a node in the linked list.
    private class Node {
        Contact contact; // The contact data stored in the node.
        Node next; // A reference to the next node in the linked list.

        public Node(Contact contact) {
            this.contact = contact;
        }
    }

    // This method adds a contact to the linked list in a sorted order (by contact name).
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

    // This method searches for a contact by name and returns the contact if found, otherwise returns null.
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

    // This method searches for contacts by first name and returns a list of matching contacts.
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

    // This method searches for a contact by phoneNumber and returns the contact if found, otherwise returns null.
    public Contact searchByPhoneNumber(String phoneNumber) {
        Node current = head;
        while (current != null) {
            if (current.contact.getPhoneNumber().equals(phoneNumber)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    // This method searches for a contact by email and returns the contact if found, otherwise returns null.
    public Contact searchByEmail(String email) {
        Node current = head;
        while (current != null) {
            if (current.contact.getEmailAddress().equals(email)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    // This method searches for a contact by address and returns the contact if found, otherwise returns null.
    public Contact searchByAddress(String address) {
        Node current = head;
        while (current != null) {
            if (current.contact.getAddress().equals(address)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    // This method searches for a contact by birthday and returns the contact if found, otherwise returns null.
    public Contact searchByBirthday(String birthday) {
        Node current = head;
        while (current != null) {
            if (current.contact.getBirthday().equals(birthday)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    // This method deletes a contact by name.
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

    // This method retrieves all contacts from the linked list and returns them as a list.
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
