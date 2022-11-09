import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@Epic("Регистрация пользователя")
@Feature("Регистрация пользователя")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRegistrationTest extends CommonTest {
    /*
    Регистрация
    Проверь:
        Успешную регистрацию.
        Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
     */
    @Test
    @DisplayName("Тест регистрации пользователя")
    @Description("После успешной регистрации пользователя появится сообщение") // Появляется форма авторизации //
    public void newUserRegistrationTest() {
        String randomEmail = RandomStringUtils.randomAlphabetic(5, 10).toLowerCase() + "@example.com";
        this.mPage.openAccountForm()
                .openRegistrationForm()
                .fillAndSendRegistrationForm("Name", randomEmail, "password")
                .waitAuthFormToBeVisible()
                .fillAndSendAuthForm(randomEmail, "password");
    }

    @Test
    @DisplayName("Тест регистрации пользователя с паролем меньше шести символов")
    @Description("После успешной регистрации пользователя появится ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void newUserFailRegistrationTest() {
        String randomEmail = RandomStringUtils.randomAlphabetic(5, 10).toLowerCase() + "@example.com";
        this.mPage.openAccountForm()
                .openRegistrationForm()
                .fillAndSendRegistrationForm("Name", randomEmail, "pass");
        this.mPage.waitPasswordErrorMessageToBeVisible();
        Assert.assertTrue(this.mPage.userRegistrationForm.tPasswordErrorMessageIsDisplayed());
    }
}
