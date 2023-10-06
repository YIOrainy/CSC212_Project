package csc212;

import java.util.Objects;

public class Event {
    private String title;
    private String dateAndTime;
    private String location;
    private Contact contact;

    public Event(String title, String dateAndTime, String location, Contact contact) {
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.location = location;
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getLocation() {
        return location;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return title.equals(event.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

