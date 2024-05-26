package NotificationSystem;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private String userId;
    private String name;
    private HashMap<Message , Boolean> messageReadStatus;

    public User(String name)
    {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        messageReadStatus = new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public HashMap<Message, Boolean> getMessageReadStatus() {
        return messageReadStatus;
    }

    public void receiveMessage(Message message)
    {
        this.messageReadStatus.put(message,false);
    }

    public void readMessage(Message message)
    {
        this.messageReadStatus.put(message,true);
    }

    public List<Message> getUnReadMessages()
    {
        List<Message> unReadMessages = new ArrayList<>();
        unReadMessages = messageReadStatus.entrySet().stream()
                .filter(entry -> !entry.getValue())
                .map(Map.Entry :: getKey)
                .collect(Collectors.toList());
        return unReadMessages;
    }
}
