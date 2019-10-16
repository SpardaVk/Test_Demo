package PageObjectModel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPageVkLogin  {

    private WebDriver driver;
    private static final String HOME_PAGE= "http://vk.com";

    //Поииск и присвоение элементов страницы к переменным(Создание обьектов). Работает совместно с конструктором PageFactory
    @FindBy(id ="index_email")
    private WebElement  NumberField;

    @FindBy (id = "index_pass")
    private  WebElement PasswordField;

    @FindBy (id = "index_login_button")
    private  WebElement NextButton;

  //  private  final  By NextButton = By.id("index_login_button");

//Конструктор PageFactory

    public SeleniumPageVkLogin (WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

  // Метод который вызывает библиотеку driver(selenium) и передает url для перехода
    public SeleniumPageVkLogin openVklogin (){
        driver.get(HOME_PAGE);

        return this;
    }

    //заполнение полей на странице
    public SeleniumPageVkLogin SendKeyData (){


        NumberField.sendKeys("+375259696059");
        PasswordField.sendKeys("jshih7712");

        return this;
    }
//клик по кнопке
    public SeleniumPageVkHome clickOnLogin (){

        NextButton.click();
//вернет нам страницу home(позволяет вызывать методы со страницы home)

        return  new SeleniumPageVkHome(driver);
    }
}
