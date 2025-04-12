import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingAddressLocators {

    WebDriver driver;

    public ShippingAddressLocators(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement email() {
        return driver.findElement(By.xpath("//div[4]//input[@type=\"email\"]"));
    }

    public WebElement firstName() {
        return driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
    }

    public WebElement lastName() {
        return driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
    }

    public WebElement company() {
        return driver.findElement(By.xpath("//input[@name=\"company\"]"));
    }

    public WebElement streetAddress() {
        return driver.findElement(By.xpath("//input[@name=\"street[0]\"]"));
    }

    public WebElement city() {
        return driver.findElement(By.xpath("//input[@name=\"city\"]"));
    }

    public WebElement stateDropDown() {
        return driver.findElement(By.xpath("//select[@name=\"region_id\"]"));
    }

    public WebElement postCode() {
        return driver.findElement(By.xpath("//input[@name=\"postcode\"]"));
    }

    public WebElement country() {
        return driver.findElement(By.xpath("//select[@name=\"country_id\"]"));
    }

    public WebElement phoneNumber() {
        return driver.findElement(By.xpath("//input[@name=\"telephone\"]"));
    }

    public WebElement shippingMethod() {
        return driver.findElement(By.xpath("//input[@name=\"ko_unique_1\"]"));
    }

    public WebElement nextBtn() {
        return driver.findElement(By.xpath("//span[@data-bind=\"i18n: 'Next'\"]"));
    }
}
