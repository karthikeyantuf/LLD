package NotificationSystem;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    List<User> users;
    List<Message> messages;

    public NotificationService()
    {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public void addUser(User user)
    {
        this.users.add(user);
    }

    public void sendMessage(Message message)
    {
        this.messages.add(message);
        users.forEach(user -> user.receiveMessage(message));
    }

}
