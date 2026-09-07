// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 4-1 Milestone: Task Service

package main;

public class Task {
    
    private String taskID;
    private String name;
    private String description;

    // Constructor
    public Task(String taskID, String name, String description) {
    	
    	if(taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid Task ID");
		}
    	if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
    	if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
        
        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    // Sets and validates name
    public void setName(String name) {
        if(name == null || name.length() > 20) {
        	throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;
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