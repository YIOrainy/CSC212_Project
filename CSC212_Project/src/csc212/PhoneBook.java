package csc212;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private LinkedListADT contactsList;
    private List<Event> events;

    public Phonebook() {
        this.contactsList = new LinkedListADT();
        this.events = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (contactsList.searchByName(contact.getName()) == null) {
            contactsList.addContact(contact);
        } else {
            System.out.println("Contact already exists.");
        }
    }

    public Contact searchContactByName(String name) {
        return contactsList.searchByName(name);
    }

    public List<Contact> searchContactsByFirstName(String firstName) {
        return contactsList.searchByFirstName(firstName);
    }

    public void deleteContact(String name) {
        Contact contact = contactsList.searchByName(name);
        if (contact != null) {
            contactsList.deleteContact(name);
            events.removeIf(e -> e.getContact().equals(contact));  // Remove events related to this contact
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void scheduleEvent(Event event) {
        for (Event e : events) {
            if (e.getContact().equals(event.getContact()) && e.getDateAndTime().equals(event.getDateAndTime())) {
                System.out.println("Event conflict detected. Event not scheduled.");
                return;
            }
        }
        events.add(event);
    }

    public Event searchEventByTitle(String title) {
        for (Event e : events) {
            if (e.getTitle().equals(title)) {
                return e;
            }
        }
        return null;
    }

    public List<Event> getAllEvents() {
        return events;
    }
}
