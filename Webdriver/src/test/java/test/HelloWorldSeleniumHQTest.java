package test;

import PageObjectModel.page.TasteTwoPage;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloWorldSeleniumHQTest {

    private WebDriver driver;
    public String Code= "git config --global user.name  \\\"New Sheriff in Town\\\"\\n\" +\n" +
            "                \"git reset $(git commit-tree HEAD^{tree} -m \\\"Legacy code\\\")\\n\" +\n" +
            "                \"git push origin master --force";

    // Настройки, шаги выполняемые до исполнения теста
    @BeforeMethod(alwaysRun = true)
    public void browserSetUp (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
//Начало теста Тест

/*    @Test(description = "The first test, open vk.com and login in system. Тест где учился сам")
    public void SuperTest ()  {

// модель PageObject, вызов методов.
        boolean TestResult = new SeleniumPageVkLogin(driver)
                .openVklogin()
                .SendKeyData()
                .clickOnLogin()
                .PageVkHomeOpen();
//Тест на сравнение полученного результата в ходе выполнения цепочки PageObject
        Assert.assertTrue(TestResult, "Результат поиска не найден");

    }


    @Test(description = "Тест от Epam system. #1 РЕШЕНИЕ ВАРИАНТ 1 ")
    public void NewTestEpam() throws InterruptedException {

        driver.get("https://pastebin.com");
        WebElement FieldText = driver.findElement(By.xpath("//textarea[@id='paste_code']"));
        FieldText.sendKeys("Hello from WebDriver");
        WebElement FieldName =driver.findElement(By.xpath("//input[@name='paste_name']"));
        FieldName.sendKeys("helloweb");
        WebElement FieldSyntax = driver.findElement(By.xpath("//div[@class='form_frame_left']/div[2]//span[@class='select2-selection__arrow']"));
        FieldSyntax.click();
        WebElement TimeTenMin = driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']"));
        TimeTenMin.click();
        WebElement CreateButton = driver.findElement(By.xpath("//input[@id='submit']"));
        CreateButton.click();
        Thread.sleep(2000);
    }
*/
       @Test(description = "Тест от Epam system. #2 Решение ВАРИАНТ 2")

       public void NewTest () throws InterruptedException  {
           boolean NewTestResult =new TasteTwoPage(driver)
                   .openPage()
                   .FieldPaste()
                   .FieldSyntaxHighlighting()
                   .FieldPasteExpiration()
                   .FieldName()
                   .CreatePaste();

                   Assert.assertTrue(NewTestResult,"Проверка на наличие необходимых элементов(1)");
                   Assert.assertTrue(driver.getTitle().contains("[Bash] how to gain dominance among developers - Pastebin.com"));
                   Assert.assertTrue(driver.findElement(By.id("paste_code")).getText().contains("git config --global user.name  \"New Sheriff in Town\"\n" +
                           "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                           "git push origin master --force"));
       }

    // Метод вызываемый после исполнения кода выше (результат исполнения не имеет значения )
    @AfterMethod (alwaysRun = true)
    public void browserQuit (){
        driver.quit();
        driver =null;
    }
}
