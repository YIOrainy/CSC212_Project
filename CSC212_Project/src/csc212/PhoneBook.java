package csc212;

import java.util.Scanner;

public class PhoneBook {

	private LinkedList Contacts;

	public PhoneBook(LinkedList c) {
		Contacts = c;
	}

	public void addContact() {
//		Taking the details from user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the contact's name:");
		String name = input.next();
		System.out.println("Enter the contact's phone number:");
		String number = input.next();
		System.out.println("Enter the contact's email address:");
		String email = input.next();
		System.out.println("Enter the contact's address:");
		String address = input.next();
		System.out.println("Enter the contact's birthday:");
		String birthday = input.next();
		System.out.println("Enter any notes for the contact:");
		String notes = input.next();
//		Creating an instance
		Contact c = new Contact(name, number, email, address, birthday, notes);
		Contacts.addContact(c);

	}

	public void searchContact() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter search criteria:");
		System.out.println("1.Name \n 2.Phone Number \n 3.Email Address \n 4.Address \n 5.Birthday");
		int choice = input.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter the contact's name: ");
			Contacts.searchContact(input.next());
			break;
		case 2:
			System.out.println("Enter the contcat's number: ");
			Contacts.searchContact(input.next());
			break;
		case 3:
			System.out.println("Enter the contact's Email : ");
			Contacts.searchContact(input.next());
			break;
		case 4:
			System.out.println("Enter the contact's address: ");
			Contacts.searchContact(input.next());
			break;
		case 5:
			System.out.println("Enter the contact's birthday : ");
			Contacts.searchContact(input.next());
			break;
		default:
			System.out.println("Invalid Choice !");
			break;

		}

	}

	public void removeContact() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter yout search criteria: \n 1.Name \n 2.Phone Number");
		int choice = input.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter the Contact's Name : ");
			Contacts.removeContact(input.next());
			break;
		case 2: 
			System.out.println("Enter the contact's Number: ");
			Contacts.removeContact(input.next());
			break;
		default: 
			System.out.println("Invalid Choice!");
			break;
		}
		
	}
}
