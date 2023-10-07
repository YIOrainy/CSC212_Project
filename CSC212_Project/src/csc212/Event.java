package csc212; // This specifies the package to which this class belongs.

import java.util.Objects; // This imports the Objects class which provides utility methods for working with objects, such as null-safe comparisions and hash code calculations.

// The Event class represents an event with attributes like title, date and time, location, and associated contact.
public class Event {

    // These are the private fields that store the properties of an event.
    private String title;
    private String dateAndTime;
    private String location;
    private Contact contact; // This field is a reference to a Contact object associated with the event.

    // This is the constructor that initializes the event properties.
    public Event(String title, String dateAndTime, String location, Contact contact) {
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.location = location;
        this.contact = contact;
    }

    // These are the getter methods that provide access to the event properties.
    public String getTitle() {
        return title;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getLocation() {
        return location;
    }

    // This method returns the Contact object associated with the event.
    public Contact getContact() {
        return contact;
    }

    // This method checks if two events are equal based on their title.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Checks if two objects are the same.
        if (obj == null || getClass() != obj.getClass()) return false; // Checks if obj is an Event.
        Event event = (Event) obj; // Casts obj to an Event.
        return title.equals(event.title); // Compares the titles of the two events.
    }

    // This method returns a hash code for the event based on its title.
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

