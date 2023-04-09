import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class homePageTest extends BrowserDriver  {
    private String expectedGetPlatformText;
    private String actualGetPlatformText;

    @BeforeTest
    public void setUp() throws InterruptedException, IOException  {

        driver = getDriver();
        driver.get(getUrl());

    }
    @AfterTest
    public void quitBrowser()  {

        driver.quit();

    }
    @Test
    public void openHomePageTest() throws InterruptedException, IOException {

        System.out.println("we are on Home Page now and Url is  "+driver.getCurrentUrl());
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,getUrl());
        Assert.assertTrue(URL.contains(getUrl()));

        HomePage homePage = new HomePage(driver);
        homePage.getAcceptButton().click();
        homePage.getonePlatform().isDisplayed();

        expectedGetPlatformText = "One platform for individualized, cross-channel customer experiences";
        actualGetPlatformText = homePage.getonePlatform().getText();
        Assert.assertEquals(actualGetPlatformText,expectedGetPlatformText);

        homePage.getMoreMenu().click();
        homePage.getcareersFeature().click();

        System.out.println("------Home Page Test is passed------");
    }
    @Test (dependsOnMethods = "openHomePageTest")
    public void careerPageTest() throws InterruptedException, IOException {
        CareersPage careersPage = new CareersPage(driver);
        System.out.println("we are on career page now and Url is "+driver.getCurrentUrl());
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,careersPage.CareerPageUrl);
        Assert.assertEquals(URL,careersPage.CareerPageUrl);
        Assert.assertTrue(URL.contains(careersPage.CareerPageUrl));

        // BLock team
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", careersPage.getteamsLocator());
        careersPage.getteamsLocator().isDisplayed();
        Thread.sleep(2000);
        if ( careersPage.getteamsLocator().isDisplayed() == true){
            System.out.println("We are on Teams Block ");
        }else if ( careersPage.getteamsLocator().isDisplayed() == false) {
            System.out.println("There is smth wrong with Teams Block");
        }
        Assert.assertTrue(careersPage.getteamsLocator().isDisplayed());

        js.executeScript("arguments[0].scrollIntoView();", careersPage.getlocationBlocklocator1());
        careersPage.getlocationBlocklocator1().isDisplayed();
        if ( careersPage.getlocationBlocklocator1().isDisplayed() == true){
            System.out.println("We are on Our location Block ");
        }else if ( careersPage.getlocationBlocklocator1().isDisplayed() == false) {
            System.out.println("There is smth wrong with location Block");
        }
        Assert.assertTrue(careersPage.getlocationBlocklocator1().isDisplayed());

        js.executeScript("arguments[0].scrollIntoView();", careersPage.getlifeAtInsiderLocator());
        careersPage.getlifeAtInsiderLocator().isDisplayed();
        if ( careersPage.getlifeAtInsiderLocator().isDisplayed() == true){
            System.out.println("We are on life at Insider Block ");
        }else if ( careersPage.getlifeAtInsiderLocator().isDisplayed() == false) {
            System.out.println("There is smth wrong with life at Insider Block");
        }
        Assert.assertTrue(careersPage.getlifeAtInsiderLocator().isDisplayed());

        js.executeScript("arguments[0].scrollIntoView();", careersPage.getSales());
        Thread.sleep(1000);
        System.out.println(careersPage.getseeAllTeamsBtn().getText() + " button is shown on page" );
        careersPage.getseeAllTeamsBtn().click();
        js.executeScript("arguments[0].scrollIntoView();", careersPage.getQACareerPageLocator());
        Thread.sleep(1000);
        careersPage.getQACareerPageLocator().click();
        System.out.println("------Career Page Test is passed------");
    }
    @Test(dependsOnMethods = "careerPageTest")
    public void QualityAssurancePageTest() throws InterruptedException, IOException {

        QApage qApage = new QApage(driver);
        System.out.println("we are on QA page now and Url is "+driver.getCurrentUrl());
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,qApage.QAPageUrl);
        Assert.assertEquals(URL,qApage.QAPageUrl);
        Assert.assertTrue(URL.contains(qApage.QAPageUrl));

        Assert.assertEquals(qApage.getAQAExpText().getText(),qApage.expextedQAExplanationText);
        qApage.getSeeAllQajobsBtn().click();
        System.out.println("------QualityAssurance Page Test is passed------");

    }

    @Test(dependsOnMethods = "QualityAssurancePageTest")
    public void JobsPositionFilterPageTest() throws InterruptedException, IOException {

        JobsPositionFilterPage jobsPositionFilterPage = new JobsPositionFilterPage(driver);
        System.out.println("we are on JobsPositionFilterPage now and Url is "+driver.getCurrentUrl());
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,jobsPositionFilterPage.JobsPositionFilterPageUrl);
        Assert.assertEquals(URL,jobsPositionFilterPage.JobsPositionFilterPageUrl);
        Assert.assertTrue(URL.contains(jobsPositionFilterPage.JobsPositionFilterPageUrl));

        Actions choosing = new Actions(driver);
        choosing.moveToElement(jobsPositionFilterPage.getLocationDropDown());
        choosing.perform();
        jobsPositionFilterPage.getLocationDropDown().click();
        Thread.sleep(1000);
        jobsPositionFilterPage.getLocationDropDown().findElement(jobsPositionFilterPage.istanbulForLocation).click();

        choosing.moveToElement(jobsPositionFilterPage.getDepartmentDropDown());
        choosing.perform();
        jobsPositionFilterPage.getDepartmentDropDown().click();
        Thread.sleep(1000);
        jobsPositionFilterPage.getDepartmentDropDown().findElement(jobsPositionFilterPage.DepartmentDropDown).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", jobsPositionFilterPage.getJobList());
        if (jobsPositionFilterPage.getJobList().isDisplayed() == true){
            System.out.println("Job List is opened!");
        } else if (jobsPositionFilterPage.getJobList().isDisplayed() !=  true) {
            System.out.println("Job List is not listed!");
        }
        Assert.assertTrue(jobsPositionFilterPage.getJobList().isDisplayed());

        Thread.sleep(1000);
        System.out.println("The number of result for this filter is " + jobsPositionFilterPage.getNumberOfResult().getText());
        js.executeScript("arguments[0].scrollIntoView();", jobsPositionFilterPage.getNumberOfResult());
        Thread.sleep(1000);

        List<WebElement> listOfPositionName = driver.findElements(jobsPositionFilterPage.positionName);

        for ( int i = 0 ; listOfPositionName.size() > i; i++){

            System.out.println("Quality Assurance is checked in the position name ");
            Assert.assertTrue((listOfPositionName.get(i)).getText().contains("Quality Assurance"));

        }

        List<WebElement> listOfDepartmentName = driver.findElements(jobsPositionFilterPage.departmentName);

        for ( int i = 0 ;  listOfDepartmentName.size() >i; i++){

            System.out.println("Quality Assurance is checked in the Department name ");
            Assert.assertTrue((listOfDepartmentName.get(i)).getText().contains("Quality Assurance"));

        }

        List<WebElement> listOflocationName = driver.findElements(jobsPositionFilterPage.locationName);

        for ( int i = 0 ; listOflocationName.size() > i; i++){

            System.out.println("Istanbul, Turkey is checked in the Location name ");
            Assert.assertTrue((listOflocationName.get(i)).getText().contains("Istanbul, Turkey"));
        }


        List<WebElement> listOfapplyBtn = driver.findElements(jobsPositionFilterPage.applyBtn);

        for ( int i = 0 ; listOfapplyBtn.size() > i; i++){

            System.out.println("Apply Button is checked on the page ");
            //checking Apply button is there
            Assert.assertTrue((listOfapplyBtn.get(i)).isEnabled());
        }
        System.out.println("------Job Filters Page Test is passed------");
    }
    @Test(dependsOnMethods = "JobsPositionFilterPageTest")
    public void LeverAppPageTest ()  throws InterruptedException, IOException {

        JobsPositionFilterPage jobsPositionFilterPageLeverAppCheck = new JobsPositionFilterPage(driver);
        jobsPositionFilterPageLeverAppCheck.getAppBtn().click();

        JobsLeverPage jobsLeverPage = new JobsLeverPage(driver);
        //get window handlers as list
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        //switch to lever job browser tab
        driver.switchTo().window(browserTabs .get(1));
        String URL = driver.getCurrentUrl();
        System.out.println("we are on JobsPositionFilterPage now and Url is "+URL);
        driver.switchTo().window(browserTabs.get(0));
        Assert.assertTrue(URL.contains(jobsLeverPage.JobsLeverPageUrl));
        System.out.println("------Lever Job Page Test is passed------");
    }
}
