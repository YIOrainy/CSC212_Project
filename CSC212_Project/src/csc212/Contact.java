package csc212; // This specifies the package to which this class belongs.

import java.util.Objects; // This imports the Objects class which provides utility methods for working with objects.

// The Contact class implements the Comparable interface, meaning it can be compared to other Contacts.
public class Contact implements Comparable<Contact> {

    // These are the private fields that store the properties of a contact.
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;

    // This is the constructor for the Contact class.
    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }

    // These are the getter methods that provide access to the contact properties.
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }

    // This method is called when a Contact object is printed.
    // This method is used to compare two contacts based on their names.
    @Override
    public int compareTo(Contact other) {
        return this.name.compareTo(other.name);
    }

    // This method checks if two contacts are equal based on their name or phone number.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return name.equals(contact.name) || phoneNumber.equals(contact.phoneNumber);
    }

    // This method returns a hash code for the contact based on its name and phone number.
    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
