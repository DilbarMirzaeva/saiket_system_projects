package toDoListApp;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Task> taskList;

    public ToDoList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(String title) {
        taskList.add(new Task(title));
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.get(index).markComplete();
        } else {
            System.out.println("Wrong index! This task doesn't exist..");
        }
    }

    public void displayAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty..");
        } else {
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }

}
