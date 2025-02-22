package toDoListApp;

import static calculator.util.getInput;

public class EntToDoList {
    public void planner() {
        System.out.println("\t\t ==To Do List==");
        int choose = getInput("""
                1.Add Tasks
                2.Complete the Task
                3.Show Task
                4.Exit""", Integer.class);
        while (choose < 1 || choose > 4) {
            choose = getInput("Please try again(1,2,3 or 4)", Integer.class);
        }

        switch (choose) {
            case 1:



        }
    }
}
