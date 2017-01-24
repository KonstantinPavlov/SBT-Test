package ru.konstpavlov.operations;
import ru.konstpavlov.Order;
import ru.konstpavlov.exchangeUtils.Exchange;

public interface ExchangeOperation {
    void executeOperation(Exchange exchange);

    void addOperationToQueue(Exchange exchange,ExchangeOperation operation);
    Order getOrder();
}
