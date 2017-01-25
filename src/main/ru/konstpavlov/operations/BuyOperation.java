package main.ru.konstpavlov.operations;

import main.ru.konstpavlov.exchangeUtils.Exchange;
import main.ru.konstpavlov.exchangeUtils.Order;

public class BuyOperation extends AbstractOperation implements ExchangeOperation {
    @Override
    public void executeOperation(Exchange exchange) {
        if (exchange.getSellList().checkOperation(this)){

            ExchangeOperation matchingOperation =exchange.getSellList().pollOperation(this);
            if (!matchingOperation.getClientName().equals(this.getClientName())) {
                exchange.sellOperation(matchingOperation);
                exchange.buyOperation(this);
            }
        }
        else {
            addOperationToQueue(exchange);
        }
    }

    public BuyOperation(String clientName, Order order) {
        super(clientName, order);
    }

    @Override
    public void addOperationToQueue(Exchange exchange) {
        exchange.getBuyList().addOperation(this);
    }
}
