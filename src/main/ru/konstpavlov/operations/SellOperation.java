package main.ru.konstpavlov.operations;

import main.ru.konstpavlov.exchangeUtils.Exchange;
import main.ru.konstpavlov.exchangeUtils.Order;

public class SellOperation extends AbstractOperation implements ExchangeOperation {
    @Override
    public void executeOperation(Exchange exchange) {
        if (exchange.getBuyList().checkOperation(this)){
            ExchangeOperation matchingOperation =exchange.getBuyList().pollOperation(this);

            if (!matchingOperation.getClientName().equals(this.getClientName())) {
                exchange.buyOperation(matchingOperation);
                exchange.sellOperation(this);
            }
            else{
                System.out.println("Sell an Buy for similar client");
            }
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
