import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrderLocators {

    WebDriver driver;

    public PlaceOrderLocators(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement placeOrder() {
        return driver.findElement(By.xpath("//span[@data-bind=\"i18n: 'Place Order'\"]"));
    }

    public WebElement checkBox() {
        return driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
    }

    public WebElement orderConfirmation() {
        return driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[2]"));
    }
}
