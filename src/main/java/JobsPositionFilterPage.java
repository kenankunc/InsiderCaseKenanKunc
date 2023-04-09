import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobsPositionFilterPage {

    WebDriver driver;
    public String JobsPositionFilterPageUrl = "https://useinsider.com/careers/open-positions/?department=qualityassurance";
    public JobsPositionFilterPage( WebDriver driver){
        this.driver=driver;
    }
    By LocationDropDown = By.xpath("(//span[@role='combobox'])[1]");
    public WebElement getLocationDropDown (){
        return driver.findElement(LocationDropDown);
    }

    By istanbulForLocation = By.xpath("//li[text()='Istanbul, Turkey']");
    public WebElement getIstanbulForLocation(){
        return driver.findElement(istanbulForLocation);
    }
    By DepartmentDropDown = By.xpath("(//span[@role='combobox'])[2]");
    public WebElement getDepartmentDropDown(){
        return driver.findElement(DepartmentDropDown);
    }
    By jobList = By.id("jobs-list");

   public WebElement getJobList (){
       return driver.findElement(jobList);
   }
   By numberOfResult = By.id("resultCounter");

   public WebElement getNumberOfResult (){
       return driver.findElement(numberOfResult);
   }
   By positionName = By.cssSelector("p[class='position-title font-weight-bold']");
   public WebElement getPositionName (){
       return driver.findElement(positionName);
   }
   By departmentName = By.cssSelector("span[class='position-department text-large font-weight-600 text-primary']");

    public WebElement getDepartmentName (){
        return driver.findElement(departmentName);
    }
    By locationName = By.cssSelector("div[class='position-location text-large']");
    public WebElement getLocationName(){

        return driver.findElement(locationName);
    }
    By applyBtn = By.cssSelector("a[class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5']");
    public WebElement getAppBtn(){
        return driver.findElement(applyBtn);
    }

}
