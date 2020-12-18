import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

public class ClickUpTestPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final static String TEST_PAGE_LINK = "https://testpages.herokuapp.com/styled/challenges/growing-clickable.html";
    private final static By BUTTON_CLICK_ME_GROWN  = By.cssSelector("button[class='styled-click-button showgrow grown']");
    private static final By BUTTON_CLICK_ME = By.id("growbutton");
    private static final By P_EVENT_TRIGGERED = By.id("growbuttonstatus");

    public ClickUpTestPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void openPage () {
        driver.get(TEST_PAGE_LINK);
    }

    public void clickClickMeButton () {
        wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_CLICK_ME_GROWN));
        driver.findElement(BUTTON_CLICK_ME).click();
    }

    public void verifyThatButtonIsClicked () {
        assertEquals(driver.findElement(P_EVENT_TRIGGERED).getText(), "Event Triggered", "'Click Me' button is clicked and 'Event Triggered' text appears");
    }
}
