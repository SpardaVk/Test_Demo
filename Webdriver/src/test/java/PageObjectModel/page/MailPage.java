package PageObjectModel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MailPage {

    private WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  MailPage NewPageEmail() {

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com/10MinuteMail/index.html");
        return this;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String SaveEmail(){

        String mailAddress = driver.findElement(By.xpath("//input[@id='mailAddress']")).getAttribute("value");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        return mailAddress;
    }
    public MailPage SwitchToMailPage(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
     public MailPage OpenCharacter () throws InterruptedException {

         JavascriptExecutor jsx = (JavascriptExecutor)driver;
         jsx.executeScript("window.scrollBy(0,460)", "");

         new WebDriverWait(driver,100).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='messagesList']")));
         new WebDriverWait(driver,100).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='messagesList']")));

         driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]")).click();

        return this;
     }

}
