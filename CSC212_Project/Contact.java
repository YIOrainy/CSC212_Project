package CSC212_Project; // This specifies the package to which this class belongs.

import java.util.Date;

// The Contact class implements the Comparable interface, meaning it can be compared to other Contacts.
public class Contact implements Comparable<Contact> {

    // These are the private fields that store the properties of a contact.
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private Date birthday;
    private String notes;
    private LinkedListADT<Event> events;

    // Constructor to initialize the contact with an empty state.
    public Contact() {
        this.name = "";
        this.phoneNumber = "";
        this.emailAddress = "";
        this.address = "";
        this.birthday = null;
        this.notes = "";
        events = new LinkedListADT<Event>();
    }

    // Constructor to initialize the contact with the provided values.
    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
            String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = new Date(birthday);
        this.notes = notes;
        events = new LinkedListADT<Event>();
    }

    @Override
    public String toString() {
        return "\nName: " + name +
                "\nPhone Number: " + phoneNumber +
                "\nEmail Address: " + emailAddress +
                "\nAddress: " + address +
                "\nBirthday: " + birthday +
                "\nNotes: " + notes + "\n";
    }

    public boolean addEvent(Event e) {
        if (!events.empty()) {
            events.findFirst();
            for (int i = 0; i < events.size; i++) {
                if ((events.retrieve().date.compareTo(e.date) == 0)
                        && (events.retrieve().time.compareTo(e.time) == 0))
                    return false;
            }
        }
        events.insertSort(e);
        return true;
    }

    public boolean removeEvent(String eTitle) {
        if (events.empty())
            return false;
        Event val = new Event();
        val.title = eTitle;
        if (events.search(val)) {
            events.remove(val);
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Contact o) {
        try {
            return (this.name.compareTo(o.name));
        } catch (Exception e) {
            // To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}
