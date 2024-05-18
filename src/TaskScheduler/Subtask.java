package TaskScheduler;

public class Subtask {
    String name;
    User assignedTo;
    Tasktype type;
    Taskstatus status;


    public Subtask(String name , User assignedTo , Tasktype type , Taskstatus status)
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

}
