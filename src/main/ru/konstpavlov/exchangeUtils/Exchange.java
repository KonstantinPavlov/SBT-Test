package main.ru.konstpavlov.exchangeUtils;

import main.ru.konstpavlov.Client;
import main.ru.konstpavlov.Order;
import main.ru.konstpavlov.operations.ExchangeOperation;
import main.ru.konstpavlov.operations.OperationFactory;
import main.ru.konstpavlov.utils.SecurityType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exchange {

    private OperationFactory operationFactory = new OperationFactory();
    private Map<String,Client> clients = new LinkedHashMap<>();
    private OperationList sellList = new OperationList();
    private OperationList buyList = new OperationList();

    public Exchange(String clientsFilePath, String ordersFilePath) {

        try( BufferedReader bufferedFileReader = new BufferedReader(new FileReader(clientsFilePath));
            BufferedReader bufferedFileReader2 = new BufferedReader(new FileReader(ordersFilePath))) {

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
        // parsing data
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
        // parsing data
        String clientName = temp[0];
        SecurityType securityType = selectSecurityType(temp[2]);
        Order order = new Order(securityType,Integer.parseInt(temp[3]),Integer.parseInt(temp[4]));
        // call factory for getting correct operation
        ExchangeOperation operation = operationFactory.getOperation(temp[1],clientName,order);
        //check for
        operation.executeOperation(this);
        //add operation to correct operation list
//        operation.addOperationToQueue(this, operation);
    }

    public void sellOperation(ExchangeOperation operation){
        System.out.println("Client " + operation.getClientName());
        System.out.println("Selling  "+ operation.getOrder().getSecurityType() + " count " + operation.getOrder().getSecurityCount() + " cost "+ operation.getOrder().getSecurityCost() );
    }

    public  void buyOperation(ExchangeOperation operation){
        System.out.println("Client " + operation.getClientName());
        System.out.println("Buying  "+ operation.getOrder().getSecurityType() + " count" + operation.getOrder().getSecurityCount() + " cost "+ operation.getOrder().getSecurityCost() );
    }

    private SecurityType selectSecurityType (String text){
        switch (text){
            case "A":
                return SecurityType.A;
            case "B":
                return SecurityType.B;
            case "C":
                return SecurityType.C;
            case "D":
                return SecurityType.D;
            default:
                throw new IllegalArgumentException();
        }

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
