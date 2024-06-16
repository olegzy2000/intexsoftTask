package model;

public class BankAccountInfo {
    private int id;
    private String bankName;
    private String userName;
    private String currencyName;
    private float sum;

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccountInfo{");
        sb.append("id=").append(id);
        sb.append(", bankName='").append(bankName).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", currencyName='").append(currencyName).append('\'');
        sb.append(", sum=").append(sum);
        sb.append('}');
        return sb.toString();
    }
}
