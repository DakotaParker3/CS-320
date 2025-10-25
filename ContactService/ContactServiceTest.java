// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 3-2 Milestone: Contact Service

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import main.ContactService;

public class ContactServiceTest {
	
	// Clears contact list after each test
	@AfterEach
    void tearDown() {
        ContactService.contactList.clear();
    }
	
	// Tests that a contact can be added correctly
	@Test
    void testAddContact() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();

        assertTrue(ContactService.contactList.isEmpty());

        test.addContact(firstName, lastName, phone, address);

        assertFalse(ContactService.contactList.isEmpty());
        assertEquals("0", ContactService.contactList.get(0).getContactID());
        assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
        assertEquals(lastName, ContactService.contactList.get(0).getLastName());
        assertEquals(phone, ContactService.contactList.get(0).getPhone());
        assertEquals(address, ContactService.contactList.get(0).getAddress());
    }
	
	// Tests that a contact can be removed by ID
	@Test
    void testRemoveContact() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();

        // Adds three contacts with IDs 0, 1, and 2 respectively
        test.addContact(firstName, lastName, phone, address);
        test.addContact(firstName, lastName, phone, address);
        test.addContact(firstName, lastName, phone, address);

        assertEquals(3, ContactService.contactList.size());

        // Removes contact with ID "1"
        test.removeContact("1");

        // Searches list to confirm no matches for ID "1" using stream()
        assertEquals(2, ContactService.contactList.size());
        assertFalse(ContactService.contactList.stream().anyMatch(contacts -> contacts.getContactID().equals("1")));
    }
	
	// Tests that a contact's first name can be updated by ID
	@Test
    void testUpdateFirstName() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phone, address);

        assertEquals(firstName, ContactService.contactList.get(0).getFirstName());

        test.updateFirstName("0", "Test_First");
        assertEquals("Test_First", ContactService.contactList.get(0).getFirstName());
    }
	
	// Tests that a contact's last name can be updated by ID
	@Test
    void testUpdateLastName() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phone, address);

        assertEquals(lastName, ContactService.contactList.get(0).getLastName());

        test.updateLastName("0", "Test_Last");
        assertEquals("Test_Last", ContactService.contactList.get(0).getLastName());
    }
	
	// Test that a contact's phone can be updated by ID
	@Test
    void testUpdatePhone() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phone, address);

        assertEquals(phone, ContactService.contactList.get(0).getPhone());

        test.updatePhone("0", "1987654321");
        assertEquals("1987654321", ContactService.contactList.get(0).getPhone());
    }
	
	// Tests that a contact's address can be updated by ID
	@Test
    void testUpdateAddress() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phone, address);

        assertEquals(address, ContactService.contactList.get(0).getAddress());

        test.updateAddress("0", "Test_Address");
        assertEquals("Test_Address", ContactService.contactList.get(0).getAddress());
    }

}
