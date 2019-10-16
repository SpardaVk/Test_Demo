package PageObjectModel.page;

import org.openqa.selenium.By;
import PageObjectModel.page.MailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class GoogleCalculator {

    private WebDriver driver;

    //new WebDriverWait(driver,10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

    @FindBy(xpath = "//iframe//input[@class='ng-pristine md-input ng-empty ng-valid-min ng-invalid ng-invalid-required ng-touched']")
    WebElement Block;

    @FindBy (xpath ="//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement FieldNumber;



    public GoogleCalculator (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleCalculator FieldMachineFamily () throws InterruptedException {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.instance']"))));

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.instance']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//md-option[contains(.,'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")).click();
        driver.switchTo().defaultContent();

        return this;
    }

    public GoogleCalculator CheckBoxAddGPUs (){

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.addGPUs']")).click();
        driver.switchTo().defaultContent();
        return this;
    }

    public GoogleCalculator FieldNumberOfGPUs () throws InterruptedException {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.gpuCount']")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe).findElement(By.xpath("//*[@id=\"select_option_353\"]")).click();
        driver.switchTo().defaultContent();

        return this;
    }
    public GoogleCalculator FieldGPUsType () throws InterruptedException {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.gpuType']")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe).findElement(By.xpath("//*[@id=\"select_option_360\"]")).click();
        driver.switchTo().defaultContent();

        return  this;
    }

    public GoogleCalculator FieldLocalSSD () throws InterruptedException {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.ssd']")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe).findElement(By.xpath("//md-option[contains(.,'2x375 GB')]")).click();
        driver.switchTo().defaultContent();

        return this;
    }
    public GoogleCalculator FieldDataCenterLocations () throws InterruptedException {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.location']")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe).findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option[contains(.,'Frankfurt (europe-west3)')]")).click();
        driver.switchTo().defaultContent();

        return this;
    }
    public GoogleCalculator FieldCommittedUsage () throws InterruptedException {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.cud']")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe).findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option[.='1 Year']")).click();
        driver.switchTo().defaultContent();

        return this;
    }
    public GoogleCalculator ClickToAddToEstimateButton (){

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        driver.switchTo().frame(iframe).findElement(By.xpath("//*[@id=\"mainForm\"]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[13]/button")).click();
        driver.switchTo().defaultContent();

        return this;
    }

    public GoogleCalculator FieldNumberInstances ()  {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.quantity']"))));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-model='listingCtrl.computeServer.quantity']")).sendKeys("4");
        driver.switchTo().defaultContent();

        return this;
    }
    public GoogleCalculator EmailEstimateButtonClick () throws InterruptedException {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        Thread.sleep(2000);
        driver.switchTo().frame(iframe).findElement(By.xpath("//button[@id='email_quote']")).click();
        driver.switchTo().defaultContent();

        return this;
    }

    public GoogleCalculator FieldEmail (String email) throws InterruptedException {

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        Thread.sleep(2000);
        driver.switchTo().frame(iframe).findElement(By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required ng-valid-email']")).sendKeys(email);
        driver.switchTo().defaultContent();

        return this;
    }

    public GoogleCalculator SendEmailButton (){

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));

        driver.switchTo().frame(iframe).findElement(By.cssSelector("[ng-disabled='emailForm.$invalid']")).click();
        driver.switchTo().defaultContent();

      return  this;
    }
}
