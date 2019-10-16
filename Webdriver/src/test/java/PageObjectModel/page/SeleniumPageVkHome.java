package PageObjectModel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPageVkHome   {

    private  WebDriver driver;

    //Присвоение переменной к xpath(Создание обьектов). Работает совместно с конструктором PageFactory
    @FindBy (xpath = "//span[.='Сообщения']")
    private WebElement SendButton;

//Конструктор PageFactory
    public SeleniumPageVkHome (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

//Проверка на наличие элемената - строка "Сообшения"
    public boolean PageVkHomeOpen (){
        new WebDriverWait( driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[.='Сообщения']")));
        //Сравнение на наличие элемента > 0 , вернет true или false
        return driver.findElements(By.xpath("//span[.='Сообщения']")).size() > 0;
    }

    /*public SeleniumPageVkHome
    WebElement SendButton = driver.findElement(By.xpath("//span[.='Сообщения']"));
        SendButton.click();

        new WebDriverWait( driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id='im_dialogs_search']")));

    WebElement Search = driver.findElement(By.xpath("//input[@id='im_dialogs_search']"));
        Search.sendKeys("5-ка баклажан");


    WebElement SearchResult = driver.findElement(By.xpath("//span[@class='_im_dialog_link']"));
        Search.click();
*/}
