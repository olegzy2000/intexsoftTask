package service;

import model.Bank;

import java.util.List;

public interface BankService {
    public void createBank(String bankName,float physCommission,float jurCommission);
    public List<Bank> getAllBanks();
    public Bank getBankByName(String name);
    public Bank getBankById(int id);
    public void deleteBankById(int id);
    public void updateBankById(String name,int id);
}
