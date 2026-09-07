// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 5-1 Milestone: Appointment Service

package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import main.AppointmentService;

public class AppointmentServiceTest {
	
	// Clears appointments after each test
	@AfterEach
    void tearDown() {
        AppointmentService.appointments.clear();
    }

    // Tests that an appointment can be added correctly
    @Test
    void testAddApointment() {
        String appointmentID = "0";
        String description = "Valid Description";
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 25);
        Date validDate = c.getTime();

        AppointmentService testAppointment = new AppointmentService();

        assertTrue(AppointmentService.appointments.isEmpty());

        testAppointment.addAppointment(validDate, description);

        assertTrue(AppointmentService.appointments.containsKey(appointmentID));
        assertEquals(validDate, AppointmentService.appointments.get(appointmentID).getDate());
        assertEquals(description, AppointmentService.appointments.get(appointmentID).getDescription());
    }

    // Tests addAppointment with a null description
    @Test
    void testAddAppointmentNullDescription() {
        String description = null;
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 25);
        Date validDate = c.getTime();

        AppointmentService testAppointment = new AppointmentService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	testAppointment.addAppointment(validDate, description);
        });

        assertEquals("Invalid Description", exception.getMessage());
    }

    // Tests that an appointment can be removed by ID
    @Test
    void testRemoveAppointment() {
        String description = "This is a good description";
        Calendar c = Calendar.getInstance();
        c.set(2025, Calendar.DECEMBER, 25);
        Date validDate = c.getTime();

        AppointmentService testAppointment = new AppointmentService();

        assertTrue(AppointmentService.appointments.isEmpty());

        // Adds three appointments with IDs 0, 1, and 2 respectively
        testAppointment.addAppointment(validDate, description);
        testAppointment.addAppointment(validDate, description);
        testAppointment.addAppointment(validDate, description);

        assertEquals(3, AppointmentService.appointments.size());

        // Removes appointment with ID "1"
        testAppointment.removeAppointment("1");

        assertEquals(2, AppointmentService.appointments.size());
        assertFalse(AppointmentService.appointments.containsKey("1"));

        // Asserts that removing a non existent task should not change the size
        testAppointment.removeAppointment("1");
        assertEquals(2, AppointmentService.appointments.size());
    }
    
    // Tests removing a non-existant appointment
    @Test
    void testRemoveNonExistentAppointment() {
        AppointmentService service = new AppointmentService();

        service.removeAppointment("9000");
        assertTrue(AppointmentService.appointments.isEmpty());
    }
    
    // Tests adding an appointment with a past date
    @Test
    void testAddAppointmentPastDate() {
        AppointmentService service = new AppointmentService();

        Calendar c = Calendar.getInstance();
        c.set(2000, Calendar.JANUARY, 1);
        Date pastDate = c.getTime();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(pastDate, "Valid Description");
        });

        assertEquals("Invalid Date", exception.getMessage());
    }
    
    

}
