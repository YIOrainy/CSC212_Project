package csc212;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Linked Tree Phonebook! Please choose an option:");
            System.out.println("1. Add a contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Schedule an event");
            System.out.println("5. Print event details");
            System.out.println("6. Print contacts by first name");
            System.out.println("7. Print all events alphabetically");
            System.out.println("8. Exit");
            
            System.out.println("");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline
            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.print("Enter the contact's name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter the contact's phone number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter the contact's email address: ");
                    String email = sc.nextLine();
                    System.out.print("Enter the contact's address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter the contact's birthday (MM/DD/YYYY): ");
                    String birthday = sc.nextLine();
                    System.out.print("Enter any notes for the contact: ");
                    String notes = sc.nextLine();
                    Contact contact = new Contact(name, phoneNumber, email, address, birthday, notes);
                    phonebook.addContact(contact);
                    System.out.println("\nContact added successfully!");
                    break;
                case 2:
                    System.out.print("Enter the contact's name: ");
                    name = sc.nextLine();
                    System.out.println("");

                    Contact foundContact = phonebook.searchContactByName(name);
                    if (foundContact != null) {
                        System.out.println("Name: " + foundContact.getName());
                        System.out.println("Phone Number: " + foundContact.getPhoneNumber());
                        System.out.println("Email Address: " + foundContact.getEmailAddress());
                        System.out.println("Address: " + foundContact.getAddress());
                        System.out.println("Birthday: " + foundContact.getBirthday());
                        System.out.println("Notes: " + foundContact.getNotes());
                    } else {
                        System.out.println("\nContact not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the contact's name: ");
                    name = sc.nextLine();
                    phonebook.deleteContact(name);
                    System.out.println("\nContact deleted successfully!");
                    break;
                case 4:
                    System.out.print("Enter event title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter contact name: ");
                    name = sc.nextLine();
                    System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
                    String dateTime = sc.nextLine();
                    System.out.print("Enter event location: ");
                    String location = sc.nextLine();
                    contact = phonebook.searchContactByName(name);
                    if (contact != null) {
                        Event event = new Event(title, dateTime, location, contact);
                        phonebook.scheduleEvent(event);
                        System.out.println("\nEvent scheduled successfully!");
                    } else {
                        System.out.println("\nContact not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the event title: ");
                    String eventTitle = sc.nextLine();
                    System.out.println("");
                    Event foundEvent = phonebook.searchEventByTitle(eventTitle);
                    if (foundEvent != null) {
                        System.out.println("Event title: " + foundEvent.getTitle());
                        System.out.println("Contact name: " + foundEvent.getContact().getName());
                        System.out.println("Event date and time: " + foundEvent.getDateAndTime());
                        System.out.println("Location: " + foundEvent.getLocation());
                    } else {
                        System.out.println("\nEvent not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter the first name: ");
                    String firstName = sc.nextLine();
                    System.out.println("");
                    List<Contact> contactsByFirstName = phonebook.searchContactsByFirstName(firstName);
                    for (Contact c : contactsByFirstName) {
                        System.out.println("Name: " + c.getName());
                        System.out.println("Phone Number: " + c.getPhoneNumber());
                        System.out.println("Email Address: " + c.getEmailAddress());
                        System.out.println("Address: " + c.getAddress());
                        System.out.println("Birthday: " + c.getBirthday());
                        System.out.println("Notes: " + c.getNotes());
                        System.out.println("");
                    }
                    break;
                case 7:
                    List<Event> allEvents = phonebook.getAllEvents();
                    Collections.sort(allEvents, Comparator.comparing(Event::getTitle));
                    for (Event e : allEvents) {
                        System.out.println("Event title: " + e.getTitle());
                        System.out.println("Contact name: " + e.getContact().getName());
                        System.out.println("Event date and time: " + e.getDateAndTime());
                        System.out.println("Location: " + e.getLocation());
                    }
                    break;
                case 8:
                    System.out.println("Goodbye!\n");
                    sc.close();
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
            System.out.println("\n-----------------------------------------\n");
        }
    }
}
