package service;

import db.Query.UserQuery;
import model.User;
import model.UserInfo;
import model.UserType;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static db.Query.UserQuery.*;
import static db.Query.UserTypeQuery.GET_USER_TYPE_ID_BY_NAME;

public class UserServiceImpl extends Service implements UserService{
    final static Logger logger = Logger.getLogger(BankServiceImpl.class);
    public UserServiceImpl(){
        super();
    }
    @Override
    public void createUser(int id,String name, int typeId) {
            try {
               statement.executeUpdate(String.format(CREATE_USER,id,typeId,name));
            } catch (SQLException e) {
                logger.error("ERROR TO CREATE");
            }
    }

    @Override
    public List<UserInfo> getAllUsers() {
        List<UserInfo> result=new LinkedList<>();
        try {
            ResultSet resultSet=statement.executeQuery(GET_ALL_USERS);
            while(resultSet.next()){
                UserInfo userInfo=new UserInfo();
                int id = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String userType = resultSet.getString(3);
                userInfo.setId(id);
                userInfo.setUserType(userType);
                userInfo.setName(userName);
                result.add(userInfo);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET ALL USER");
        }
        return result;
    }

    @Override
    public List<UserInfo> getAllUsersByType(String type) {
        List<UserInfo> result=new LinkedList<>();
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_ALL_USERS_BY_TYPE,type));
            while(resultSet.next()){
                UserInfo userInfo=new UserInfo();
                int id = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String userType = resultSet.getString(3);
                userInfo.setId(id);
                userInfo.setUserType(userType);
                userInfo.setName(userName);
                result.add(userInfo);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET ALL USERS BY TYPE");
        }
        return result;
    }

    @Override
    public User getUserByName(String name) {
        User result=null;
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_USER_BY_NAME,name));
            if(resultSet.next()){
                result=new User();
                int id = resultSet.getInt(1);
                int userTypeId = resultSet.getInt(2);
                String userName = resultSet.getString(3);
                result.setId(id);
                result.setUserType(userTypeId);
                result.setName(userName);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET USER BY NAME");
        }
        return result;
    }

    @Override
    public User getUserById(int idUser) {
        User result=null;
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_USER_BY_ID,idUser));
            if(resultSet.next()){
                result=new User();
                int id = resultSet.getInt(1);
                int userTypeId = resultSet.getInt(2);
                String userName = resultSet.getString(3);
                result.setId(id);
                result.setUserType(userTypeId);
                result.setName(userName);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET USER BY NAME");
        }
        return result;
    }

    @Override
    public void deleteUserById(int id) {
        try {
            statement.executeUpdate(String.format(DELETE_USER_BY_ID,id));
        } catch (SQLException e) {
            logger.error("ERROR TO DELETE USER BY ID");
        }
    }

    @Override
    public void updateUserTypeById(int userTypeId,int id) {
        try {
            statement.executeUpdate(String.format(UPDATE_USER_TYPE_BY_ID,userTypeId,id));
        } catch (SQLException e) {
            logger.error("ERROR TO UPDATE USER TYPE BY ID");
        }

    }

    @Override
    public void updateUserNameById(String name,int id) {
        try {
            statement.executeUpdate(String.format(UPDATE_USER_NAME_BY_ID,name,id));
        } catch (SQLException e) {
            logger.error("ERROR TO UPDATE USER NAME BY ID");
        }
    }
}
