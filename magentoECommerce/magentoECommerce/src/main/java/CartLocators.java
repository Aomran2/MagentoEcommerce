import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartLocators {

    WebDriver driver;

    public CartLocators(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement showCart() {
        return driver.findElement(By.xpath("//a[@class=\"action showcart\"]"));
    }

    public WebElement cartBtnCheckOut() {
        return driver.findElement(By.xpath("//button[@id=\"top-cart-btn-checkout\"]"));
    }


}