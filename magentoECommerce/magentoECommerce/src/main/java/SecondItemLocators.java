import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondItemLocators {

    WebDriver driver;

    public SecondItemLocators(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement navigateToMenMenuIcon() {
        return driver.findElement(By.xpath("//span[contains(text(), 'Men')]"));
    }

    public WebElement tops() {
        return driver.findElement(By.xpath("//a[contains(text(), 'Tops')]"));
    }

    public WebElement secondItem() {
        return driver.findElement(By.xpath("//img[@alt=\"Sparta Gym Tank\"]"));
    }

    public WebElement selectingSize() {
        return driver.findElement(By.xpath("//div[@id=\"option-label-size-143-item-168\"]"));
    }

    public WebElement selectingColor() {
        return driver.findElement(By.xpath("//div[@aria-label=\"Green\"]"));
    }

    public WebElement addSecondItemToCart() {
        return driver.findElement(By.xpath("//button[@title=\"Add to Cart\"]"));
    }

    public WebElement secondItemAddedToCart() {
        return driver.findElement(By.xpath("//div[contains(text(), 'You added Sparta Gym Tank to your')]"));
    }
}
