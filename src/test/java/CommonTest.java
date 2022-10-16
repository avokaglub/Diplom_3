import Constants.Config;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import PageObjects.MainPage;

// https://github.com/bonigarcia/webdrivermanager
// import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonTest {
    protected static WebDriver driver;

    // Главная страница
    MainPage mPage;

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
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