// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 3-2 Milestone: Contact Service

package main;

import java.util.List;
import java.util.ArrayList;

public class ContactService {
	
	// ID to be incremented
	private int currentID = 0;
	
	// List to store contacts
	public static List<Contact> contactList = new ArrayList<Contact>();
	
	// Adds new contact and increments ID
	public void addContact(String firstName, String lastName, String phone, String address) {
		String stringID = Integer.toString(currentID);
		Contact contact = new Contact(stringID, firstName, lastName, phone, address);
		contactList.add(contact);
		++currentID;
	}
	
	// Removes contact by ID
	public void removeContact(String ID) {
		contactList.removeIf(contact -> contact.getContactID().equals(ID));
	}
	
	// Updates first name by ID using stream()
	public void updateFirstName(String contactID, String firstName) {
		contactList.stream()
			.filter(contact -> contact.getContactID().equals(contactID))
			.findFirst()
			.ifPresent(contact -> contact.setFirstName(firstName));
	}
	
	// Updates last name by ID using stream()
	public void updateLastName(String contactID, String lastName) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setLastName(lastName));
    }
	
	// Updates phone by ID using stream()
	public void updatePhone(String contactID, String phone) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setPhone(phone));
    }
	
	// Updates address by ID using stream()
	public void updateAddress(String contactID, String address) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setAddress(address));
    }

}
