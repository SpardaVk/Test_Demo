package PageObjectModel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TasteTwoPage {

    private WebDriver driver;
    private static final String START_PAGE= "https://pastebin.com ";
    private String Code= "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @FindBy (xpath = "//textarea[@id='paste_code']")
    WebElement FieldPaste;

    @FindBy (xpath = "//input[@name='paste_name']")
    WebElement FieldName;

    @FindBy (xpath = "//*[@id=\"myform\"]/div[3]/div[1]/div[2]/span/span[1]/span")
    WebElement FieldSyntax;

    @FindBy (xpath = "//span[@class='select2-results']//li[text()='Bash']")
    WebElement FieldSyntaxBash;

    @FindBy (css = "span[title='Never']")
    WebElement FieldExpiration;

    @FindBy (xpath = "//li[.='10 Minutes']")
    WebElement FieldExpirationTime;

    @FindBy (xpath = "//input[@id='submit']")
    WebElement CreateButton;



     public TasteTwoPage(WebDriver driver){
     this.driver =driver;
     PageFactory.initElements(driver,this);
 }
     public TasteTwoPage openPage (){
     driver.get(START_PAGE);

     return this;
     }

    public TasteTwoPage FieldPaste () throws InterruptedException {
        FieldPaste.click();
        FieldPaste.clear();
        FieldPaste.sendKeys(Code);
       // FieldPaste.getText();


        return this;
    }

     public TasteTwoPage FieldSyntaxHighlighting () throws InterruptedException {
         FieldSyntax.click();
         FieldSyntaxBash.click();
         return  this;
     }

     public TasteTwoPage FieldPasteExpiration () throws InterruptedException {
         FieldExpiration.click();
         FieldExpirationTime.click();
         return this;
     }

     public TasteTwoPage FieldName (){
         FieldName.click();
         FieldName.clear();
         FieldName.sendKeys( "how to gain dominance among developers");
         return this;
     }

     public boolean CreatePaste() throws InterruptedException {
         CreateButton.click();

         /*
         String result =driver.findElements(By.xpath("//textarea[@id='paste_code']"));

         if(result.equalsIgnoreCase(FieldPaste))
         {
             System.out.println("String is same");
         }
         else{
             System.out.println("String is not same");
         }
                   */
        //return FieldPaste ==
         return driver.findElements(By.xpath("//a[.='Bash']")).size() >0;
     }
}
