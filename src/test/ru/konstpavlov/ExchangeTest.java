import junit.framework.TestCase;
import main.ru.konstpavlov.exchangeUtils.Client;
import main.ru.konstpavlov.exchangeUtils.Exchange;
import main.ru.konstpavlov.utils.SecurityType;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExchangeTest extends TestCase {

    @Test
    public void testSellingAndBuying(){
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

        // base on test data :
        Map<String,Client> clientsCorrect = new LinkedHashMap<>();
        // first client
        Map<SecurityType,Integer> securites = new LinkedHashMap<>();
        securites.put(SecurityType.A,130);
        securites.put(SecurityType.B,240);
        securites.put(SecurityType.C,760);
        securites.put(SecurityType.D,320);
        clientsCorrect.put("C1",new Client("C1",1000,securites));
        // Second client
        Map<SecurityType,Integer> securites2 = new LinkedHashMap<>();
        securites2.put(SecurityType.A,370);
        securites2.put(SecurityType.B,120);
        securites2.put(SecurityType.C,950);
        securites2.put(SecurityType.D,560);
        clientsCorrect.put("C2",new Client("C2",4350,securites2));

        for (Map.Entry<String,Client> entry: exchange.getClients().entrySet()) {
            String clientName=entry.getKey();
            Assert.assertTrue(clientsCorrect.containsKey(clientName));
            Assert.assertEquals(clientsCorrect.get(clientName),entry.getValue());
        }
    }

}
