package main.ru.konstpavlov.operations;

import main.ru.konstpavlov.exchangeUtils.Exchange;
import main.ru.konstpavlov.Order;

public class SellOperation extends AbstractOperation implements ExchangeOperation {
    @Override
    public void executeOperation(Exchange exchange) {
        if (exchange.getBuyList().checkOperation(this)){
            ExchangeOperation matchingOperation =exchange.getBuyList().pullOperation(this);
            exchange.buyOperation(matchingOperation);
            exchange.sellOperation(this);
        }
        else {
            addOperationToQueue(exchange);
        }
    }

    public SellOperation(String clientName, Order order) {
        super(clientName, order);
    }

    @Override
    public void addOperationToQueue(Exchange exchange) {
        exchange.getSellList().addOperation(this);
    }
}
