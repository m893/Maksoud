import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.StockLoginPage;
import utils.BrowserFactory;

public class StockTests {
    WebDriver driver ;
    StockLoginPage stockLoginPage ;
    @BeforeClass
    public void setup()
    {
        driver= BrowserFactory.getDriver();
        stockLoginPage = new StockLoginPage(driver);
    }
    @Test
    public void loginTest()
    {
        driver.get("http://10.22.1.123:7001/StockManagement/login.jsf");
        stockLoginPage.enterUserName();
        stockLoginPage.enterPassword();
        stockLoginPage.login();
    }
}
