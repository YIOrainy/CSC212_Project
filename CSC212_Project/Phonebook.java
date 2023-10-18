/****************************
CLASS: Phonebook.java
CSC212 Data structures - Project phase I
Fall 2023
EDIT DATE:
13-13-2023
TEAM:
Osamah Sarraj
AUTHORS:
Osamah Sarraj
***********************************/

package CSC212_Project; // This specifies the package to which this class belongs.

// Importing Scanner class for reading input data from the user
import java.util.Scanner;

// This class represents a Phonebook application
public class Phonebook {

    // Creating a Scanner object to read input data from the user
    public static Scanner input = new Scanner(System.in);

    // Creating a linked list to store contacts
    public static LinkedList<Contact> contacts = new LinkedList<Contact>();

    // Creating a linked list to store events
    public static LinkedList<Event> events = new LinkedList<Event>();

    // This method displays the main menu and returns user's choice
    public static int menu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        return choice;
    }

    // This method displays the submenu for searching contacts and returns user's
    // choice
    public static int subMenu2() {
        System.out.println("Enter search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email Address");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        return choice;
    }

    // This method displays the submenu for searching events and returns user's
    // choice
    public static int subMenu5() {
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event tittle");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        return choice;
    }

    // 1. Add a contact
    // This method allows the user to add a new Contact to the phonebook
    public static void AddContact() {
        Contact c = new Contact();
        System.out.print("Enter the contact\'s name: ");
        c.name = input.nextLine();

        if (!contacts.empty() && contacts.search(c)) {
            System.out.println("There is a contact has same name you entered!");
            return;
        }
        System.out.print("Enter the contact's phone number: ");
        c.phoneNumber = input.nextLine();

        if (!contacts.empty()) {
            contacts.findFirst();
            for (int i = 0; i < contacts.size; i++) {
                if (contacts.retrieve().phoneNumber.compareTo(c.phoneNumber) == 0) {
            System.out.println("There is a contact has same phone number you entered!");
                    return;
                }
                contacts.findNext();
            }
        }
        System.out.print("Enter the contact's email address: ");
        c.emailAddress = input.nextLine();

        System.out.print("Enter the contact's address: ");
        c.address = input.nextLine();

        System.out.print("Enter the contact's birthday: ");
        c.birthday = input.nextLine();

        System.out.print("Enter any notes for the contact: ");
        c.notes = input.nextLine();

        if (contacts.add(c))
            System.out.println("\nContact added successfully!");

    }

    // 2. Search for a contact
    // This method allows the user to search for a contact based on various criteria
    public static void SearchContact() {
        boolean found = false; // this boolean works like a switch. on(true) --> Contact found/ off(false) -->
                               // Contact not found.
        if (contacts.empty())
            System.out.println("No Contacts have been added yet!");
            
        else {
             int choice = subMenu2();
            contacts.findFirst();
            switch (choice) {
                case 1: {

                    // Search for contact by name
                    System.out.print("Enter the contact\'s name: ");
                    String name = input.nextLine();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().name.compareTo(name) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                            break;
                        }
                        contacts.findNext();
                    }
                    if (!found)
                        System.out.println("Contact Not found!");

                }
                    break;

                case 2: {
                    // Search for contact by phone number
                    System.out.print("Enter the contact's phone number:");
                    String phoneNumber = input.nextLine();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().phoneNumber.compareTo(phoneNumber) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                            break;
                        }
                        contacts.findNext();
                    }
                    if (!found)
                        System.out.println("Contact Not found!");
                }
                    break;

                case 3: {
                    // Search for contact by email address
                    System.out.print("Enter the contact's email address: ");
                    String emailAddress = input.nextLine();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().emailAddress.compareTo(emailAddress) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                        }
                        contacts.findNext();
                    }
                    if (!found)
                        System.out.println("Contact not found!");

                }
                    break;

                case 4: {
                    // Search for contact by address
                    System.out.print("Enter the contact's address: ");
                    String address = input.nextLine();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().address.compareTo(address) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                        }
                        contacts.findNext();
                    }
                    if (!found)
                        System.out.println("Contact not found!");
                }
                    break;

                case 5: {
                    // Search for contact by birthday
                    System.out.print("Enter the contact's Birthday: ");
                    String birthday = input.next();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().birthday.compareTo(birthday) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                        }
                        contacts.findNext();
                    }
                    if (!found)
                        System.out.println("Contact not found!");
                }
            }
        }
    }

    // 3. Delete a contact
    // This method allows the user to delete a contact from the phonebook
    public static void DeleteContact() {
        Contact c = new Contact();
        
        if (contacts.empty())
            System.out.println("No Contacts have been added yet!");
        else {
            System.out.print("Enter the contact\'s name: ");
            c.name = input.nextLine();
            c = contacts.remove(c);
            if (c == null)
                System.out.println("Contact not found!");
            else {
                if (!c.events.empty()) {
                    c.events.findFirst();
                    for (int i = 0; i < c.events.size; i++) {
                        Event e = c.events.retrieve();
                        if (events.search(e)) {
                            Event Update_Event = events.retrieve();
                            // Check if the contact name in the event matches the contact being deleted
                            if (Update_Event.contact_name.equals(c.name)) {
                                events.remove(e);  // Remove the event if the contact associated with it is being deleted
                                System.out.println("Delete event, No cantact particapate");
                            } 
                        }
                        c.events.findNext();
                    }
                }
                System.out.println("Contact Deleted Successfully !");
                System.out.println(c);
            }
        }
    }

    // 4. Schedule an event
    // This method allows the user to schedule an event and associate it with a
    // contact
    public static void ScheduleEvent() {
         if(contacts.empty()){
            System.out.println("No Contacts have been added yet!");
            return;
        }
        
        Contact c = new Contact();
        Event e = new Event();

        System.out.print("Enter event title: ");
        e.title = input.nextLine();

        System.out.print("Enter contact name: ");
        c.name = input.nextLine();

        System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
        e.date = input.next();
        e.time = input.next();
        input.nextLine(); // Consume newline

        System.out.print("Enter event location: ");
        e.location = input.nextLine();

        boolean conflictFound = false;
        if (!events.empty()) {
            events.findFirst();
            for (int i = 0; i < events.size; i++) {
                if ((events.retrieve().date.compareTo(e.date) == 0)
                        && (events.retrieve().time.compareTo(e.time) == 0)) {
                    conflictFound = true;
                    break;
                }
                events.findNext();
            }
        }
    
        if (conflictFound) {
            System.out.println("\nThere's a scheduling conflict. The event could not be added.");
        } else {
            if (contacts.search(c) == true) {
                c = contacts.retrieve();
                c.addEvent(e); // Directly adding the event as we've already checked for conflicts
                contacts.update(c);

                if (!events.empty() && events.search(e)) {
                    Event eventFound = events.retrieve();
                    eventFound.contact_name = c.name;
                    events.update(eventFound);
                } else {
                    e.contact_name = c.name;
                    events.add(e);
                    System.out.println("\nEvent Scheduled Successfully !");
                }
            } else {
                System.out.println("\nContact not found.");
            }
        }
    }

    // 5. Print event details
    // This method allows the user to print event details either by contact name or
    // event title
    public static void PrintEvent() {
        if(contacts.empty()) {
    		System.out.println("No Contacts have been added yet! ");
    		return;
        }
        int choice = subMenu5();
        switch (choice) {
            case 1: {
                // Print event details by contact name
                Contact c = new Contact();
                System.out.print("Enter the contact name :  ");
                c.name = input.nextLine();

                
                    if (contacts.search(c) == true) {
                        System.out.println("Contact found !");
                        c = contacts.retrieve();

                        c.events.findFirst();

                        for (int i = 0; i < c.events.size; i++) {
                            Event e = c.events.retrieve();
                            if (!events.empty() && events.search(e))
                                System.out.println(events.retrieve());
                            c.events.findNext();
                        }
                        if (c.events.empty())
                            System.out.println("No events found for this contact !");
                    } else
                        System.out.println("Contact not found !");
            }
                break;

            case 2: {
                // Print event details by event title
                Event e = new Event();
                System.out.print("Enter the event title:  ");
                e.title = input.nextLine();

                if (!events.empty() && events.search(e)) {
                    System.out.println("Event found!");
                    System.out.println(events.retrieve());
                } else
                    System.out.println("Event not found !");
            }
                break;
        }
    }

    // 6. Print contacts by first name
    // This method allows the user to print contacts that have a specific first name
    public static void PrintContactsFirstName() {
         if (contacts.empty()) {
            System.out.println("No Contacts have been added yet!");
            return;
        }
        
        boolean found = false;
        System.out.print("Enter the first name:");
        String fname = input.nextLine();

        contacts.findFirst();
        for (int i = 0; i < contacts.size; i++) {
            String name = contacts.retrieve().name;
            String[] All = name.split(" ");

            if (All[0].compareToIgnoreCase(fname) == 0) {
                System.out.println(contacts.retrieve() + "\n");
                found = true;
            }
            contacts.findNext();
        }
        if (!found)
            System.out.println("No Contacts found !");
    }

    // 7. Print all events alphabetically // O(n)
    // This method allows the user to print all events in the phonebook in
    // alphabetical order
    public static void PrintAllEvents() {
        if (!events.empty()) {
            events.findFirst();
            for (int i = 0; i < events.size; i++) {
                System.out.println((i + 1) + ". Event : " + events.retrieve().title);
                events.findNext();
            }
        } else
            System.out.println("No events found !");
    }

    // Main method to run the Phonebook application
    public static void main(String[] args) {

        System.out.println("Welcome to the Linked List Phonebook!");
        int choice = -1;
        do {
            try {
                choice = menu();
                switch (choice) {
                    case 1:
                        // Option to add a new contact to the phonebook
                        AddContact();
                        break;

                    case 2:
                        // Option to search for a contact based on various criteria
                        SearchContact();
                        break;

                    case 3:
                        // Option to delete a contact from the phonebook
                        DeleteContact();
                        break;

                    case 4:
                        // Option to schedule an event and associate it with a contact
                        ScheduleEvent();
                        break;

                    case 5:
                        // Option to print event details either by contact name or event title
                        PrintEvent();
                        break;

                    case 6:
                        // Option to print contacts that have a specific first name
                        PrintContactsFirstName();
                        break;

                    case 7:
                        // Option to print all events in the phonebook in alphabetical order
                        PrintAllEvents();
                        break;

                    case 8:
                        // Option to exit the application
                        System.out.println("Goodbye!");
                        break;
                    default:
                        // In case the user enters an invalid choice
                        System.out.println("Bad choice! Try again");
                }
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("Bad choice! Try again");
                input.nextLine(); // Consume newline
            }

        } while (choice != 8); // Exit when user chooses option 8
    }

}
