package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAuthForm {
    private WebDriver driver = null;

    // Селекторы формы авторизации
    private By lEmailLocator = By.xpath(".//label[text()='Email']");
    private By lPasswordLocator = By.xpath(".//label[text()='Пароль']");
    private By iLocator = By.xpath("./following-sibling::input");
    private By bEnter = By.xpath(".//button[text()='Войти']");

    public UserAuthForm(WebDriver driver) {
        this.driver = driver;
    }

    private void setValue(By eLocator, String value){
        WebElement element = driver.findElement(eLocator);
        element.click();
        element.findElement(iLocator).sendKeys(value);
    }

    @Step("Ввести адрес электронной почты: {value}")
    public void setEmailValue(String value){
        this.setValue(this.lEmailLocator, value);
    }

    @Step("Ввести пароль: {value}")
    public void setPasswordValue(String value){
        this.setValue(this.lPasswordLocator, value);
    }

    @Step("Кликнуть по кнопке 'Войти'")
    public void btnClick() {
        driver.findElement(bEnter).click();
    }

}
