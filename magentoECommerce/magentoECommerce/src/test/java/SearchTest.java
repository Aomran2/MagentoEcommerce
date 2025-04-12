import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomTestListener.class)
public class SearchTest extends baseTest {

    @Test
    public void searchForHoodie() {

        //Searching for item, verify existence of this item
        search.searchForItem().clear();
        search.searchForItem().sendKeys("Oslo Trek Hoodie" + Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/4)");
        WebElement hoodieItem = search.validateOnItem();
        String expectedResult = "Oslo Trek Hoodie";
        String actualResult = hoodieItem.getText().trim();
        soft.assertEquals(actualResult, expectedResult, "Validation on item existence");
        soft.assertAll();
    }
}
