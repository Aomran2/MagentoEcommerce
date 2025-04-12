import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(CustomTestListener.class)
public class CartTest extends baseTest {

    @Test
    public void addFirstItemToCart() throws InterruptedException {

        //hovering on menuIcons and selecting sub-menu
        Actions action = new Actions(driver);
        WebElement FirstMenuIcon = first.navigateToGearMenuIcon();
        Thread.sleep(2000);
        action.moveToElement(FirstMenuIcon).perform();
        WebElement clickSubMenu = first.chosenSubMenu();
        clickSubMenu.click();

        //choosing first item and add the item to cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement item = first.selectFirstItem();
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", item);
        action.scrollToElement(item).perform();
        item.click();
        wait.until(ExpectedConditions.visibilityOf(first.addFirstItemToCart())).click();
        String expectedResult = "You added Crown Summit Backpack to your shopping cart.";
        String actualResult = first.addedToShoppingCart().getText().trim();
        soft.assertEquals(actualResult, expectedResult, "first item assertion");
        soft.assertAll();

    }

    @Test
    public void addSecondItemToCart() {

        //choosing second item and add the item to cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement secondMenuIcon = second.navigateToMenMenuIcon();
        secondMenuIcon.click();
        second.tops().click();
        second.secondItem().click();
        second.selectingSize().click();

        WebElement color = second.selectingColor();
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", color);
        wait.until(ExpectedConditions.elementToBeClickable(color)).click();
        second.addSecondItemToCart().click();
        String expected = "You added Sparta Gym Tank to your shopping cart.";
        String actual = second.secondItemAddedToCart().getText().trim();
        soft.assertEquals(actual, expected, "second item assertion");
        soft.assertAll();
    }

    @Test
    public void continueToCheckOut() throws InterruptedException {

        //proceeding to check out, filling shipping address details, and place order
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        CartLocators.showCart().click();
        CartLocators.cartBtnCheckOut().click();
        Thread.sleep(2000);

        shipping.email().sendKeys("test@test.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/4)");
        WebElement fName = shipping.firstName();
        wait.until(ExpectedConditions.elementToBeClickable(fName)).click();

        shipping.firstName().sendKeys("John");
        shipping.lastName().sendKeys("Doe");
        shipping.company().sendKeys("test company");
        shipping.streetAddress().sendKeys("street");
        shipping.city().sendKeys("California");

        WebElement stateDropdown = shipping.stateDropDown();
        Select state = new Select(stateDropdown);
        state.selectByVisibleText("California");

        shipping.postCode().sendKeys("12345-6789");

        WebElement countryDropdown = shipping.country();
        Select country = new Select(countryDropdown);
        country.selectByVisibleText("United States");

        shipping.phoneNumber().sendKeys("0523923432");
        shipping.shippingMethod().click();
        shipping.nextBtn().click();

        Thread.sleep(2000);
        placeOrder.checkBox().click();
        placeOrder.placeOrder().click();

        WebElement confirmation = placeOrder.orderConfirmation();
        //wait.until(ExpectedConditions.visibilityOf(confirmation));
        Thread.sleep(5000);
        String expectedResult = "We'll email you an order confirmation with details and tracking info.";
        String actualResult = confirmation.getText().trim();
        soft.assertEquals(actualResult, expectedResult, "order confirmation assertion");
        soft.assertAll();
    }
}
