package model;

public class BankAccount {
    private int id;
    private int currencyId;
    private int bankId;
    private int userId;
    private float sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccount{");
        sb.append("id=").append(id);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", bankId=").append(bankId);
        sb.append(", userId=").append(userId);
        sb.append(", sum=").append(sum);
        sb.append('}');
        return sb.toString();
    }
}
