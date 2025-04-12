import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchLocators {

    WebDriver driver;
    public SearchLocators(WebDriver driver){
        this.driver=driver;
    }

    public WebElement searchForItem() {
        return driver.findElement(By.xpath("//input[@placeholder=\"Search entire store here...\"]"));
    }

    public WebElement validateOnItem() {
        return driver.findElement(By.xpath("//a[contains(text(),'Oslo Trek Hoodie')]"));
    }

}
