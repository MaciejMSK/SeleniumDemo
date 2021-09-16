import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

class SeleniumDemoFirstTest {

    public String baseUrl = "https://www.google.com/";
    String driverPath = "src/resources/chromedriver_ver93.exe";

    public WebDriver driver;

    @Test
    public void test() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Google");
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
