import Constants.Config;
import PageObjects.MainPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
        logger.info("INFO: get url " + Config.MAIN_URI);
        mPage = new MainPage(driver);
    }

    @After
    @Step("Сохранить скриншот и закрыть браузер")
    public void tearDown() {
        makeScreenshot();
        driver.close();
        driver.quit();
    }

    @Step("Сохранить скриншот страницы")
    @Attachment(value = "Скриншот страницы", type = "image/png")
    public byte[] makeScreenshot() {
        logger.info("INFO: make screenshot");
        return ((TakesScreenshot) CommonTest.driver).getScreenshotAs(OutputType.BYTES);
    }
}