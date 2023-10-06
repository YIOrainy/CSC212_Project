package csc212;



import java.util.Scanner;



public class PhoneBook {
	private LinkedList<Contact> c; // c stands for contact.
	Scanner input = new Scanner(System.in);

	public PhoneBook() {
		c = new LinkedList<Contact>();
	}

	// this the interface
	public void interFace() {
		System.out.println("Welcome To The Linked Tree Phonebook!");

		int choice;
		do {
			System.out.println("Please choose an option: ");
			System.out.println("1.Add a contact");
			System.out.println("2.delete a contact");
			System.out.println("3.print info");
			System.out.println("4.Search a contact");
			System.out.println("8.Exit");
			System.out.println(" ");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();
			input.nextLine();
			switch (choice) {

			case 1:
				addContact();
				break;
			case 2:
				deleteContact();
				break;
			case 3:
				printInfo();// for checking it will remove later 
				break;
			case 4:
				System.out.println("Enter search criteria: ");
				System.out.println(" 1. Name\n 2. Phone Number\n 3. Email Address\n 4. Address\n 5. Birthday");
				System.out.print("Enter your choice: ");
				int criteria = input.nextInt();
				input.nextLine();
				switch (criteria) {// we use exception inside the switch because the search method may return null
				case 1:
					System.out.print("Enter the contact's name:");
					String name = input.nextLine();
					System.out.println(" ");
					try {
						if (searchContact(criteria,name).retrieve().getName().equalsIgnoreCase(name)) {
							System.out.println("Contact found");
							searchContact(criteria,name).retrieve().print();
						}
					} catch (NullPointerException e) {
						System.out.println("Contact Not Found");
					}
					break;
				case 2:
					System.out.print("Enter the contact's phone number:");
					String phoneNumber = input.nextLine();
					System.out.println(" ");

					try {
						if (searchContact(criteria,phoneNumber).retrieve().getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
							System.out.println("Contact found");
							searchContact(criteria,phoneNumber).retrieve().print();
						}
					} catch (NullPointerException e) {
						System.out.println("Contact Not Found");
					}
					break;
				case 3:
					System.out.print("Enter the contact's email address:");
					String email = input.nextLine();
					LinkedList<Contact> forSameEmail = new LinkedList<>();
					System.out.println(" ");

					try {
						forSameEmail = searchContact(criteria,email);
						forSameEmail.findFirst();
						if (searchContact(criteria,email).retrieve().getEmailAddress().equalsIgnoreCase(email))
							System.out.println("Contact Found");
						while (!forSameEmail.last()) {
							forSameEmail.retrieve().print();
							forSameEmail.findNext();
						}
						forSameEmail.retrieve().print();
					} catch (NullPointerException e) {
						System.out.println("Contact Not Found");
					}
					break;
					
				case 4:
					System.out.print("Enter the contact's address: ");
					String address = input.nextLine();
					LinkedList<Contact> forSameAddress = new LinkedList<>();

					try {
						forSameAddress = searchContact(criteria,address);
						forSameAddress.findFirst();
						if (searchContact(criteria,address).retrieve().getAddress().equalsIgnoreCase(address))
							System.out.println("Contact Found");
						while (!forSameAddress.last()) {
							if (forSameAddress.retrieve().getAddress().equalsIgnoreCase(address))
								forSameAddress.retrieve().print();
							forSameAddress.findNext();
						}
						if (forSameAddress.retrieve().getAddress().equalsIgnoreCase(address))
							forSameAddress.retrieve().print();
					} catch (NullPointerException e) {
						System.out.println("Contact Not Found");
					}
					break;
				case 5:
					System.out.print("Enter the contact's birthday: ");
					String birthday = input.nextLine();
					LinkedList<Contact> forSameBirthday = new LinkedList<>();

					try {
						forSameBirthday = searchContact(criteria,birthday);
						forSameBirthday.findFirst();
						if (searchContact(criteria,birthday).retrieve().getBirthday().equalsIgnoreCase(birthday))
							System.out.println("Contact Found");
						while (!forSameBirthday.last()) {
							if (forSameBirthday.retrieve().getBirthday().equalsIgnoreCase(birthday))
								forSameBirthday.retrieve().print();
							forSameBirthday.findNext();
						}
						if (forSameBirthday.retrieve().getBirthday().equalsIgnoreCase(birthday))
							forSameBirthday.retrieve().print();

					} catch (NullPointerException e) {
						System.out.println("Contact Not Found");
					}
					break;
				}
				break;
				// 4.Schedule an event
			case 5:
				// 5. Print event details
				break;
			case 6:
				// 6. Print contacts by first name
				break;
			case 7:
				// 7. Print all events alphabetically
				break;
			default:
				if (choice != 8)
					System.out.println("Worng number!");
			}

		} while (choice != 8);
		System.out.println("Good bye");

	}

