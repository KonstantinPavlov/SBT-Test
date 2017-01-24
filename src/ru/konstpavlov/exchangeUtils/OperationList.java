package ru.konstpavlov.exchangeUtils;

import ru.konstpavlov.Order;
import ru.konstpavlov.operations.ExchangeOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

public class OperationList {

    private Map<Order,Queue<ExchangeOperation>> operationMap= new LinkedHashMap<>();

    public void addOperation(){}

    public void pullOrder(){}

    public boolean checkOperation(){return true;}

}
