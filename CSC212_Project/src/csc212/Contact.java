package csc212;

public class Contact implements Comparable<Contact> {
	
//	Constructor
	public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday, String note) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.birthday = birthday;
		this.note = note;
	}

//	Attributes
	private String name;
	private String phoneNumber;
	private String emailAddress;
	private String address;
	private String birthday;
	private String note;

//	Attributes
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

// == Note : i am not sure if the method print in the wright place or no ==
	public void print() {
		System.out.println("Name: "+getName());
		System.out.println("PhoneNumber: "+getPhoneNumber());
		System.out.println("Email Address: "+getEmailAddress());
		System.out.println("Adderss: "+getAddress());
		System.out.println("Birthday: "+getBirthday());
		System.out.println("Notes: "+getNote());
		System.out.println(" ");


	}

	public int compareTo(Contact name) {
		return this.name.compareTo(name.getName());
	}

	
	
}