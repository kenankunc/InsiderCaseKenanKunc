import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePage {

     WebDriver driver;
     By onePlatform = By.xpath("//div[@class='d-flex flex-column align-items-center justify-content-center text-center']/h1[contains(.,'One platform for individualized, cross-channel customer experiences')]");
     By moreMenu = By.xpath("//span[.='More']");
     By AcceptButton = By.id("wt-cli-accept-all-btn");
     By careersFeature = By.xpath("//h5[.='Careers']");
     public HomePage( WebDriver driver){

          this.driver=driver;
     }
     public WebElement getcareersFeature(){
          return driver.findElement(careersFeature);
     }

     public WebElement getMoreMenu(){
          return driver.findElement(moreMenu);
     }

     public WebElement getonePlatform(){
          return driver.findElement((onePlatform));
     }

     public WebElement getAcceptButton(){
          return driver.findElement((AcceptButton));
     }


}