package main.ru.konstpavlov;

import main.ru.konstpavlov.exchangeUtils.Exchange;

public class Main {

    public static void main(String[] args) {

        String clientsFilePath = "src\\main\\ru\\konstpavlov\\resourses\\clients.txt";
        String ordersFilePath = "src\\main\\ru\\konstpavlov\\resourses\\orders.txt";
        String resultFilePath = "src\\main\\ru\\konstpavlov\\resourses\\result.txt";

        Exchange exchange = new Exchange(clientsFilePath,ordersFilePath);
        exchange.showResults(resultFilePath);
    }
}
