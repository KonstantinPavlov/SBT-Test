package ru.konstpavlov.operations;

import ru.konstpavlov.exchangeUtils.Exchange;
import ru.konstpavlov.Order;

public class BuyOperation extends AbstractOperation implements ExchangeOperation {
    @Override
    public void executeOperation(Exchange exchange) {

    }

    public BuyOperation(String clientName, Order order) {
        super(clientName, order);
    }

    @Override
    public void addOperationToQueue(Exchange exchange) {

    }
}
