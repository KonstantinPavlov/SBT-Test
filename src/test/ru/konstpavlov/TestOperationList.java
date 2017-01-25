import junit.framework.TestCase;
import main.ru.konstpavlov.exchangeUtils.Order;
import main.ru.konstpavlov.exchangeUtils.OperationList;
import main.ru.konstpavlov.operations.ExchangeOperation;
import main.ru.konstpavlov.operations.SellOperation;
import main.ru.konstpavlov.utils.SecurityType;
import org.junit.Assert;
import org.junit.Test;

public class TestOperationList extends TestCase {

    @Test
    public void testAddingToOperationList(){
        // adding to queue
        OperationList operationList = new OperationList();
        ExchangeOperation operation = new SellOperation("TestClient", new Order(SecurityType.A,5,10));
        operationList.addOperation(operation);
        Assert.assertFalse(operationList.getOperationMap().isEmpty());
    }
    @Test
    public void testAddingToOperationListInOneQueue(){
        // add 2 elements in queue
        OperationList operationList = new OperationList();
        ExchangeOperation operation = new SellOperation("TestClient1", new Order(SecurityType.A,5,10));
        ExchangeOperation operation2 = new SellOperation("TestClient2", new Order(SecurityType.A,5,10));
        operationList.addOperation(operation);
        operationList.addOperation(operation2);
        Assert.assertFalse(operationList.getOperationMap().isEmpty());

        Assert.assertEquals(2,operationList.getOperationMap().get(operation.getOrder()).size());
    }
}
