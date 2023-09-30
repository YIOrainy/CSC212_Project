package csc212;

import java.time.LocalDateTime;

public class Event implements Comparable<Event> {

    private String title;
    private LocalDateTime dateTime;
    private String location;
    private Contact contact;

    public Event(String title, LocalDateTime dateTime, String location, Contact contact) {
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;
        this.contact = contact;
    }

    // Implement compareTo for sorting based on title
    @Override
    public int compareTo(Event other) {
        return this.title.compareTo(other.title);
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Event title: " + title + 
               "\nContact name: " + contact.getName() + 
               "\nEvent date and time: " + dateTime + 
               "\nEvent location: " + location;
    }
}
