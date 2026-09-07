// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 4-1 Milestone: Task Service

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import main.TaskService;

class TaskServiceTest {

	// Clears tasks after each test
    @AfterEach
    void tearDown() {
        TaskService.tasks.clear();
    }

    // Tests that a task can be added correctly
    @Test
    void testAddTask() {
    	String taskID = "0";
        String name = "Dakota Parker";
        String description = "Valid Description";
        
        TaskService test = new TaskService();
        
        assertTrue(TaskService.tasks.isEmpty());
        
        test.addTask(name, description);
       
        assertTrue(TaskService.tasks.containsKey(taskID));
        assertEquals(name, TaskService.tasks.get(taskID).getName());
        assertEquals(description, TaskService.tasks.get(taskID).getDescription());              
    }

    // Tests that a task can be removed by ID
    @Test
    void testRemoveTask() {
        String name = "Dakota Parker";
        String description = "Valid Description";
        TaskService test = new TaskService();
        
        assertTrue(TaskService.tasks.isEmpty());

        // Adds three tasks with IDs 0, 1, and 2 respectively
        test.addTask(name, description);
        test.addTask(name, description);
        test.addTask(name, description);
          
        assertEquals(3, TaskService.tasks.size());
          
        // Removes task with ID "1"
        test.removeTask("1");
          
        assertEquals(2, TaskService.tasks.size());
        assertFalse(TaskService.tasks.containsKey("1"));
        
        // Asserts that removing a non existent task should not change the size
        test.removeTask("1");
        assertEquals(2, TaskService.tasks.size());
    }

    // Tests updateTask with valid ID
    @Test
    void testValidUpdateTask() {
    	String taskID = "0";
        String name = "Dakota Parker";
        String description = "Valid Description";
        TaskService test = new TaskService();
        
        test.addTask(name, description);

        test.updateTask("0", "New Name", "New Description");
        assertEquals("New Description", TaskService.tasks.get(taskID).getDescription());
        assertEquals("New Name", TaskService.tasks.get(taskID).getName());
    }

    // Tests updateTask with invalid ID
    @Test
    void testInvalidUpdateTask() {
    	String taskID = "0";
        String name = "Dakota Parker";
        String description = "Valid Description";
        TaskService test = new TaskService();
        
        test.addTask(name, description);

        // Attempts to update non-existent task with ID "1"
        test.updateTask("1", "New Name", "New Description");
        
        // Verifies task with ID "0" remains unchanged
        assertEquals(description, TaskService.tasks.get(taskID).getDescription()); // Description should remain unchanged
        assertEquals(name, TaskService.tasks.get(taskID).getName());
    }
}