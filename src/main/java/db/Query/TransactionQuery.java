package db.Query;

public class TransactionQuery {
    public static final String GET_ALL_TRANSACTION="select * from Transaction";
    public static final String DELETE_ALL_TRANSACTIONS_BY_SEND_ACCOUNT_ID="DELETE FROM Transaction where SEND_ACCOUNT_ID=%s ";
    public static final String CREATE_TRANSACTION="insert into Transaction(SEND_ACCOUNT_ID,GET_ACCOUNT_ID,TRANSACTION_SUM) VALUES(%s,%s,%s)";
    public static final String GET_TRANSACTION_BY_PERIOD="select * from Transaction where Transaction.TRANSACTION_DATE>'%s' AND Transaction.TRANSACTION_DATE<'%s'";
    public static final String GET_TRANSACTION_BY_SEND_ACCOUNT_ID="select * from Transaction where SEND_ACCOUNT_ID=%s";
}
