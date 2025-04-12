import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class baseTest {

    WebDriver driver;
    String baseUrl = "https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html";
    CartLocators CartLocators;
    SearchLocators search;
    FirstItemLocators first;
    SecondItemLocators second;
    ShippingAddressLocators shipping;
    PlaceOrderLocators placeOrder;
    SoftAssert soft;


    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        CartLocators = new CartLocators(driver);
        search = new SearchLocators(driver);
        first = new FirstItemLocators(driver);
        second = new SecondItemLocators(driver);
        shipping = new ShippingAddressLocators(driver);
        placeOrder = new PlaceOrderLocators(driver);
        soft = new SoftAssert();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
