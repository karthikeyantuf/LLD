package NotificationSystem;

public class Client {
    public static void main(String args[])
    {
        NotificationService notificationService =  new NotificationService();

        User user1 = new User("Karthik");
        User user2 = new User("Divakar");

        notificationService.addUser(user1);
        notificationService.addUser(user2);

        Message message1 = new Message("Message one");
        Message message2 = new Message("Message two");

        notificationService.sendMessage(message1);
        notificationService.sendMessage(message2);

        user1.readMessage(message1);

        user1.getUnReadMessages().forEach(message -> System.out.println(message));

    }
}
