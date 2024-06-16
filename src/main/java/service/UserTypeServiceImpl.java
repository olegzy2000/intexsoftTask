package service;
import model.UserType;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import static db.Query.UserTypeQuery.*;

public class UserTypeServiceImpl extends Service implements UserTypeService{
    final static Logger logger = Logger.getLogger(BankServiceImpl.class);
    public UserTypeServiceImpl(){
        super();
    }
    @Override
    public List<UserType> getAllUserType() {
        List<UserType>result=new LinkedList<UserType>();
        try {
            ResultSet resultSet=statement.executeQuery(GET_ALL_USER_TYPES);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                UserType userType=new UserType();
                userType.setId(id);
                userType.setName(name);
                result.add(userType);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET ALL USER TYPE");
        }
        return result;
    }

    @Override
    public UserType getUserTypeNameById(int id) {
        UserType result=null;
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_USER_TYPE_NAME_BY_ID,id));
            if(resultSet.next()){
                result=new UserType();
                int userTypeId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                result.setId(userTypeId);
                result.setName(name);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET USER TYPE BY ID");
        }
        return result;
    }

    @Override
    public UserType getUserTypeIdByName(String name) {
        UserType result=null;
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_USER_TYPE_ID_BY_NAME,name));
            if(resultSet.next()){
                result=new UserType();
                int userTypeId = resultSet.getInt(1);
                result.setId(userTypeId);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET USER TYPE BY NAME");
        }
        return result;
    }
}
