package csc212;

public class LinkedList {

	private Node  head;
	private Node current;

	public LinkedList() {

		head = current = null;
	}
	
//	ADT LinkedList Method

	public boolean full() {
		return false;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.getNext() == null;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.getNext();
	}

	public Contact retrieve() {
		return current.getData();
	}

	public void update(Contact e) {
		current.setData(e);
	}
	
//	==== Our New Methods (add,search,delete) ====

//	[ 1) Add Contact ]
	/*
	 * this method add a contact if the list was empty and if contact you want to
	 * add has a unique number and it's sorted alphabetically also you can't add a
	 * contact if he has the same name of another contact in list
	 */
	
	public void addContact(Contact e) {
		Node newNode = new Node(e);
		// if the list was empty
		if (empty()) {
			head = current = newNode;
			System.out.println("Contact added successfully!");
			return;
		}
		// this loop it's make sure the name or the phone number to be unique in the
		// list
	
		
			if (current.getData().compareTo(e) == 0) {
				System.out.println("Already there is a name like this in the List");
				return;
			}
			if (current.getData().getPhoneNumber().compareTo(e.getPhoneNumber()) == 0) {
				System.out.println("Already there is a phone number like this in the List");
				return;
			}
			
		
		// here it checks if the new contact's name should be in the first list or not
		// according to alphabetically order
		current = head;
		if (head.getData().compareTo(e) > 0) {
			newNode.setNext(head);
			head = newNode;
			System.out.println("Contact added successfully!");
			return;
		}
		// this loop it's make sure the name or the phone number to be unique in the list and then compare the new contact's name with the contact's name in the list according to alphabetically order
		else {
			current = head;
			Node p = null;
			while (current != null && current.getData().compareTo(e) < 0) {
				p = current;
			if (current.getData().compareTo(e) == 0) {
				System.out.println("Already there is a name like this in the List");
				return;
			}
			if (current.getData().getPhoneNumber().compareTo(e.getPhoneNumber()) == 0) {
				System.out.println("Already there is a phone number like this in the List");
				return;
			}
			current = current.getNext();
			}
			p.setNext(newNode);
			newNode.setNext(current);
			current = newNode;
		}
		System.out.println("Contact added successfully!");

	}
	
//	[ 2) Remove Contact ]

	// since the name and the phone number are unique so we will use the parameter
	// as name or a phone number
	// this method remove a contact from the list if and only if the contact in
	// parameter has the same number or name of contact in the list.
	public void removeContact(String name_Number) {
		if (empty()) {
			
			System.out.println("There is no Contacts to delete!");
			return;
		}

		current = head;
		Node p = null;
		while (current.getNext() != null) {
			if (current.getData().getName().equalsIgnoreCase(name_Number)
					|| current.getData().getPhoneNumber().equalsIgnoreCase(name_Number))
				break;
			p = current;
			current = current.getNext();
		}
		if (!current.getData().getPhoneNumber().equals(name_Number)
				&& (!current.getData().getName().equalsIgnoreCase(name_Number)))
			return;
		if (p == null) {
			head = head.getNext();
			current = head;
			System.out.println("Contact remove successfully!");
			return;
		} else {
			p.setNext(current.getNext());
			current = p;
			System.out.println("Contact remove successfully!");
		}
	}
	
	
//	[ 3) Search Contact ]
	
	//this method search about any attribute in the contact
	public LinkedList searchContact(String c) {
		LinkedList tmp = new LinkedList();
		current = head;
		while (current != null) {
			//here will search about name or number because they are unique
			if ((current.getData().getName().equalsIgnoreCase(c) || current.getData().getPhoneNumber().equals(c))) {
				System.out.println("Contact Found!");
				current.getData().print();
				tmp.addContact(current.getData());
				break;
			}
			/*here will search about the rest of attributes in the contact and if it there it will return all the contacts that have the same 
			attribute you were search about	*/
			if (current.getData().getEmailAddress().equalsIgnoreCase(c)
					|| current.getData().getAddress().equalsIgnoreCase(c)
					|| current.getData().getBirthday().equalsIgnoreCase(c)) {
				current.getData().print();
				tmp.addContact(current.getData());
			}
			current = current.getNext();

		}
		return tmp;

	}
	
	public void printAll() {
		if(head == null)
			System.out.println("No Added Contacts yet!");
		Node curr = head;
		while(curr != null) {
			curr.getData().print();
			curr = curr.getNext();
		}
		
	}

}
