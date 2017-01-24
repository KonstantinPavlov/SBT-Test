package main.ru.konstpavlov.operations;

import main.ru.konstpavlov.exchangeUtils.Exchange;
import main.ru.konstpavlov.Order;

public class BuyOperation extends AbstractOperation implements ExchangeOperation {
    @Override
    public void executeOperation(Exchange exchange) {
        // checking queue of sell operation for matching
        if (exchange.getSellList().checkOperation(this)){
            // we found  matching operation
            System.out.println("We found smth");
            // delete sell operation from queue in SellList and make Sell operation
            ExchangeOperation matchingOperation =exchange.getSellList().pullOperation(this);
            exchange.sellOperation(matchingOperation);
            // make Buy operation at Client
            exchange.buyOperation(this);
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
