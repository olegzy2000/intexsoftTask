package system;

public class BankSystemCommand {
    public static final String SHOW_ALL_COMMAND="service info";
    public static final String GET_BANKS_COMMAND="get banks";
    public static final String NEW_BANK_COMMAND="new bank";
    public static final String UPDATE_BANK_COMMAND="update bank";
    public static final String DELETE_BANK_COMMAND="delete bank";
    public static final String CREATE_USER_COMMAND="create user";
    public static final String SHOW_ALL_USERS_COMMAND="show all users";
    public static final String DELETE_USER_COMMAND="delete user";
    public static final String UPDATE_USER_COMMAND="update user";
    public static final String CREATE_TRANSACTION_COMMAND="create transaction";
    public static final String SHOW_TRANSACTION_FOR_PERIOD_COMMAND="show transaction for period";
    public static final String NEW_BANK_ACCOUNT_COMMAND="create new bank account";
    public static final String SHOW_ALL_BANK_ACCOUNT_COMMAND="show all bank account info";


    public static final String ALL_COMMAND_MESSAGE="Hello , this is service to control bank system, you can use next operation:" +
            "\n----------Bank----------"+
            "\n 1)show all bank 'get banks'"+
            "\n 2)create new bank 'new bank bankName physCommission jurCommission'"+
            "\n 3)update bank by id 'update bank newName id'"+
            "\n 4)delete bank by id 'delete bank id'"+
            "\n----------User----------"+
            "\n 1)create new user 'create user id idType name currencyId sum bankId'"+
            "\n 2)show all users 'show all users'"+
            "\n 3)delete user by id 'delete user id'"+
            "\n 4)update user name by id 'update user newName id'"+
            "\n----------Transaction----------"+
            "\n 1)create new transaction 'create transaction sendAccountId getAccountId sum'"+
            "\n 2)show all transaction for period date format=(yyyy-mm-dd hh:mm:ss) 'show transaction for period dateTimeFrom dateTimeTo'"+
            "\n----------Bank Account----------"+
            "\n 1)create new bank account 'create new bank account bankId userId currencyId sum'"+
            "\n 2)show all bank account info 'show all bank account info'"+
            "\n----------Common----------"+
            "\n 1)show all command 'service info'"+
            "\n 2)exit 'exit'";

}
