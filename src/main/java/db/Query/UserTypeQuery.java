package db.Query;

public class UserTypeQuery {
    public static final String GET_ALL_USER_TYPES="select * from UserType";
    public static final String GET_USER_TYPE_NAME_BY_ID="select * from UserType where id=%s";
    public static final String GET_USER_TYPE_ID_BY_NAME="select ID from UserType where TYPE_NAME='%s'";
}
