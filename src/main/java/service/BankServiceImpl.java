package service;

import db.DatabaseConnection;
import model.Bank;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static db.Query.BankQuery.*;

public class BankServiceImpl extends Service implements BankService{
    final static Logger logger = Logger.getLogger(BankServiceImpl.class);
   public BankServiceImpl(){
       super();
   }
    @Override
    public void createBank(String bankName,float physCommission,float jurCommissio) {
        try {
            statement.executeUpdate(String.format(CREATE_BANK,bankName,physCommission,jurCommissio));
        } catch (SQLException e) {
            logger.error("ERROR TO CREATE BANK");
        }
    }

    @Override
    public List<Bank> getAllBanks() {
        List<Bank>result=new LinkedList<Bank>();
        try {
            ResultSet resultSet=statement.executeQuery(GET_ALL_BANKS);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float physCommission=resultSet.getFloat(3);
                float jurCommission=resultSet.getFloat(4);
                Bank bank=new Bank();
                bank.setId(id);
                bank.setName(name);
                bank.setJurCommission(jurCommission);
                bank.setPhysCommission(physCommission);
                result.add(bank);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET ALL BANKS");
        }
        return result;
    }

    @Override
    public Bank getBankByName(String name) {
        Bank bank=null;
        try {
                ResultSet resultSet=statement.executeQuery(String.format(GET_BANK_BY_NAME,name));
                if(resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String nameBank = resultSet.getString(2);
                    float physCommission=resultSet.getFloat(3);
                    float jurCommission=resultSet.getFloat(4);
                    bank = new Bank();
                    bank.setId(id);
                    bank.setName(nameBank);
                    bank.setJurCommission(jurCommission);
                    bank.setPhysCommission(physCommission);
                }
                else{
                    logger.info("BANK WITH THIS NAME NOT FOUND");
                }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET BANK BY NAME:"+name);
        }
        return bank;
    }

    @Override
    public Bank getBankById(int idBank) {
        Bank bank=null;
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_BANK_BY_ID,idBank));
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                String nameBank = resultSet.getString(2);
                float physCommission=resultSet.getFloat(3);
                float jurCommission=resultSet.getFloat(4);
                bank = new Bank();
                bank.setId(id);
                bank.setName(nameBank);
                bank.setJurCommission(jurCommission);
                bank.setPhysCommission(physCommission);
            }
            else{
                logger.info("BANK WITH THIS ID NOT FOUND");
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET BANK BY ID");
        }
        return bank;
    }

    @Override
    public void deleteBankById(int id) {
        try {
            statement.executeUpdate(String.format(DELETE_BANK_BY_ID,id));
        } catch (SQLException e) {
            logger.error("ERROR TO DELETE BANK BY ID:"+id);
        }
    }

    @Override
    public void updateBankById(String name,int id) {
        try {
            statement.executeUpdate(String.format(UPDATE_BANK_BY_ID,name,id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
