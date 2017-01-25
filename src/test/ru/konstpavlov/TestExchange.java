import junit.framework.TestCase;
import main.ru.konstpavlov.exchangeUtils.Client;
import main.ru.konstpavlov.exchangeUtils.Exchange;
import main.ru.konstpavlov.utils.SecurityType;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestExchange extends TestCase{

    @Test
    public void testSellingAndBuyingQueue(){
        String clientsFilePath = "src\\test\\ru\\konstpavlov\\resourses\\clientsTest.txt";
        String ordersFilePath = "src\\test\\ru\\konstpavlov\\resourses\\ordersTest.txt";
        Exchange exchange = new Exchange(clientsFilePath,ordersFilePath);

        // on test data Sell list must be at 0 size
        Assert.assertEquals(0,exchange.getSellList().getOperationMap().size());

        // in buy queue must be 1 order
        Assert.assertEquals(1,exchange.getBuyList().getOperationMap().size());
    }

    @Test
    public void testClientList(){
        String clientsFilePath = "src\\test\\ru\\konstpavlov\\resourses\\clientsTest.txt";
        String ordersFilePath = "src\\test\\ru\\konstpavlov\\resourses\\ordersTest.txt";
        Exchange exchange = new Exchange(clientsFilePath,ordersFilePath);

        Map<String,Client> clientsCorrect= createCorrectClients();

        for (Map.Entry<String,Client> entry: exchange.getClients().entrySet()) {
            String clientName=entry.getKey();
            Assert.assertTrue(clientsCorrect.containsKey(clientName));
            Assert.assertEquals(clientsCorrect.get(clientName),entry.getValue());
        }
        // or
        //Assert.assertEquals(clientsCorrect,exchange.getClients());
    }

    private Map<String,Client> createCorrectClients(){
        // based on test data :
        Map<String,Client> clientsCorrect = new LinkedHashMap<>();
        // first client buy 2 type C cost 13
        Map<SecurityType,Integer> securites = new LinkedHashMap<>();
        securites.put(SecurityType.A,130);
        securites.put(SecurityType.B,240);
        securites.put(SecurityType.C,760 + 2 );
        securites.put(SecurityType.D,320);
        clientsCorrect.put("C1",new Client("C1",1000 - 26,securites));
        // Second client sell 2 type C cost 13
        Map<SecurityType,Integer> securites2 = new LinkedHashMap<>();
        securites2.put(SecurityType.A,370);
        securites2.put(SecurityType.B,120);
        securites2.put(SecurityType.C,950 - 2);
        securites2.put(SecurityType.D,560);
        clientsCorrect.put("C2",new Client("C2",4350  + 26 ,securites2));
        return clientsCorrect;
    }

    @Test
    public void testOutputFile(){
        String clientsFilePath = "src\\test\\ru\\konstpavlov\\resourses\\clientsTest.txt";
        String ordersFilePath = "src\\test\\ru\\konstpavlov\\resourses\\ordersTest.txt";
        String resultFilePath = "src\\test\\ru\\konstpavlov\\resourses\\resultTest.txt";
        Exchange exchange = new Exchange(clientsFilePath,ordersFilePath);
        exchange.showResults(resultFilePath);

        Map<String,Client> clientsCorrect= createCorrectClients();

        Map<String,Client> clientsOutput = new LinkedHashMap<>();

        try(BufferedReader bufferedFileReader = new BufferedReader(new FileReader(resultFilePath))) {

            String line;
            while ((line = bufferedFileReader.readLine()) != null) {
                String[] temp = line.split("\\t");
                int balance = Integer.parseInt(temp[1]);
                Map<SecurityType,Integer> securities = new LinkedHashMap<>();
                securities.put(SecurityType.A,Integer.parseInt(temp[2]));
                securities.put(SecurityType.B,Integer.parseInt(temp[3]));
                securities.put(SecurityType.C,Integer.parseInt(temp[4]));
                securities.put(SecurityType.D,Integer.parseInt(temp[5]));
                Client client = new Client(temp[0],balance,securities);
                clientsOutput.put(temp[0],client);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(clientsCorrect,clientsOutput);

    }
}
