package service;

import model.UserType;

import java.util.List;

public interface UserTypeService {
    public List<UserType> getAllUserType();
    public UserType getUserTypeNameById(int id);
    public UserType getUserTypeIdByName(String name);
}
