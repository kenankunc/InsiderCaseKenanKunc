import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BrowserDriver {

    public static WebDriver driver;
    private String url;

    public WebDriver getDriver() throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");

        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(
                "/Users/kenankunc/IdeaProjects/InsiderCaseKenan/src/main/resources/config.properties");
        prop.load(data);

        if (prop.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver(options);
        } else if (prop.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver");

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return driver;

    }
    public String getUrl() throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(
                "/Users/kenankunc/IdeaProjects/InsiderCaseKenan/src/main/resources/config.properties");
        prop.load(data);
        url = prop.getProperty("mainUrl");
        return url;
    }


}
