import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstItemLocators {

    WebDriver driver;

    public FirstItemLocators(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement navigateToGearMenuIcon() {
        return driver.findElement(By.xpath("//span[contains(text(), 'Gear')]"));
    }

    public WebElement chosenSubMenu() {
        return driver.findElement(By.xpath("//span[contains(text(), 'Bags')]"));
    }

    public WebElement selectFirstItem() {
        return driver.findElement(By.xpath("//li[@class=\"item product product-item\" and contains(., 'Crown Summit Backpack')]"));
    }

    public WebElement addFirstItemToCart() {
        return driver.findElement(By.xpath("//button[@title=\"Add to Cart\"]"));
    }

    public WebElement addedToShoppingCart() {
        return driver.findElement(By.xpath("//div[@role=\"alert\"]//div//div"));
    }
}
