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

	public List<Event> searchEventsByContactName(String contactName) {
		List<Event> matchingEvents = new ArrayList<>();
		for (Event e : events) {
			if (e.getContact().getName().equals(contactName)) {
				matchingEvents.add(e);
			}
		}
		return matchingEvents;
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

    public Event searchEventByContactName(String contactName){
        for (Event e : events) {
            if (e.getContact().getName().equals(contactName)) {
                return e;
            }
        }
        return null;
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
