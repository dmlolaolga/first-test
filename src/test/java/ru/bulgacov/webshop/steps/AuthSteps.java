package ru.bulgacov.webshop.steps;

import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import net.datafaker.Faker;
import ru.bulgacov.webshop.pages.WsRegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;

@Owner("Lola.Maer")
@Description("Класс бизнес-шагов (Steps) для операций аутентификации и регистрации пользователей. " +
        "Инкапсулирует сложную логику подготовки тестовых данных и действий.")
public class AuthSteps {
    private static final Faker faker = new Faker();

    @Step("Зарегистрировать нового пользователя с email: {email}")
    @Description("Генерирует случайные валидные данные (имя, фамилия, email, пароль) " +
            "и выполняет полный цикл регистрации через UI.")
    public void registerNewUser() {
        open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                .register(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.harryPotter().character() + faker.number().positive());
    }
}
