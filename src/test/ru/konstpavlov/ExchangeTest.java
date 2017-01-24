import junit.framework.TestCase;
import main.ru.konstpavlov.exchangeUtils.Exchange;
import org.junit.Assert;
import org.junit.Test;

public class ExchangeTest extends TestCase {

    @Test
    public void testSellingAndBuying(){
        String clientsFilePath = "src\\test\\ru\\konstpavlov\\resourses\\clientsTest.txt";
        String ordersFilePath = "src\\test\\ru\\konstpavlov\\resourses\\ordersTest.txt";
        Exchange exchange = new Exchange(clientsFilePath,ordersFilePath);

        // на тестовых данных очередь по продажам должна быть нулевой
        Assert.assertEquals(0,exchange.getSellList().getOperationMap().size());

        // в очереди по покупке должна остаться 1 запись
        Assert.assertEquals(1,exchange.getBuyList().getOperationMap().size());


    }

}
