import org.openqa.selenium.WebDriver;

public class JobsLeverPage extends BrowserDriver{
    WebDriver driver;
    public String JobsLeverPageUrl = "https://jobs.lever.co/useinsider/0ba4065b-955a-4661-ad4a-f32479f63757";
    public JobsLeverPage( WebDriver driver){
        this.driver=driver;
    }
}
