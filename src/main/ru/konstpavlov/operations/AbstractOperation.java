package main.ru.konstpavlov.operations;

import main.ru.konstpavlov.exchangeUtils.Order;

public abstract class AbstractOperation {

    private String clientName;
    private Order order;

    public AbstractOperation(String clientName, Order order) {
        this.clientName = clientName;
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public String getClientName() {
        return clientName;
    }
}
