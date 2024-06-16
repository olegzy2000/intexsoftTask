package db.Query;

public class BankQuery {
    public static final String CREATE_BANK="insert into Bank(NAME,PHYSICAL_COMMISSION,JURIDICAL_COMMISSION) values ('%s',%s,%s)";
    public static final String GET_ALL_BANKS="select * from Bank";
    public static final String GET_BANK_BY_NAME="select DISTINCT * from Bank where name='%s' ";
    public static final String GET_BANK_BY_ID="select DISTINCT * from Bank where ID='%s' ";
    public static final String DELETE_BANK_BY_ID="DELETE FROM Bank where id=%s ";
    public static final String UPDATE_BANK_BY_ID="UPDATE Bank SET NAME='%s' where id=%s ";
}
