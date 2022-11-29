package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationForm {
    private WebDriver driver = null;

    // Селекторы формы регистрации
    private By lNameLocator = By.xpath(".//label[text()='Имя']");
    private By lEmailLocator = By.xpath(".//label[text()='Email']");
    private By lPasswordLocator = By.xpath(".//label[text()='Пароль']");
    private By iLocator = By.xpath("./following-sibling::input");
    private By bRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    public By tPasswordErrorMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public UserRegistrationForm(WebDriver driver) {
        this.driver = driver;
    }

    private void setValue(By eLocator, String value){
        WebElement element = driver.findElement(eLocator);
        element.click();
        WebElement input = element.findElement(iLocator);
        input.clear();
        input.sendKeys(value);
    }

    @Step("Ввести имя: {value}")
    public void setNameValue(String value){
        this.setValue(this.lNameLocator, value);
    }

    @Step("Ввести адрес электронной почты: {value}")
    public void setEmailValue(String value){
        this.setValue(this.lEmailLocator, value);
    }

    @Step("Ввести пароль: {value}")
    public void setPasswordValue(String value){
        this.setValue(this.lPasswordLocator, value);
    }

    @Step("Кликнуть по кнопке 'Зарегистрироваться'")
    public void btnRegisterClick() {
        driver.findElement(bRegistration).click();
    }

    @Step("Проверить отображается ли сообщение об ошибке у поля ввода пароля")
    public boolean tPasswordErrorMessageIsDisplayed() {
        return driver.findElement(tPasswordErrorMessage).isDisplayed();
    }

}
