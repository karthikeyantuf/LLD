package CarRental.DAO;

import CarRental.Model.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, User> users;

    public UserManager()
    {
        this.users = new HashMap<>();
    }

    public void addUser(User user)throws Exception
    {
        for(User u : users.values())
        {
            if(u.getName().equals(user.getName()))
            {
                throw new Exception("User Already Exists");
            }
        }
        users.put(user.getName(), user);
    }

    public User getUser(String userName)
    {
        for(User u : users.values())
        {
            if(u.getName().equals(userName))
            {
                return u;
            }
        }
        return null;
    }
}
