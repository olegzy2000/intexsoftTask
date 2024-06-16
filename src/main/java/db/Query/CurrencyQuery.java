package db.Query;

public class CurrencyQuery {
    public static final String GET_ALL_CURRENCY="select * from Currency";
    public static final String GET_CURRENCY_BY_ID="select * from Currency where ID=%s";
    public static final String GET_ID_BY_CURRENCY_NAME="select ID from Currency where NAME='%s'";
}
