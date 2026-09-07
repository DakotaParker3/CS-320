// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 5-1 Milestone: Appointment Service

package main;

import java.util.Date;

public class Appointment {
	
	private String appointmentID;
    private Date date;
    private String description;

    // Constructor
    public Appointment(String appointmentID, Date date, String description) {
    	
    	if(appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
    	if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
    	if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
        
        this.appointmentID = appointmentID;
        this.date = date;
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getDate() {
        return date;
    }

    // Sets and validates date
    public void setDate(Date date) {
        if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    // Sets and validates description
    public void setDescription(String description) {
        if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
        this.description = description;
    }

}
