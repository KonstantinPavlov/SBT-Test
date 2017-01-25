package main.ru.konstpavlov.exchangeUtils;

import main.ru.konstpavlov.utils.SecurityType;

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

    public String getSecuritiesString(){
        String result="";
        for (Map.Entry<SecurityType,Integer> entry:securities.entrySet()) {
            result = result+ entry.getValue().toString() + "\t";
        }
        result = result.substring(0,result.length()-1);
        return result;
    }

    @Override
    public int hashCode(){
    int result = name.hashCode();
        result = 31*result +balance;
        for (Map.Entry<SecurityType,Integer> entry: securities.entrySet()) {
            result= result+ entry.getKey().hashCode()+ entry.getValue();
        }
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Client) ) return false;
        Client client = (Client) o;

        if (!this.name.equals(client.getName())) {
            return false;
        }
        else if (this.balance != client.getBalance()){
            return false;
        }
        return this.securities.equals(client.getSecurities());
    }
}
