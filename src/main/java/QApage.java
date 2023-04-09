import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QApage extends BrowserDriver{

    WebDriver driver;
    public String QAPageUrl = "https://useinsider.com/careers/quality-assurance/";
    public QApage( WebDriver driver){

        this.driver=driver;
    }
    public String expextedQAExplanationText =
            "Never miss a thing? Obsess over every little detail? Our Q&A team is committed to testing everything we build to ensure it’s flawless for our customers (and theirs).";
    By actualQAExplanationText = By.cssSelector(".pl-2");
    public WebElement getAQAExpText (){
        return driver.findElement(actualQAExplanationText);
    }
    By seeAllQajobsBtn = By.cssSelector(".btn-outline-secondary");
    public WebElement getSeeAllQajobsBtn (){
        return driver.findElement(seeAllQajobsBtn);
    }

}
