package service;

import model.BankAccountInfo;
import model.Transaction;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static db.Query.TransactionQuery.*;

public class TransactionServiceImpl extends Service implements TransactionService {
    final static Logger logger = Logger.getLogger(BankServiceImpl.class);
    @Override
    public List<Transaction> getAllTransaction() {
        List<Transaction>result=new LinkedList<Transaction>();
        try {
            ResultSet resultSet=statement.executeQuery(GET_ALL_TRANSACTION);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                int sendAccountId = resultSet.getInt(2);
                int getAccountId = resultSet.getInt(3);
                float sum = resultSet.getFloat(4);
                Date date = resultSet.getDate(5);
                Transaction transaction=new Transaction();
                transaction.setId(id);
                transaction.setDateTransaction(date);
                transaction.setTransactionSum(sum);
                transaction.setIdGetBankAccount(getAccountId);
                transaction.setIdSendBankAccount(sendAccountId);
                result.add(transaction);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET ALL TRANSACTION");
        }
        return result;
    }

    @Override
    public List<Transaction> getTransactionsByPeriod(String dateFromString, String dateToString) {
        List<Transaction>result=new LinkedList<Transaction>();
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_TRANSACTION_BY_PERIOD,dateFromString,dateToString));
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                int sendAccountId = resultSet.getInt(2);
                int getAccountId = resultSet.getInt(3);
                float sum = resultSet.getFloat(4);
                Date date = resultSet.getDate(5);
                Transaction transaction=new Transaction();
                transaction.setId(id);
                transaction.setDateTransaction(date);
                transaction.setTransactionSum(sum);
                transaction.setIdGetBankAccount(getAccountId);
                transaction.setIdSendBankAccount(sendAccountId);
                result.add(transaction);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET TRANSACTIONS BY PERIOD");
        }
        return result;
    }

    @Override
    public void createTransaction(int sendAccountId, int getAccountId, float transactionSum) {
        try {
            statement.executeUpdate(String.format(CREATE_TRANSACTION,sendAccountId,getAccountId,transactionSum));
        } catch (SQLException e) {
            logger.error("ERROR TO CREATE TRANSACTION");
        }
    }

    @Override
    public List<Transaction> getTransactionBySendAccountId(int sendAccountIdSearch) {
        List<Transaction>result=new LinkedList<Transaction>();
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_TRANSACTION_BY_SEND_ACCOUNT_ID,sendAccountIdSearch));
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                int sendAccountId = resultSet.getInt(2);
                int getAccountId = resultSet.getInt(3);
                float sum = resultSet.getFloat(4);
                Date date = resultSet.getDate(5);
                Transaction transaction=new Transaction();
                transaction.setId(id);
                transaction.setDateTransaction(date);
                transaction.setTransactionSum(sum);
                transaction.setIdGetBankAccount(getAccountId);
                transaction.setIdSendBankAccount(sendAccountId);
                result.add(transaction);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET TRANSACTION BY SEND ACCOUNT");
        }
        return result;
    }

    @Override
    public void deleteTransactionBySendAccountId(int id) {
        try {
            statement.executeUpdate(String.format(DELETE_ALL_TRANSACTIONS_BY_SEND_ACCOUNT_ID,id));
        } catch (SQLException e) {
            logger.error("ERROR TO DELETE TRANSACTION BY SEND ACCOUNT");
        }
    }
}
