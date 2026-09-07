// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 4-1 Milestone: Task Service

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.Task;

class TaskTest {

    // Tests a valid constructor
    @Test
    void testValidConstructor() {
        String taskID = "1";
        String name = "Dakota Parker";
        String description = "Valid Description";

        Task testTask = new Task(taskID, name, description);
        
        assertEquals(taskID, testTask.getTaskID());
        assertEquals(name, testTask.getName());
        assertEquals(description, testTask.getDescription());       
    }
    
    // Tests invalid constructor - taskID is too long
    @Test
    void testConstructorLongID() {
    	String taskID = "1234567890123456789";
    	String name = "Dakota Parker";
    	String description = "Valid Description";
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, name, description);
        });
    }
    
    // Test invalid constructor - taskID is null
    @Test
    void testConstructorNullID() {
        String taskID = null;
        String name = "Dakota Parker";
        String description = "Valid Description";
       
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, name, description);
        });       
    }
    
    // Tests invalid constructor - name is too long
    @Test
    void testConstructorLongName() {
    	String taskID = "1";
    	String name = "Invalid name due to length being greater than 20 characters";
    	String description = "Valid Description";
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, name, description);
        });
    }
    
    // Tests invalid constructor - name is null
    @Test
    void testConstructorNullName() {
    	String taskID = "1";
    	String name = null;
    	String description = "Valid Description";
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, name, description);
        });
    }
    
    // Tests invalid constructor - description is too long
    @Test
    void testConstructorLongDescription() {
    	String taskID = "1";
    	String name = "Dakota Parker";
    	String description = "Invalid Description due to length being greater than 50 characters, which is too long";
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, name, description);
        });
    }
    
    // Tests invalid constructor - description is null
    @Test
    void testConstructorNullDescription() {
    	String taskID = "1";
    	String name = "Dakota Parker";
    	String description = null;
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, name, description);
        });
    }
    
    // Tests setName with valid input
    @Test
    public void testValidSetName() {
        String taskID = "1";
        String name = "Dakota Parker";
        String description = "Valid Description";
        
        Task testTask = new Task(taskID, name, description);  
        testTask.setName("Parker Dakota");        
        assertEquals("Parker Dakota", testTask.getName());
    }
    
    // Tests setName with name that is too long
    @Test
    public void testLongSetName() {
        String taskID = "1";
        String name = "Dakota Parker";
        String description = "Valid Description";
        
        Task testTask = new Task(taskID, name, description);         
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask.setName("Invalid name due to length being greater than 20 characters"); 
        }); 
    }
    
    //Tests setName with a null input
    @Test
    public void testNullSetName() {
        String taskID = "1";
        String name = "Dakota Parker";
        String description = "Valid Description";
        
        Task testTask = new Task(taskID, name, description);         
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask.setName(null); 
        }); 
    }
    
    // Tests setDescription with a valid input
    @Test
    public void testValidSetDescription() {
        String taskID = "1";
        String name = "Dakota Parker";
        String description = "Valid Description";
        
        Task testTask = new Task(taskID, name, description);  
        testTask.setDescription("Description Valid");        
        assertEquals("Description Valid", testTask.getDescription());
    }
    
    // Tests setDescription with a description that is too long
    @Test
    public void testLongSetDescription() {
        String taskID = "1";
        String name = "Dakota Parker";
        String description = "Valid Description";
        
        Task testTask = new Task(taskID, name, description);         
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask.setDescription("Invalid Description due to length being greater than 50 characters, which is too long"); 
        }); 
    }
    
    // Tests setDescription with a null input
    @Test
    public void testNullSetDescription() {
        String taskID = "1";
        String name = "Dakota Parker";
        String description = "Valid Description";
        
        Task testTask = new Task(taskID, name, description);         
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask.setDescription(null); 
        }); 
    }
}