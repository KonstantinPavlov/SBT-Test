package main.ru.konstpavlov.operations;

import main.ru.konstpavlov.exchangeUtils.Exchange;
import main.ru.konstpavlov.Order;

public class BuyOperation extends AbstractOperation implements ExchangeOperation {
    @Override
    public void executeOperation(Exchange exchange) {

    }

    public BuyOperation(String clientName, Order order) {
        super(clientName, order);
    }

    @Override
    public void addOperationToQueue(Exchange exchange, ExchangeOperation operation) {
        exchange.getBuyList().addOperation(operation);
    }
}
