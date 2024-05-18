package TaskScheduler;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
   private List<Task> tasks;
   private List<Sprint> createdSprints;

    public User(String name)
    {
        this.name = name;
        tasks = new ArrayList<>();
        createdSprints = new ArrayList<>();
    }

    public Sprint createSprint(String name)
    {
        Sprint sprint = new Sprint(name , this);
        createdSprints.add(sprint);
        return sprint;
    }

    public Task createTask(String name)
    {
        Task task = new Task(name,this,Tasktype.BUG,Taskstatus.YET_TO_PICKUP);
        tasks.add(task);
        return task;
    }

    public void showAllTasks()
    {
        for(Task task : tasks)
        {
            System.out.println("Task name : "+task.getName());
        }
    }
}
