package main.ru.konstpavlov.operations;

import main.ru.konstpavlov.exchangeUtils.Order;

public class OperationFactory {
    public ExchangeOperation getOperation(String operationType, String clientName, Order order){
        switch (operationType){
            case "s":
                return  new SellOperation(clientName,order);
            case "b":
                return new BuyOperation(clientName,order);
            default:
                throw new IllegalArgumentException();
        }
    }
}
