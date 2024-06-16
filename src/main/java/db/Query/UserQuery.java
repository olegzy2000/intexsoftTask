package db.Query;

public class UserQuery {
    public static final String CREATE_USER="insert into User(ID,USER_TYPE_ID,USER_NAME) values (%s,%s,'%s')";
    public static final String GET_ALL_USERS="select User.ID,User.USER_NAME,UserType.TYPE_NAME from User INNER JOIN UserType ON User.USER_TYPE_ID = UserType.ID";
    public static final String GET_ALL_USERS_BY_TYPE="select User.ID,User.USER_NAME,UserType.TYPE_NAME from User INNER JOIN UserType ON User.USER_TYPE_ID = UserType.ID where UserType.TYPE_NAME='%s'";
    public static final String GET_USER_BY_NAME="select DISTINCT * from User where USER_NAME='%s' ";
    public static final String GET_USER_BY_ID="select DISTINCT * from User where ID='%s' ";
    public static final String DELETE_USER_BY_ID="DELETE FROM User where id=%s ";
    public static final String UPDATE_USER_TYPE_BY_ID="UPDATE User SET USER_TYPE_ID=%s where id=%s ";
    public static final String UPDATE_USER_NAME_BY_ID="UPDATE User SET USER_NAME='%s' where id=%s ";
}
