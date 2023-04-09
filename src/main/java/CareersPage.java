import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CareersPage extends BrowserDriver {
    WebDriver driver;


        //Teams block
        By teamsLocator =
                By.id("career-find-our-calling");


        // Locations block
        By locationBlocklocator1 = By.id("career-our-location");


        // Life at Insider Block
        By lifeAtInsiderLocator = By.cssSelector(".e-swiper-container");

        // Button Locator
        By seeAllTeamsBtn= By.xpath("//a[text()=\"See all teams\"]");
        By sales = By.xpath("//h3[.='Sales']");
        By QACareerPageLocator = By.cssSelector("[src='https://useinsider.com/assets/media/2021/03/qa.png']");

    public CareersPage( WebDriver driver){

        this.driver=driver;
    }

        public WebElement getQACareerPageLocator (){
        return driver.findElement(QACareerPageLocator);
        }
        public WebElement getteamsLocator(){

            return driver.findElement(teamsLocator);
        }

        public WebElement getlocationBlocklocator1 (){

            return driver.findElement(locationBlocklocator1);
        }

        public WebElement getlifeAtInsiderLocator(){
            return driver.findElement(lifeAtInsiderLocator);
        }

        public String CareerPageUrl = "https://useinsider.com/careers/";

        public WebElement getseeAllTeamsBtn(){
        return driver.findElement(seeAllTeamsBtn);
        }

        public WebElement getSales(){
        return driver.findElement(sales);
        }

}
