package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Quest {

    WebDriver driver;

    @FindBy(id = "paste_code")
    protected   WebElement FieldText;

    @FindBy(id = "select2-paste_expire_date-06-container")
    protected   WebElement FieldSyntax;

    @FindBy(id = "select2-paste_expire_date-06-result-yqey-10M")
    protected   WebElement TimeTenMin;
    String URL= "https://pastebin.com";


    @BeforeMethod(alwaysRun = true)
    public void  BrowserSettings(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void NewTest(){

        driver.get(URL);
        FieldText.sendKeys("Hello from WebDriver");
        FieldSyntax.click();
        TimeTenMin.click();

    }

    @AfterMethod (alwaysRun = true)
    public void browserQuit () {
        driver.quit();
        driver = null;
    }
}
