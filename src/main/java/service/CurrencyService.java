package service;

import model.Currency;

import java.util.List;

public interface CurrencyService {
    public List<Currency> getAllCurrency();
    public Currency getCurrencyById(int id);
    public Currency getIdByCurrencyName(String name);
}
