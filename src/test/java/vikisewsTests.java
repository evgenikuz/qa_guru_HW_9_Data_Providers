import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.PatternsPage;

import java.lang.reflect.Array;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class vikisewsTests extends TestBase {
    MainPage mainPage = new MainPage();
    PatternsPage patternsPage = new PatternsPage();

    @DisplayName("Проверка верхнего меню")
    @ValueSource (strings = {
            "Выкройки", "Курсы", "Сертификаты", "Блог", "Отзывы"
    })
    @ParameterizedTest(name= "Проверяет, что по кнопке {0} в верхнем меню открывается страница с заголовком {0}")
    void checkMenuTest(String buttonAndHeaderName) {
        open("/");
        mainPage.findAndClickElement(buttonAndHeaderName)
            .checkHeaderName(buttonAndHeaderName);

    }
}
