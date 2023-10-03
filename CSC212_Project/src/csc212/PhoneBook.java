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
					try {
						searchContact(name).retrieve().print();
						System.out.println("Contact found");
					} catch (NullPointerException e) {
						System.out.println("The name you were searching about not found!");
					}
					break;
				case 2:
					System.out.print("Enter the contact's phone number:");
					String phoneNumber = input.nextLine();
					try {
						searchContact(phoneNumber).retrieve().print();
						System.out.println("Contact found");
					} catch (NullPointerException e) {
						System.out.println("The phone number you were searching about not found!");
					}
					break;
				case 3:
					System.out.print("Enter the contact's email address:");
					String email = input.nextLine();
					LinkedList<Contact> z = new LinkedList<>();
					z = searchContact(email);
					z.findFirst();
					try {
						while (!z.last()) {
							z.retrieve().print();
							z.findNext();
						}
						z.retrieve().print();
					} catch (NullPointerException e) {
						System.out.println("No one in the contacts has the same email address you have enterd");
					}
					break;
				case 4:
					System.out.print("Enter the contact's address address: ");
					String address = input.nextLine();
					z = new LinkedList<>();
					z = searchContact(address);
					z.findFirst();
					try {
						while (!z.last()) {
							z.retrieve().print();
							z.findNext();
						}
						z.retrieve().print();
					} catch (NullPointerException e) {
						System.out.println("No one in the contacts has the same address you have enterd");
					}
					break;
				case 5:
					System.out.print("Enter the contact's birthday address: ");
					String birthday = input.nextLine();
					z = new LinkedList<>();
					z = searchContact(birthday);
					z.findFirst();
					try {
						while (!z.last()) {
							z.retrieve().print();
							z.findNext();
						}
						z.retrieve().print();
					} catch (NullPointerException e) {
						System.out.println("No one in the contacts has the same birthday you have enterd");
					}
					break;
				}
				break;
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
		System.out.println("1.Contact's name:");
		System.out.println("2.Contact's phone number: ");
		System.out.print("Chose: ");
		chose = input.nextInt();
		input.nextLine();
		if (chose == 1)
			System.out.print("Enter the name you want to remove from contacts: ");
		else if (chose == 2)
			System.out.print("Enter the phone number you want to remove from contacts: ");
		else {
			System.out.println("Wrong number !");
			return;
		}
		attribute = input.nextLine();
		c.findFirst();
		try {
			while (!c.last()) {
				if (c.retrieve().getName().equalsIgnoreCase(attribute)
						|| c.retrieve().getPhoneNumber().equalsIgnoreCase(attribute)) {
					c.remove();
					System.out.println("Contact removed!");
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
		}
	}

	public LinkedList<Contact> searchContact(String attribute) {
		LinkedList<Contact> tmp = new LinkedList<>();
		c.findFirst();
		while (!c.last()) {
			if (c.retrieve().getName().equalsIgnoreCase(attribute)
					|| c.retrieve().getPhoneNumber().equalsIgnoreCase(attribute)) {
				tmp.insert(c.retrieve());
				return tmp;
				
			}
			if (c.retrieve().getEmailAddress().equalsIgnoreCase(attribute)
					|| c.retrieve().getBirthday().equalsIgnoreCase(attribute)
					|| c.retrieve().getAddress().equalsIgnoreCase(attribute)) {
				tmp.insert(c.retrieve());
			}
			c.findNext();
		}
		if (c.retrieve().getName().equalsIgnoreCase(attribute)
				|| c.retrieve().getPhoneNumber().equalsIgnoreCase(attribute)) {
			tmp.insert(c.retrieve());
			return tmp;
		}
		if (c.retrieve().getEmailAddress().equalsIgnoreCase(attribute)
				|| c.retrieve().getBirthday().equalsIgnoreCase(attribute)
				|| c.retrieve().getAddress().equalsIgnoreCase(attribute)) {
			tmp.insert(c.retrieve());
		}
		return tmp;
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

}
