package TaskScheduler;

public class Client {
    public static void main(String args[])
    {
        User user = new User("Karthik");
        Sprint sprint = user.createSprint("May 1");
        Task task1 = user.createTask("RRR enhancement");
        sprint.addTask(task1);

        user.showAllTasks();
    }
}
