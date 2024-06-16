package service;


import model.Bank;
import model.BankAccount;
import model.BankAccountInfo;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static db.Query.BankAccountQuery.*;

public class BankAccountServiceImpl extends Service implements BankAccountService{
    final static Logger logger = Logger.getLogger(BankAccountServiceImpl.class);
    @Override
    public void createBankAccount(int userId, int bankId, int currencyId, float sum) {
        try {
            statement.executeUpdate(String.format(CREATE_BANK_ACCOUNT,bankId,userId,currencyId,sum));
        } catch (SQLException e) {
            logger.error("ERROR TO CREATE BANK ACCOUNT");
        }
    }

    @Override
    public List<BankAccountInfo> getAllBankAccountInfo() {
        List<BankAccountInfo>result=new LinkedList<BankAccountInfo>();
        try {
            ResultSet resultSet=statement.executeQuery(GET_ALL_BANK_ACCOUNT_INFO);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String bankName = resultSet.getString(2);
                String userName = resultSet.getString(3);
                String currencyName = resultSet.getString(4);
                float sum = resultSet.getFloat(5);
                BankAccountInfo bankAccountInfo=new BankAccountInfo();
                bankAccountInfo.setId(id);
                bankAccountInfo.setBankName(bankName);
                bankAccountInfo.setCurrencyName(currencyName);
                bankAccountInfo.setUserName(userName);
                bankAccountInfo.setSum(sum);
                result.add(bankAccountInfo);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET ALL BANK ACCOUNTS INFO");
        }
        return result;
    }

    @Override
    public List<BankAccount> getAllBankAccount() {
        List<BankAccount>result=new LinkedList<BankAccount>();
        try {
            ResultSet resultSet=statement.executeQuery(GET_ALL_BANK_ACCOUNT);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                int bankId = resultSet.getInt(2);
                int userId = resultSet.getInt(3);
                int currencyId = resultSet.getInt(4);
                float sum = resultSet.getFloat(5);
                BankAccount bankAccount=new BankAccount();
                bankAccount.setId(id);
                bankAccount.setBankId(bankId);
                bankAccount.setUserId(userId);
                bankAccount.setCurrencyId(currencyId);
                bankAccount.setSum(sum);
                result.add(bankAccount);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET ALL BANK ACCOUNTS");
        }
        return result;
    }

    @Override
    public BankAccount getBankAccountById(int idAccount) {
        BankAccount result=null;
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_BANK_ACCOUNT_BY_ID,idAccount));
            if(resultSet.next()){
                int id = resultSet.getInt(1);
                int bankId = resultSet.getInt(2);
                int userId = resultSet.getInt(3);
                int currencyId = resultSet.getInt(4);
                float sum = resultSet.getFloat(5);
                result=new BankAccount();
                result.setId(id);
                result.setBankId(bankId);
                result.setCurrencyId(currencyId);
                result.setUserId(userId);
                result.setSum(sum);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET BANK ACCOUNT INFO BY ID");
        }
        return result;
    }

    @Override
    public List<BankAccountInfo> getBankAccountInfoByUserId(int userId) {
        List<BankAccountInfo>result=new LinkedList<BankAccountInfo>();
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_ALL_ACCOUNT_BY_USER_ID,userId));
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String bankName = resultSet.getString(2);
                String userName = resultSet.getString(3);
                String currencyName = resultSet.getString(4);
                float sum = resultSet.getFloat(5);
                BankAccountInfo bankAccountInfo=new BankAccountInfo();
                bankAccountInfo.setId(id);
                bankAccountInfo.setBankName(bankName);
                bankAccountInfo.setCurrencyName(currencyName);
                bankAccountInfo.setUserName(userName);
                bankAccountInfo.setSum(sum);
                result.add(bankAccountInfo);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET BANK ACCOUNT INFO BY ID:"+userId);
        }
        return result;
    }

    @Override
    public List<BankAccountInfo> getBankAccountInfoByBankId(int bankId) {
        List<BankAccountInfo>result=new LinkedList<BankAccountInfo>();
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_ALL_ACCOUNT_BY_BANK_ID,bankId));
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String bankName = resultSet.getString(2);
                String userName = resultSet.getString(3);
                String currencyName = resultSet.getString(4);
                float sum = resultSet.getFloat(5);
                BankAccountInfo bankAccountInfo=new BankAccountInfo();
                bankAccountInfo.setId(id);
                bankAccountInfo.setBankName(bankName);
                bankAccountInfo.setCurrencyName(currencyName);
                bankAccountInfo.setUserName(userName);
                bankAccountInfo.setSum(sum);
                result.add(bankAccountInfo);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET BANK ACCOUNT INFO BY BANK ID:"+bankId);
        }
        return result;
    }

    @Override
    public List<BankAccountInfo> getBankAccountInfoByCurrencyId(int currencyId) {
        List<BankAccountInfo>result=new LinkedList<BankAccountInfo>();
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_ALL_ACCOUNT_BY_CURRENCY_ID,currencyId));
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String bankName = resultSet.getString(2);
                String userName = resultSet.getString(3);
                String currencyName = resultSet.getString(4);
                float sum = resultSet.getFloat(5);
                BankAccountInfo bankAccountInfo=new BankAccountInfo();
                bankAccountInfo.setId(id);
                bankAccountInfo.setBankName(bankName);
                bankAccountInfo.setCurrencyName(currencyName);
                bankAccountInfo.setUserName(userName);
                bankAccountInfo.setSum(sum);
                result.add(bankAccountInfo);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET BANK ACCOUNT INFO BY CURRENCY ID:"+currencyId);
        }
        return result;
    }

    @Override
    public void updateBankAccountSumById(int id, float sum) {
        try{
            statement.executeUpdate(String.format(UPDATE_SUM_BANK_ACCOUNT_BY_ID,sum,id));
        } catch (SQLException e) {
            logger.error("ERROR TO DELETE BANK ACCOUNT INFO BY USER ID");
        }
    }

    @Override
    public void deleteAllAccountByUserId(int id) {
        try{
           statement.executeUpdate(String.format(DELETE_BANKS_ACCOUNT_BY_USER_ID,id));
        } catch (SQLException e) {
           logger.error("ERROR TO DELETE BANK ACCOUNT INFO BY USER ID");
        }
    }
}
