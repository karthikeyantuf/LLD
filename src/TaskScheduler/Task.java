package TaskScheduler;

import java.util.List;

public class Task {
    String name;
    User assignedTo;
    Tasktype type;
    Taskstatus status;
    List<Subtask> subtasks;

    public Task(String name , User assignedTo , Tasktype type , Taskstatus status)
    {
        this.name = name;
        this.assignedTo = assignedTo;
        this.type = type;
        this.status= status;
    }

    public String getName() {
        return name;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void addSubTask(Subtask subtask)
    {
        subtasks.add(subtask);
    }
}
