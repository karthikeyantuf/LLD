package NotificationSystem;

import java.util.Objects;
import java.util.UUID;

public class Message {
    private String messageId;
    private String content;

    public Message(String content)
    {
        this.messageId = UUID.randomUUID().toString();
        this.content = content;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getContent() {
        return content;
    }

    public boolean equals(Object o)
    {
        if(this == o)return true;
        if(o == null && getClass() != o.getClass())return false;
        Message message = (Message) o;
        return Objects.equals(this.messageId , ((Message) o).getMessageId());
    }

    public int hashCode()
    {
       return Objects.hash(messageId);
    }

    public String toString()
    {
        return this.content;
    }

}
