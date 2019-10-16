package PageObjectModel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestTreePage extends Throwable {

    private WebDriver driver;
    private static final String START_PAGE = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    WebElement FieldSearch;

    @FindBy(css = ".devsite-suggest-all-results")
    WebElement ResultButton;


    @FindBy(xpath = ("//div[@class='gsc-expansionArea']//div[@class='gsc-thumbnail-inside']//a[@href='https://cloud.google.com/products/calculator/']/b[.='Google Cloud Platform Pricing Calculator']"))
    WebElement SearchResult;

    @FindBy (xpath = "")
    WebElement SerTest;


    public TestTreePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TestTreePage openPage() {
        driver.get(START_PAGE);

        return this;
    }

    public TestTreePage ClikToSearch() throws InterruptedException {

        FieldSearch.click();
        FieldSearch.clear();
        FieldSearch.sendKeys("Google Cloud Platform Pricing Calculator");

        return this;
    }

    public TestTreePage ClickToALLRESULTButton() {

        ResultButton.click();

        return this;
    }

    public GoogleCalculator ClickToFirstSearchResult() throws InterruptedException {

        SearchResult.click();

        return new GoogleCalculator(driver);
    }


}
