package main.ru.konstpavlov.exchangeUtils;

import main.ru.konstpavlov.operations.ExchangeOperation;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OperationList {

    private Map<Order,Queue<ExchangeOperation>> operationMap= new LinkedHashMap<>();

    public void addOperation(ExchangeOperation operation){
        // check for operation in map
        if (operationMap.containsKey(operation.getOrder())){
            this.operationMap.get(operation.getOrder()).add(operation);
        }
        else {
            Queue<ExchangeOperation> queue = new LinkedList<>();
            queue.add(operation);
            this.operationMap.put(operation.getOrder(),queue);
        }
    }

    public ExchangeOperation pollOperation(ExchangeOperation operation){
        // take operation from queue
        ExchangeOperation oper =  operationMap.get(operation.getOrder()).poll();
        // if queue is empty - delete operation from operationMap
        if (operationMap.get(operation.getOrder()).size() == 0){
            operationMap.remove(operation.getOrder());
        }
        return oper;
    }

    // Method for check existence of operation in operationMap
    public boolean checkOperation(ExchangeOperation operation){
        if (operationMap.containsKey(operation.getOrder())){
         return true;
        }
        else {
            return false;
        }
    }

    public Map<Order, Queue<ExchangeOperation>> getOperationMap() {
        return operationMap;
    }
}
