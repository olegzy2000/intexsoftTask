package service;

import model.Currency;
import model.UserType;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static db.Query.CurrencyQuery.*;
import static db.Query.UserTypeQuery.GET_ALL_USER_TYPES;

public class CurrencyServiceImpl extends Service implements CurrencyService{
    final static Logger logger = Logger.getLogger(BankServiceImpl.class);
    @Override
    public List<Currency> getAllCurrency() {
        List<Currency>result=new LinkedList<Currency>();
        try {
            ResultSet resultSet=statement.executeQuery(GET_ALL_CURRENCY);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Currency currency=new Currency();
                currency.setId(id);
                currency.setName(name);
                result.add(currency);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET ALL CURRENCY");
        }
        return result;
    }

    @Override
    public Currency getCurrencyById(int id) {
        Currency result=null;
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_CURRENCY_BY_ID,id));
            if(resultSet.next()){
                result=new Currency();
                int currencyId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                result.setId(currencyId);
                result.setName(name);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET CURRENCY BY ID:"+id);
        }
        return result;
    }

    @Override
    public Currency getIdByCurrencyName(String name) {
        Currency result=null;
        try {
            ResultSet resultSet=statement.executeQuery(String.format(GET_ID_BY_CURRENCY_NAME,name));
            if(resultSet.next()){
                result=new Currency();
                int currencyId = resultSet.getInt(1);
                result.setId(currencyId);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error("ERROR TO GET CURRENCY BY NAME:"+name);
        }
        return result;
    }
}
