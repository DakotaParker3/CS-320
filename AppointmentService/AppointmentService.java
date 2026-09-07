// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 5-1 Milestone: Appointment Service

package main;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {

	// ID to be incremented
	private int currentID = 0;
	
	// HashMap to store appointments
    public static HashMap<String, Appointment> appointments = new HashMap<>();

    // Adds new appointment and increments ID
    public void addAppointment(Date date, String description) {
        String stringID = Integer.toString(currentID);
        Appointment newAppointment = new Appointment(stringID, date, description);
        appointments.put(stringID, newAppointment);
        currentID++;
    }

    // Removes appointment by ID
    public void removeAppointment(String appointmentID) {
        appointments.remove(appointmentID);
    }
	
}
