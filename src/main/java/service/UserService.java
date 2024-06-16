package service;

import model.User;
import model.UserInfo;

import java.util.List;

public interface UserService {
    public void createUser(int id,String name,int typeId);
    public  List<UserInfo> getAllUsers();
    public List<UserInfo> getAllUsersByType(String type);
    public User getUserByName(String name);
    public User getUserById(int id);
    public void deleteUserById(int id);
    public void updateUserTypeById(int userTypeId,int id);
    public void updateUserNameById(String name,int id);
}
