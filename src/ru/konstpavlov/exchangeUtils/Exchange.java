package ru.konstpavlov.exchangeUtils;
import ru.konstpavlov.Client;
import ru.konstpavlov.Order;
import ru.konstpavlov.utils.SecurityType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exchange {

    private Map<String,Client> clients = new HashMap<>();
    private OperationList sellList = new OperationList();
    private OperationList buyList = new OperationList();


    public Exchange() {

        try( BufferedReader bufferedFileReader = new BufferedReader(new FileReader("src\\ru\\konstpavlov\\resourses\\clients.txt"));
            BufferedReader bufferedFileReader2 = new BufferedReader(new FileReader("src\\ru\\konstpavlov\\resourses\\orders.txt"))) {

            String line;
            while ((line = bufferedFileReader.readLine())!= null){
                String[] temp = line.split("\\t");
                createClient(temp);
            }

            while ((line = bufferedFileReader2.readLine())!= null){
                String[] temp = line.split("\\t");
                createOrder(temp);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createClient(String[] temp){
        int balance = Integer.parseInt(temp[1]);
        Map<SecurityType,Integer> securities = new LinkedHashMap<>();
        securities.put(SecurityType.A,Integer.parseInt(temp[2]));
        securities.put(SecurityType.B,Integer.parseInt(temp[3]));
        securities.put(SecurityType.C,Integer.parseInt(temp[4]));
        securities.put(SecurityType.D,Integer.parseInt(temp[5]));
        Client client = new Client(temp[0],balance,securities);
        this.clients.put(temp[0],client);
    }

    private void createOrder(String[] temp){

    }

    public void calculate(){
        System.out.println("Calculating....");
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public void setClients(Map<String, Client> clients) {
        this.clients = clients;
    }

    public OperationList getSellList() {
        return sellList;
    }

    public void setSellList(OperationList sellList) {
        this.sellList = sellList;
    }

    public OperationList getBuyList() {
        return buyList;
    }

    public void setBuyList(OperationList buyList) {
        this.buyList = buyList;
    }
}
