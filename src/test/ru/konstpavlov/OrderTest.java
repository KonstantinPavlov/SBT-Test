import junit.framework.TestCase;
import main.ru.konstpavlov.exchangeUtils.Order;
import main.ru.konstpavlov.utils.SecurityType;
import org.junit.Assert;
import org.junit.Test;

public class OrderTest extends TestCase {

    @Test
    public void testEquals(){
        Order order1= new Order(SecurityType.A,5,15);
        Order order2= new Order(SecurityType.A,5,15);
        Order order3= new Order(SecurityType.B,5,15);

        Assert.assertTrue(order1.equals(order2));
        Assert.assertTrue(order2.equals(order1));

        Assert.assertFalse(order1.equals(order3));
        Assert.assertFalse(order3.equals(order1));

        Assert.assertFalse(order2.equals(order3));
        Assert.assertFalse(order3.equals(order2));
    }

    @Test
    public void testHashCode(){
        Order order1= new Order(SecurityType.A,5,15);
        Order order2= new Order(SecurityType.A,5,15);
        Order order3= new Order(SecurityType.B,5,15);

        Assert.assertEquals(order1.hashCode(),order2.hashCode());
        Assert.assertNotEquals(order3.hashCode(),order1.hashCode());
        Assert.assertNotEquals(order3.hashCode(),order2.hashCode());
    }
}
