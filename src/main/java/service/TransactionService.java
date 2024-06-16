package service;

import model.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getAllTransaction();
    public List<Transaction> getTransactionsByPeriod(String dateFromString,String dateToString);
    public void createTransaction(int sendAccountId,int getAccountId,float transactionSum);
    public List<Transaction> getTransactionBySendAccountId(int sendAccountId);

    void deleteTransactionBySendAccountId(int id);
}
