package main.ru.konstpavlov.operations;

import main.ru.konstpavlov.exchangeUtils.Exchange;
import main.ru.konstpavlov.Order;

public class SellOperation extends AbstractOperation implements ExchangeOperation {
    @Override
    public void executeOperation(Exchange exchange) {
        // checking queue of sell operation for matching
        if (exchange.getBuyList().checkOperation(this)){
            // we found  matching operation
            System.out.println("We found smth");
            // delete sell operation from queue in SellList and make Sell operation

            // make Buy operation at Client
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
