package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id){
        userService.deleteUser(id);

        List<User> allUsers = getAllUsers();
        modelData.setUsers(allUsers);
    }

    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name, id, level);

        List<User> allUsers = getAllUsers();
        modelData.setUsers(allUsers);
    }

    private List<User> getAllUsers(){
        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
        List<User> filterOnlyActiveUsers = userService.filterOnlyActiveUsers(allUsers);
        return filterOnlyActiveUsers;
    }

}
