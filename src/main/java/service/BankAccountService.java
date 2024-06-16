package service;

import model.BankAccount;
import model.BankAccountInfo;

import java.util.List;

public interface BankAccountService {
    public void createBankAccount(int userId,int bankId,int currencyId,float sum);
    public List<BankAccountInfo> getAllBankAccountInfo();
    public List<BankAccount> getAllBankAccount();
    public BankAccount getBankAccountById(int id);
    public List<BankAccountInfo> getBankAccountInfoByUserId(int userId);
    public List<BankAccountInfo> getBankAccountInfoByBankId(int bankId);
    public List<BankAccountInfo> getBankAccountInfoByCurrencyId(int currencyId);
    void updateBankAccountSumById(int id,float sum);

    void deleteAllAccountByUserId(int id);
}
