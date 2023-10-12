package csc212; // This specifies the package to which this class belongs.

import java.util.ArrayList; // This imports the interface representing an ordered collection (also known as a sequence).
import java.util.List; // This imports the interface representing an ordered collection (also known as a sequence).

public class Phonebook {
    private LinkedListADT contactsList; // Linked list for storing contacts.
    private List<Event> events; // List for storing events.

    // Constructor initializes the contacts list and events list.
    public Phonebook() {
        this.contactsList = new LinkedListADT();
        this.events = new ArrayList<>();
    }

    // Method to add a contact. It checks if a contact with the same name already exists.
    public void addContact(Contact contact) {
        if (contactsList.searchByName(contact.getName()) == null) {
            contactsList.addContact(contact);
        } else {
            System.out.println("Contact already exists.");
        }
    }

    // These methods search for contacts using various attributes (Name, FirstName, email, address, birthday).
    public Contact searchContactByName(String name) {
        return contactsList.searchByName(name);
    }

    public List<Contact> searchContactsByFirstName(String firstName) {
        return contactsList.searchByFirstName(firstName);
    }

	public Contact searchContactByPhoneNumber(String phoneNumber){
		return contactsList.searchByPhoneNumber(phoneNumber);
	}

	public Contact searchContactByEmail(String email){
		return contactsList.searchByEmail(email);
	}

	public Contact searchContactByAddress(String address){
		return contactsList.searchByAddress(address);
	}

	public Contact searchContactByBirthday(String birthday){
		return contactsList.searchByBirthday(birthday);
	}

    // This method searches for events associated with a given contact name.
	public List<Event> searchEventsByContactName(String contactName) {
		List<Event> matchingEvents = new ArrayList<>();
		for (Event e : events) {
			if (e.getContact().getName().equals(contactName)) {
				matchingEvents.add(e);
			}
		}
		return matchingEvents;
	}
	
    // This method searches for events associated with a given title. It also removes events related to this contact.
    public void deleteContact(String name) {
        Contact contact = contactsList.searchByName(name);
        if (contact != null) {
            contactsList.deleteContact(name);
            events.removeIf(e -> e.getContact().equals(contact));  // Remove events related to this contact
        } else {
            System.out.println("Contact not found.");
        }
    }

    // This method schedule an event. It checks for conflicts and whether the associated contact exists.
	public void scheduleEvent(Event event) {
		if (searchContactByName(event.getContact().getName()) == null) {
			System.out.println("Contact does not exist in the phonebook. Event not scheduled.");
			return;
		}
		for (Event e : events) {
			if (e.getContact().equals(event.getContact()) && e.getDateAndTime().equals(event.getDateAndTime())) {
				System.out.println("Event conflict detected. Event not scheduled.");
				return;
			}
		}
		events.add(event);
	}

    // This method searches for events associated with a given contact name.
    public Event searchEventByContactName(String contactName){
        for (Event e : events) {
            if (e.getContact().getName().equals(contactName)) {
                return e;
            }
        }
        return null;
    }

    // This method searches for an event associated with a given title.
    public Event searchEventByTitle(String title) {
        for (Event e : events) {
            if (e.getTitle().equals(title)) {
                return e;
            }
        }
        return null;
    }

    // This method returns all events
    public List<Event> getAllEvents() {
        return events;
    }
}