	public void addContact() {
		Contact contact;
		System.out.print("Enter the contact's name:");
		String name = input.nextLine();

		System.out.print("Enter the contact's phonenumber:");
		String phoneNumber = input.nextLine();

		System.out.print("Enter the contact's email address:");
		String emailAddress = input.nextLine();

		System.out.print("Enter the contact's address:");
		String address = input.nextLine();

		System.out.print("Enter the contact's birthday:");
		String birthday = input.nextLine();

		System.out.print("Enter the contact's notes:");
		String notes = input.nextLine();

		contact = new Contact(name, phoneNumber, emailAddress, address, birthday, notes);
		if (c.empty()) {
			System.out.println("Contact added successfully! ");
			c.insert(contact);
			return;
		}
		c.findFirst();
		while (!c.last()) {
			if (c.retrieve().getName().equalsIgnoreCase(name)
					|| c.retrieve().getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
				System.out.println("This contact's has a name or phone number already in the contacts!");
				return;
			}
			c.findNext();
		}
		if (c.retrieve().getName().equalsIgnoreCase(name)
				|| c.retrieve().getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
			System.out.println("This contact's has a name or phone number already in the contacts!");
			return;
		}
		System.out.println("Contact added successfully! ");
		c.insert(contact);

	}

	public void deleteContact() {
		int chose;
		String attribute;
		System.out.println(" ");
		System.out.println("1.Contact's name:");
		System.out.println("2.Contact's phone number: ");
		System.out.print("Enter your Chose: ");
		chose = input.nextInt();
		System.out.println(" ");
		input.nextLine();
		if (chose == 1) {
			System.out.print("Enter the name you want to remove from contacts: ");
		} else if (chose == 2) {
			System.out.print("Enter the phone number you want to remove from contacts: ");
		} else {
			System.out.println("Wrong number !");
			System.out.println(" ");
			return;
		}
		attribute = input.nextLine();
		System.out.println(" ");
		c.findFirst();
		try {
			while (!c.last()) {
				if (c.retrieve().getName().equalsIgnoreCase(attribute)
						|| c.retrieve().getPhoneNumber().equalsIgnoreCase(attribute)) {
					c.remove();

					System.out.println("Contact removed!");
					System.out.println(" ");
					return;
				}
				c.findNext();
			}
			if (c.retrieve().getName().equalsIgnoreCase(attribute)
					|| c.retrieve().getPhoneNumber().equalsIgnoreCase(attribute)) {
				c.remove();
				System.out.println("Contact removed!");
				return;
			}
			System.out.println("Contact Not Found!");

		} catch (NullPointerException e) {
			System.out.println("Can not remove from an empty contact!");
			System.out.println(" ");
		}
	}

	public void printInfo() { // this method just for checking it will remove later
		if (c.empty()) {
			System.out.println("no conatact has been added yet");
			return;
		}
		c.findFirst();
		while (!c.last()) {
			c.retrieve().print();
			c.findNext();
		}
		c.retrieve().print();

	}

	public LinkedList<Contact> searchContact(int criteria, String attribute) {
		LinkedList<Contact> tmp = new LinkedList<>();
		c.findFirst();
		while (!c.last()) {
			if (criteria == 1)
				if (c.retrieve().getName().equalsIgnoreCase(attribute)) {
					tmp.insert(c.retrieve());
					
				}
			if (criteria == 2)
				if (c.retrieve().getPhoneNumber().equalsIgnoreCase(attribute)) {
					tmp.insert(c.retrieve());
					
				}
			if (criteria == 3)
				if (c.retrieve().getEmailAddress().equalsIgnoreCase(attribute))
					tmp.insert(c.retrieve());
			if (criteria == 4)
				if (c.retrieve().getAddress().equalsIgnoreCase(attribute))
					tmp.insert(c.retrieve());
			if (criteria == 5)
				if (c.retrieve().getBirthday().equalsIgnoreCase(attribute))
					tmp.insert(c.retrieve());
			c.findNext();
		}
		if (criteria == 1)
			if (c.retrieve().getName().equalsIgnoreCase(attribute)) {
				tmp.insert(c.retrieve());
				return tmp;
			}
		if (criteria == 2)
			if (c.retrieve().getPhoneNumber().equalsIgnoreCase(attribute)) {
				tmp.insert(c.retrieve());
				return tmp;
			}
		if (criteria == 3)
			if (c.retrieve().getEmailAddress().equalsIgnoreCase(attribute))
				tmp.insert(c.retrieve());
		if (criteria == 4)
			if (c.retrieve().getAddress().equalsIgnoreCase(attribute))
				tmp.insert(c.retrieve());
		if (criteria == 5)
			if (c.retrieve().getBirthday().equalsIgnoreCase(attribute))
				tmp.insert(c.retrieve());
		return tmp;
	}

}
