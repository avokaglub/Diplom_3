package PageObjects;

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

    public void setNameValue(String value){
        this.setValue(this.lNameLocator, value);
    }

    public void setEmailValue(String value){
        this.setValue(this.lEmailLocator, value);
    }

    public void setPasswordValue(String value){
        this.setValue(this.lPasswordLocator, value);
    }

    public void btnRegisterClick() {
        driver.findElement(bRegistration).click();
    }

    public boolean tPasswordErrorMessageIsDisplayed() {
        return driver.findElement(tPasswordErrorMessage).isDisplayed();
    }

}
