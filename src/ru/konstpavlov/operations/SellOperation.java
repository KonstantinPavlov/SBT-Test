package ru.konstpavlov.operations;

import ru.konstpavlov.exchangeUtils.Exchange;
import ru.konstpavlov.Order;

/**
 * Created by Константин on 23.01.2017.
 */
public class SellOperation extends AbstractOperation implements ExchangeOperation {
    @Override
    public void executeOperation(Exchange exchange) {

    }

    public SellOperation(String clientName, Order order) {
        super(clientName, order);
    }

    @Override
    public void addOperationToQueue(Exchange exchange) {
        exchange.getSellList().addOperation();
    }
}
