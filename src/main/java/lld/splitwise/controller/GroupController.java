package lld.splitwise.controller;

import lld.splitwise.model.User;
import lld.splitwise.service.Group;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    List<Group> groupList;

    public GroupController() {
        this.groupList = new ArrayList<>();
    }

    public void createNewGroup(String groupId, String groupName, User createdBy){
        Group group = new Group(groupId, groupName);
        group.addMember(createdBy);
        groupList.add(group);
    }

    public Group getGroupById(String groupId){
        for (Group group : groupList){
            if(group.getGroupId().equals(groupId)){
                return group;
            }
        }
        return null;
    }

}
