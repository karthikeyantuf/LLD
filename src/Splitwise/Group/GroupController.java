package Splitwise.Group;

import Splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groups;

    public GroupController()
    {
        groups = new ArrayList<>();
    }

    public void createGroup(String grpId, String grpName, User user)
    {
        Group group = new Group(grpId,grpName);
        group.addMember(user); // createdByUser is sent and it is added as one of the user
        groups.add(group);
    }

    public Group getGroup(String groupId)
    {
        for(Group group : groups)
        {
            if(group.getGroupId().equals(groupId))
            {
                return group;
            }
        }
        return  null;
    }

}
