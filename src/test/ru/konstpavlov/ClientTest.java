import junit.framework.TestCase;
import main.ru.konstpavlov.exchangeUtils.Client;
import main.ru.konstpavlov.utils.SecurityType;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClientTest extends TestCase {

    @Test
    public void testEquals(){

        Map<SecurityType,Integer> securites = new LinkedHashMap<>();
        securites.put(SecurityType.A,130);
        securites.put(SecurityType.B,240);
        securites.put(SecurityType.C,760);
        securites.put(SecurityType.D,320);

        Map<SecurityType,Integer> securites2 = new LinkedHashMap<>();
        securites2.put(SecurityType.A,130);
        securites2.put(SecurityType.B,240);
        securites2.put(SecurityType.C,760);
        securites2.put(SecurityType.D,320);

        Client client1 = new Client("TestC1",1000,securites);
        Client client2 = new Client("TestC1",1000,securites);
        Client client3 = new Client("TestC1",1500,securites);
        Client client4 = new Client("TestC2",1200,securites);
        Client client5 = new Client("TestC2",1200,securites2);

        Assert.assertTrue(client1.equals(client2));
        Assert.assertTrue(client2.equals(client1));

        Assert.assertFalse(client1.equals(client3));
        Assert.assertFalse(client3.equals(client1));

        Assert.assertTrue(client4.equals(client5));
        Assert.assertTrue(client5.equals(client4));
    }


    @Test
    public void testHashCode(){

        Map<SecurityType,Integer> securites = new LinkedHashMap<>();
        securites.put(SecurityType.A,130);
        securites.put(SecurityType.B,240);
        securites.put(SecurityType.C,760);
        securites.put(SecurityType.D,320);

        Client client1 = new Client("TestC1",1000,securites);
        Client client2 = new Client("TestC1",1000,securites);
        Client client3 = new Client("TestC1",1500,securites);

        Assert.assertEquals(client1.hashCode(),client2.hashCode());
        Assert.assertNotEquals(client3.hashCode(),client1.hashCode());
        Assert.assertNotEquals(client3.hashCode(),client2.hashCode());
    }

}
