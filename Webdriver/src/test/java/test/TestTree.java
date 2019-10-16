package test;

import PageObjectModel.page.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTree {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test(description = "Тест от Epam system. #3 Решение ВАРИАНТ 1")
    public void TestTree () throws InterruptedException {

        new TestTreePage(driver)
                .openPage()
                .ClikToSearch()
                .ClickToALLRESULTButton()
                .ClickToFirstSearchResult()
                .FieldNumberInstances()
                .FieldMachineFamily()
                .CheckBoxAddGPUs()
                .FieldNumberOfGPUs()
                .FieldGPUsType()
                .FieldLocalSSD()
                .FieldDataCenterLocations()
                .FieldCommittedUsage()
                .ClickToAddToEstimateButton();

        WebElement iframe = driver.findElement(By.cssSelector("[src*='https://cloudpricingcalculator.appspot.com']"));
        Assert.assertTrue(driver.switchTo().frame(iframe).findElement(By.xpath("//md-list-item[contains(.,'VM class: regular')]")).getText().contains("VM class: regular"));
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.switchTo().frame(iframe).findElement(By.xpath("//md-list-item[contains(.,'Instance type: n1-standard-8')]")).getText().contains("Instance type: n1-standard-8"));
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.switchTo().frame(iframe).findElement(By.xpath("//md-list-item[contains(.,'Region: Frankfurt')]")).getText().contains("Region: Frankfurt"));
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.switchTo().frame(iframe).findElement(By.xpath("//md-list-item[contains(.,'Total available local SSD space 2x375 GB')]")).getText().contains("Total available local SSD space 2x375 GB"));
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.switchTo().frame(iframe).findElement(By.xpath("//md-list-item[contains(.,'Commitment term: 1 Year')]")).getText().contains("Commitment term: 1 Year"));

        //Последний уровень сложности

       String email = new MailPage(driver)
               .NewPageEmail()
               .SaveEmail();

        new GoogleCalculator(driver)
                .EmailEstimateButtonClick()
                .FieldEmail(email)
                .SendEmailButton();

        new MailPage(driver)
                .SwitchToMailPage()
                .OpenCharacter();

        new WebDriverWait(driver,100).until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='quote']//tr[2]/td[.='USD 1,082.77']")));

        Assert.assertTrue(driver.findElement(By.xpath("//table[@class='quote']//tr[2]/td[.='USD 1,082.77']")).getText().contains("USD 1,082.77"));

    }
        @AfterMethod(alwaysRun = true)
        public void browserQuit () {
            driver.quit();
            driver = null;
        }

    }

