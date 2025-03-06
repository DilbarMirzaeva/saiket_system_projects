package toDoListApp;

import static util.util.getInput;

public class MenuTask {
    ToDoList toDoList = new ToDoList();

    public void planner() {
        System.out.println("\n\t\t\t ==To Do List==");
        while (true) {
            int choose = getInput("""
                    1.Add Tasks
                    2.Complete  the Task
                    3.Show Task
                    4.Exit
                    """, Integer.class);
            while (choose < 1 || choose > 4) {
                choose = getInput("Please try again(1,2,3 or 4)", Integer.class);
            }

            switch (choose) {
                case 1:
                    System.out.println("------------------");
                    String task = getInput("Enter the task: ", String.class);
                    toDoList.addTask(task);
                    System.out.println("------------------");
                    break;
                case 2:
                    toDoList.displayAllTasks();
                    int index = getInput("Please enter the completed task index: ", Integer.class);
                    toDoList.markTaskCompleted(index);
                    System.out.println("------------------");
                    break;
                case 3:
                    toDoList.displayAllTasks();
                    System.out.println("------------------");
                    break;
                case 4:
                    return;
            }
        }

    }
}
