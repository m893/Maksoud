package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PagesHandling {

    protected WebDriver driver ;
    WebDriverWait wait ;
    Select select ;
    Actions actions ;

    public PagesHandling(WebDriver driver)
    {
        this.driver=driver;
    }

    private WebElement getWebElement(By locator)
    {
        return driver.findElement(locator);
    }
    private void explicitWait(By locator , int time)
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(getWebElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)));
    }
    private void alertWait(int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    private void frameWait(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    protected void click(By locator , int time)
    {
        for(int i =0 ; i < 5 ; i++)
        {
            try {
                explicitWait(locator,time);
                getWebElement(locator).click();
                break;
            }catch(StaleElementReferenceException e){
                System.out.println("Can't find Element");
            }
        }
    }
    protected void sendkeys(By locator , int time,String text)
    {
        for(int i = 0 ; i<5 ; i++)
        {
            try {
                explicitWait(locator, time);
                getWebElement(locator).sendKeys(text);
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Can't find Element");
            }
        }
    }
    protected String getText(By locator,int time){
        String text = null;
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator,time);

                text= getWebElement(locator).getText();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Can't find Element");
            }
        }
        return text;
    }
    protected boolean isDisplayed(By locator,int time){
        boolean flag = false;
        for (int i =0;i<5;i++){
            try {
                explicitWait(locator,time);
                flag= getWebElement(locator).isDisplayed();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
        return flag;
    }
    protected void dragAndDrop(By src,By target,int time){
        for (int i=0;i<5;i++){
            try {
                explicitWait(src,time);
                explicitWait(target,time);
                actions = new Actions(driver);
                actions.dragAndDrop(getWebElement(src),getWebElement(target)).build().perform();
                break;
            }catch (StaleElementReferenceException e){

            }
        }
    }

    protected void uploadFile(By locator, String filePath) {
        try {
            WebElement element = getWebElement(locator);
            explicitWait(locator,10);
            if (element != null) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.display = 'block';", element);
                element.sendKeys(filePath);
                System.out.println("File uploaded successfully.");
            } else {
                System.out.println("Failed to locate the file input element.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while uploading the file: " + e.getMessage());
        }
    }


}
