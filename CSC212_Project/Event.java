package CSC212_Project; // This specifies the package to which this class belongs.

// The Event class represents an event with attributes like title, date and time, location, and associated contact.
public class Event implements Comparable<Event> {
    String title;
    String date; // Format: 2023/12/31
    String time;
    String location;
    LinkedListADT <String> contacts_names;

    // Default constructor to initialize the event with empty values.
    public Event() {
        this.title = "";
        this.date = "";
        this.time = "";
        this.location = "";
        this.contacts_names = new LinkedListADT<String> ();
    }

    // Constructor to initialize the event with provided values and an initial contact.
    public Event(String title, String date, String time, String location, String contact) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contacts_names = new LinkedListADT<String> ();
        contacts_names.insertSort(contact);
    }

    // Method to add a contact to the list of contacts associated with this event.
    public boolean addContact (String contact)
    {
        return contacts_names.insertSort(contact);
    }

    // Method to remove a contact from the list of contacts associated with this event.
    public boolean removeContact(String contact)
    {
            String name = contacts_names.remove(contact);
            if ( name != null)
                return true; 
            return false;
    }

    // Override of the toString method to provide a string representation of the Event object.
    @Override
    public String toString() {
        String str = "\nEvent title: " + title +
                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + " " + time +
                   "\nEvent location: " + location + "\n" +
                    "\nContacts names:   " ;
                
        contacts_names.findFirst();
         for ( int i = 0 ; i < contacts_names.size ; i++ )
         {
             str += contacts_names.retrieve() + "\t";
             contacts_names.findNext();
         }
          return str;
    }

    // Implementation of the compareTo method from the Comparable interface to compare events based on their titles.
    @Override
    public int compareTo(Event obj) {
        try {
            return (this.title.compareToIgnoreCase(obj.title));
        }
        catch (Exception e)
        {
             //To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}
