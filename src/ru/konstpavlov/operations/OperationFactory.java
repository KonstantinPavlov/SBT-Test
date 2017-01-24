package ru.konstpavlov.operations;

import ru.konstpavlov.Order;

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
