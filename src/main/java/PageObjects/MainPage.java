package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver = null;

    // войти
    private By accountLinkSelector = By.xpath(".//a[@href='/account']");
    // зарегистрироваться
    private By registrationLinkSelector = By.xpath(".//a[text()='Зарегистрироваться']");
    private By userAuthFormSelector = By.xpath(".//form[contains(@class,'Auth_form')]");
    private By userProfileLinkSelector = By.xpath(".//a[text()='Личный кабинет']");
    private By userAccountFormSelector = By.xpath(".//a[contains(@class,'Account_account')]");
    public UserRegistrationForm userRegistrationForm;
    public UserAuthForm userAuthForm;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.userRegistrationForm = new UserRegistrationForm(this.driver);
        this.userAuthForm = new UserAuthForm(this.driver);
    }

    private void setValue(By eLocator, String value){
        this.driver.findElement(eLocator).sendKeys(value);
    }

    @Step("Открыть форму авторизации")
    public MainPage openAccountForm(){
        this.driver.findElement(accountLinkSelector).click();
        return this;
    }

    @Step("Открыть форму регистрации")
    public MainPage openRegistrationForm(){
        this.driver.findElement(registrationLinkSelector).click();
        return this;
    }

    @Step("Заполнить и отправить форму регистрации: {name}, {email}, {password}")
    public MainPage fillAndSendRegistrationForm(String name, String email, String password){
        this.userRegistrationForm.setNameValue(name);
        this.userRegistrationForm.setEmailValue(email);
        this.userRegistrationForm.setPasswordValue(password);
        this.userRegistrationForm.btnRegisterClick();
        return this;
    }

    public MainPage waitElementToBeVisible(By elementBy) {
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(
                ExpectedConditions.visibilityOfElementLocated(elementBy)
        );
        return this;
    }

    @Step("Дождаться видимости формы авторизации")
    public MainPage waitAuthFormToBeVisible() {
        waitElementToBeVisible(userAuthFormSelector);
        return this;
    }

    @Step("Дождаться появления сообщения об ошибке")
    public MainPage waitPasswordErrorMessageToBeVisible() {
        waitElementToBeVisible(userRegistrationForm.tPasswordErrorMessage);
        return this;
    }

    @Step("Заполнить форму авторизации: {email}, {password}")
    public MainPage fillAndSendAuthForm(String email, String password){
        this.userAuthForm.setEmailValue(email);
        this.userAuthForm.setPasswordValue(password);
        this.userAuthForm.btnClick();
        return this;
    }

}