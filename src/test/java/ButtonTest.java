import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonTest {
    private WebDriver driver;
    private ClickUpTestPage clickUpTestPage;

    @BeforeClass(description = "Initializing browser")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        clickUpTestPage = new ClickUpTestPage(driver);
    }

    @Test(description = "Open test page, click 'ClickMe' button and verify that event is triggered")
    public void clickClickMeButtonTest() {
        clickUpTestPage.openPage();
        clickUpTestPage.clickClickMeButton();
        clickUpTestPage.verifyThatButtonIsClicked();
    }

    @AfterClass(description = "Closing browser")
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
