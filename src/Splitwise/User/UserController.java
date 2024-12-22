package Splitwise.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> users;

    public UserController()
    {
        users = new ArrayList<>();
    }

    public void addUser(User user)
    {
        this.users.add(user);
    }

    public List<User> getUsers()
    {
        return users;
    }

    public User getUser(String userId)
    {
        for(User user : users)
        {
            if(user.getUserId().equals(userId))
            {
                return user;
            }
        }
        return  null;
    }

}
