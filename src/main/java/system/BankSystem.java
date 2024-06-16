package system;

import model.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import service.*;

import java.util.List;
import java.util.Scanner;

import static system.BankSystemCommand.*;

public class BankSystem {
    final static Logger logger = Logger.getLogger(BankSystem.class);
    private BankService bankService;
    private BankAccountService bankAccountService;
    private TransactionService transactionService;
    private CurrencyService currencyService;
    private UserService userService;
    private UserTypeService userTypeService;
    public BankSystem(){
        initLogger();
        initServices();
        startBankSystem();
    }

    private void initLogger() {
        BasicConfigurator.configure();
    }

    private void startBankSystem() {
        String command="";
        System.out.println(ALL_COMMAND_MESSAGE);
        while(!command.equals("exit")){
            logger.info("please input command:");
            Scanner input = new Scanner(System.in);
            command=input.nextLine();
            if(command.equals(SHOW_ALL_COMMAND)){
                System.out.println(ALL_COMMAND_MESSAGE);
            }
            else if(command.equals(GET_BANKS_COMMAND)){
                executeGetBanksCommand();
            }
            else if(command.contains(NEW_BANK_ACCOUNT_COMMAND)){
                executeNewBankAccountCommand(command);
            }
            else if(command.contains(NEW_BANK_COMMAND)){
                executeNewBankCommand(command);
            }
            else if(command.contains(UPDATE_BANK_COMMAND)){
                executeUpdateBankCommand(command);
            }
            else if(command.contains(DELETE_BANK_COMMAND)){
                executeDeleteBankCommand(command);
            }
            else if(command.equals(SHOW_ALL_USERS_COMMAND)){
                executeShowAllUsersCommand();
            }
            else if(command.contains(DELETE_USER_COMMAND)){
                executeDeleteUserCommand(command);
            }
            else if(command.contains(UPDATE_USER_COMMAND)){
                executeUpdateUserCommand(command);
            }
            else if(command.equals(SHOW_ALL_BANK_ACCOUNT_COMMAND)){
                executeShowAllBankAccountCommand();
            }
            else if(command.contains(DELETE_BANK_COMMAND)){
                executeDeleteBankCommand(command);
            }
            else if(command.contains(SHOW_TRANSACTION_FOR_PERIOD_COMMAND)){
                executeShowTransactionForPeriodCommand(command);
            }
            else if(command.contains(CREATE_USER_COMMAND)){
                executeCreateUserCommand(command);
            }
            else if(command.contains(CREATE_TRANSACTION_COMMAND)){
                executeCreateTransactionCommand(command);
            }

        }
    }

