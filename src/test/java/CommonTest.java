import Constants.Config;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import PageObjects.MainPage;

public class CommonTest {
    protected static WebDriver driver;

    // Главная страница
    MainPage mPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Config.MAIN_URI);
        mPage = new MainPage(driver);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}