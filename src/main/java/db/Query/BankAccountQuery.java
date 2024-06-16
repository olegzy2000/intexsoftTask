package db.Query;

public class BankAccountQuery {
    public static final String CREATE_BANK_ACCOUNT="insert into Bank_Account(BANK_ID,USER_ID,CURRENCY_ID,SUM) values (%s,%s,%s,%s)";
    public static final String GET_ALL_BANK_ACCOUNT_INFO="select Bank_Account.ID,Bank.NAME,User.USER_NAME,Currency.NAME,Bank_Account.SUM from Bank_Account INNER JOIN Currency ON Bank_Account.CURRENCY_ID = Currency.ID INNER JOIN Bank ON Bank_Account.BANK_ID=Bank.ID INNER JOIN User ON User.ID=Bank_Account.BANK_ID";
    public static final String GET_ALL_BANK_ACCOUNT="select * from Bank_Account";
    public static final String GET_BANK_ACCOUNT_BY_ID="select distinct * from Bank_Account where id=%s";
    public static final String UPDATE_SUM_BANK_ACCOUNT_BY_ID="UPDATE Bank_Account set SUM=SUM+(%s) where id=%s";
    public static final String DELETE_BANKS_ACCOUNT_BY_USER_ID="DELETE FROM Bank_Account where user_id=%s ";
    public static final String GET_ALL_ACCOUNT_BY_USER_ID="select Bank_Account.ID,Bank.NAME,User.USER_NAME,Currency.NAME,Bank_Account.SUM  from Bank_Account INNER JOIN Currency ON Bank_Account.CURRENCY_ID = Currency.ID INNER JOIN Bank ON Bank_Account.BANK_ID=Bank.ID INNER JOIN User ON User.ID=Bank_Account.BANK_ID where User.ID=%s";
    public static final String GET_ALL_ACCOUNT_BY_BANK_ID="select Bank_Account.ID,Bank.NAME,User.USER_NAME,Currency.NAME,Bank_Account.SUM  from Bank_Account INNER JOIN Currency ON Bank_Account.CURRENCY_ID = Currency.ID INNER JOIN Bank ON Bank_Account.BANK_ID=Bank.ID INNER JOIN User ON User.ID=Bank_Account.BANK_ID where Bank.ID=%s ";
    public static final String GET_ALL_ACCOUNT_BY_CURRENCY_ID="select Bank_Account.ID,Bank.NAME,User.USER_NAME,Currency.NAME,Bank_Account.SUM  from Bank_Account INNER JOIN Currency ON Bank_Account.CURRENCY_ID = Currency.ID INNER JOIN Bank ON Bank_Account.BANK_ID=Bank.ID INNER JOIN User ON User.ID=Bank_Account.BANK_ID where Currency.ID=%s ";
}
