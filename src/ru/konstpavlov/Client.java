package ru.konstpavlov;

import ru.konstpavlov.utils.SecurityType;

import java.util.Map;

public class Client {

    private String name;
    private int balance;
    private Map<SecurityType,Integer> securities;

    public Client(String name, int balance, Map<SecurityType, Integer> securities) {
        this.name = name;
        this.balance = balance;
        this.securities = securities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Map<SecurityType, Integer> getSecurities() {
        return securities;
    }

    public void setSecurities(Map<SecurityType, Integer> securities) {
        this.securities = securities;
    }
}
