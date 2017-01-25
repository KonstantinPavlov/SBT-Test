package main.ru.konstpavlov.operations;
import main.ru.konstpavlov.exchangeUtils.Order;
import main.ru.konstpavlov.exchangeUtils.Exchange;

public interface ExchangeOperation {
    void executeOperation(Exchange exchange);
    void addOperationToQueue(Exchange exchange);
    Order getOrder();
    String getClientName();
}
