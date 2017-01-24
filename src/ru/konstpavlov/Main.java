package ru.konstpavlov;

import ru.konstpavlov.exchangeUtils.Exchange;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        String clientsFilePath = "src\\ru\\konstpavlov\\resourses\\clients.txt";
        String ordersFilePath = "src\\ru\\konstpavlov\\resourses\\orders.txt";
        Exchange exchange = new Exchange(clientsFilePath,ordersFilePath);
        exchange.calculate();
    }
}
