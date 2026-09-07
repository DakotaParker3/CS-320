// Dakota Parker
// Southern New Hampshire University
// CS-320 Software Test, Automation QA
// Instructor David Handlos
// Module 4-1 Milestone: Task Service

package main;

import java.util.HashMap;

public class TaskService {

	// ID to be incremented
    private int currentID = 0;
    
    // HashMap to store tasks
    public static HashMap<String, Task> tasks = new HashMap<>();

    // Adds new task and increments ID
    public void addTask(String name, String description) {
        String stringID = Integer.toString(currentID);
        Task task = new Task(stringID, name, description);
        tasks.put(stringID, task);
        currentID++;
    }

    // Removes task by ID
    public void removeTask(String taskID) {
        tasks.remove(taskID);
    }

    // Updates task based on ID
    public void updateTask(String taskID, String newName, String newDescription) {
        if (tasks.containsKey(taskID)) {
            Task taskToUpdate = tasks.get(taskID);
            taskToUpdate.setName(newName);
            taskToUpdate.setDescription(newDescription);
        }
    }
}