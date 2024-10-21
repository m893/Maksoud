package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PagesHandling;

public class StockLoginPage extends PagesHandling {
    public StockLoginPage(WebDriver driver)
    {
        super(driver);
    }
    final private By userNameField = By.id("username");//locators
    final private By passwordField = By.name("password");
    final private By loginBtn = By.id("j_idt16");

    public void enterUserName()
    {
        sendkeys(userNameField,5,"BC1588");

    }

    public void enterPassword()
    {
        sendkeys(passwordField,5,"123456");
    }
    public void login()
    {
        click(loginBtn,5);

    }


}
