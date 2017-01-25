import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@Suite.SuiteClasses({TestClient.class, TestExchange.class, TestOperationList.class, TestOrder.class})
@RunWith(Suite.class)
public class TestMain extends TestCase{

}
