package TaskScheduler;

import java.util.List;
import java.util.ArrayList;

public class Sprint {
    String name;
    List<Task> tasks;
    User createdUser;


    public Sprint(String name, User createdUser)
    {
        this.name = name;
        this.createdUser = createdUser;
        tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task)
    {
        tasks.add(task);
    }
}
