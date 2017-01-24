package ru.konstpavlov.exchangeUtils;

import ru.konstpavlov.Order;
import ru.konstpavlov.operations.ExchangeOperation;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OperationList {

    private Map<Order,Queue<ExchangeOperation>> operationMap= new LinkedHashMap<>();

    public void addOperation(ExchangeOperation operation){
        // check for operation in map already
        if (operationMap.containsKey(operation.getOrder())){
            this.operationMap.get(operation.getOrder()).add(operation);
        }
        else {
            Queue<ExchangeOperation> queue = new LinkedList<>();
            queue.add(operation);
            this.operationMap.put(operation.getOrder(),queue);
        }
    }

    public void pullOrder(){}

    // Method for check existance of operation in operationMap
    public boolean checkOperation(ExchangeOperation operation){
        if (operationMap.containsKey(operation.getOrder())){
         return true;
        }
        else {
            return false;
        }
    }

}
