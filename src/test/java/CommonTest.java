import Constants.Config;
import PageObjects.MainPage;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CommonTest {
    protected static WebDriver driver;

    // Главная страница
    MainPage mPage;

    final Logger logger = LoggerFactory.getLogger(CommonTest.class);

    @Before
    @Step("Открыть главную страницу")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Config.MAIN_URI);
        logger.info("Get url " + Config.MAIN_URI);
        mPage = new MainPage(driver);
    }

    @After
    @Step("Закрыть браузер")
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}