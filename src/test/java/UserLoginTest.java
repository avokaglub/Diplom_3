import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@Epic("Авторизация пользователя")
@Feature("Авторизация пользователя")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserLoginTest extends CommonTest {
    /*
    Вход
	Проверь:
		вход по кнопке «Войти в аккаунт» на главной,
		вход через кнопку «Личный кабинет»,
		вход через кнопку в форме регистрации,
		вход через кнопку в форме восстановления пароля.
     */
    @Test
    @DisplayName("Тест авторизации пользователя")
    @Description("После успешной авторизации пользователя появится ссылка на личный кабинет") // Появляется форма авторизации //
    public void userLoginTest() {
        String randomEmail = RandomStringUtils.randomAlphabetic(5, 10).toLowerCase() + "@example.com";
        this.mPage.openAccountForm()
                .openRegistrationForm()
                .fillAndSendRegistrationForm("Name", randomEmail, "password")
                .waitAuthFormToBeVisible()
                .fillAndSendAuthForm(randomEmail, "password");
        // После авторизации переход на главную страницу
    }

}
