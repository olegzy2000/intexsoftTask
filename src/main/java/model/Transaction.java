package model;

import java.util.Date;

public class Transaction {
    private int id;
    private int idSendBankAccount;
    private int idGetBankAccount;
    private float transactionSum;
    private Date dateTransaction;

    public int getId() {
        return id;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSendBankAccount() {
        return idSendBankAccount;
    }

    public void setIdSendBankAccount(int idSendBankAccount) {
        this.idSendBankAccount = idSendBankAccount;
    }

    public int getIdGetBankAccount() {
        return idGetBankAccount;
    }

    public void setIdGetBankAccount(int idGetBankAccount) {
        this.idGetBankAccount = idGetBankAccount;
    }

    public float getTransactionSum() {
        return transactionSum;
    }

    public void setTransactionSum(float transactionSum) {
        this.transactionSum = transactionSum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("id=").append(id);
        sb.append(", idSendBankAccount=").append(idSendBankAccount);
        sb.append(", idGetBankAccount=").append(idGetBankAccount);
        sb.append(", transactionSum=").append(transactionSum);
        sb.append(", dateTransaction=").append(dateTransaction);
        sb.append('}');
        return sb.toString();
    }
}