    private void executeCreateTransactionCommand(String command) {
        String []params=command.split(" ");
        if(params.length==5){
            try {
                BankAccount sendBankAccount=null;
                BankAccount getBankAccount=null;
                int sendAccountId = Integer.parseInt(params[2]);
                if((sendBankAccount=bankAccountService.getBankAccountById(sendAccountId))==null){
                    logger.error("SEND ACCOUNT NOT FOUND");
                    return;
                }
                int getAccountId = Integer.parseInt(params[3]);
                if((getBankAccount=bankAccountService.getBankAccountById(getAccountId))==null){
                    logger.error("GET ACCOUNT NOT FOUND");
                    return;
                }
                if(sendBankAccount.getCurrencyId()!=getBankAccount.getCurrencyId()){
                    logger.error("CAN NOT TO DO TRANSACTION BECAUSE ACCOUNTS HAS DIFFERENT CURRENCY");
                    return;
                }
                int sendUserType=userService.getUserById(sendBankAccount.getUserId()).getUserType();
                float commission=0.0f;
                if(sendUserType==1) {
                    commission=bankService.getBankById(sendBankAccount.getBankId()).getPhysCommission();
                }
                else{
                    commission=bankService.getBankById(sendBankAccount.getBankId()).getJurCommission();
                }
                float sum = Float.parseFloat(params[4]);
                if(sendBankAccount.getSum()<sum+(sum*commission)){
                    logger.error("CAN NOT TO DO TRANSACTION BECAUSE SEND ACCOUNT HASN't MONEY");
                    return;
                }
                transactionService.createTransaction(sendAccountId,getAccountId,sum);
                bankAccountService.updateBankAccountSumById(sendAccountId,-(sum+sum*commission));
                bankAccountService.updateBankAccountSumById(getAccountId,sum);
            }
            catch (NumberFormatException e){
                logger.error("ERROR IN READ NUMBERS");
            }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }

    private void executeCreateUserCommand(String command) {
        String []params=command.split(" ");
        if(params.length==8){
            try {
                int userId = Integer.parseInt(params[2]);
                int typeId = Integer.parseInt(params[3]);
                String userName = params[4];
                int currencyId = Integer.parseInt(params[5]);
                float sum = Float.parseFloat(params[6]);
                int bankId = Integer.parseInt(params[7]);
                userService.createUser(userId,userName,typeId);
                executeNewBankAccountForNewUserCommand(bankId,userId,currencyId,sum);
            }
            catch (NumberFormatException e){
                logger.error("ERROR IN READ NUMBERS");
            }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }

    private void executeNewBankAccountCommand(String command) {
        String []params=command.split(" ");
        if(params.length==8){
            try {
                int bankId = Integer.parseInt(params[4]);
                int userId = Integer.parseInt(params[5]);
                int currencyId = Integer.parseInt(params[6]);
                float sum = Integer.parseInt(params[7]);
                executeNewBankAccountForNewUserCommand(bankId,userId,currencyId,sum);
            }
            catch (NumberFormatException e){
                logger.error("ERROR IN READ NUMBERS");
            }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }
    private void executeNewBankAccountForNewUserCommand(int bankId,int userId,int currencyId,float sum) {
        if(currencyService.getCurrencyById(currencyId)==null){
            logger.error("CURRENCY NOT FOUND");
            return;
        }
        if(userService.getUserById(userId)==null){
            logger.error("USER NOT FOUNDED");
            return;
        }
        if(bankService.getBankById(bankId)==null){
            logger.error("BANK NOT FOUND");
            return;
        }
        bankAccountService.createBankAccount(userId,bankId,currencyId,sum);
    }

    private void executeShowTransactionForPeriodCommand(String command) {
        String []params=command.split(" ");
        if(params.length==8){
                String dateFromDate=params[4];
                String dateFromTime=params[5];
                String dateToDate=params[6];
                String dateToTime=params[7];
                List<Transaction>result=transactionService.getTransactionsByPeriod(dateFromDate+" "+dateFromTime,dateToDate+" "+dateToTime);
                for(Transaction object:result){
                    System.out.println(object.toString());
                }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }

    private void executeShowAllBankAccountCommand() {
        List<BankAccountInfo> result=bankAccountService.getAllBankAccountInfo();
        for(BankAccountInfo object:result){
            System.out.println(object.toString());
        }
    }

    private void executeUpdateUserCommand(String command) {
        String []params=command.split(" ");
        if(params.length==4){
            try {
                String name=params[2];
                int id = Integer.parseInt(params[3]);
                userService.updateUserNameById(name,id);
            }
            catch (NumberFormatException e){
                logger.error("ERROR IN READ ID");
            }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }

    private void executeDeleteUserCommand(String command) {
        String []params=command.split(" ");
        if(params.length==3){
            try {
                int id = Integer.parseInt(params[2]);
                transactionService.deleteTransactionBySendAccountId(id);
                bankAccountService.deleteAllAccountByUserId(id);
                userService.deleteUserById(id);
            }
            catch (NumberFormatException e){
                logger.error("ERROR IN READ ID");
            }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }

    private void executeShowAllUsersCommand() {
        List<UserInfo> result=userService.getAllUsers();
        for(UserInfo object:result){
            System.out.println(object.toString());
        }
    }

    private void executeDeleteBankCommand(String command) {
        String []params=command.split(" ");
        if(params.length==3){
            try {
                int id = Integer.parseInt(params[2]);
                bankService.deleteBankById(id);
            }
            catch (NumberFormatException e){
                logger.error("ERROR IN READ ID");
            }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }

    private void executeUpdateBankCommand(String command) {
        String []params=command.split(" ");
        if(params.length==4){
            String bankName=params[2];
            try {
                int id = Integer.parseInt(params[3]);
                bankService.updateBankById(bankName, id);
            }
            catch (NumberFormatException e){
                logger.error("ERROR IN READ ID");
            }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }

    private void executeNewBankCommand(String command) {
        String []params=command.split(" ");
        if(params.length==5){
            String bankName=params[2];
            try {
                float physCommission = Float.parseFloat(params[3]);
                float jurCommission = Float.parseFloat(params[4]);
                bankService.createBank(bankName, physCommission, jurCommission);
            }
            catch (NumberFormatException e){
                logger.error("ERROR IN READ COMMISSION");
            }
        }
        else{
            logger.error("ERROR IN AMOUNT ARGS FOR COMMAND");
        }
    }

    private void executeGetBanksCommand() {
        List<Bank>result=bankService.getAllBanks();
        for (Bank object:result){
            System.out.println(object.toString());
        }
    }

    private void initServices() {
        bankService=new BankServiceImpl();
        bankAccountService=new BankAccountServiceImpl();
        transactionService=new TransactionServiceImpl();
        currencyService=new CurrencyServiceImpl();
        userService=new UserServiceImpl();
        userTypeService=new UserTypeServiceImpl();
    }
}
