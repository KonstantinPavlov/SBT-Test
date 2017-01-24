package ru.konstpavlov.operations;

import ru.konstpavlov.Order;

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
}
