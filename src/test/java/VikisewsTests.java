import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.CoursePage;
import pages.MainPage;
import pages.PatternsPage;

import java.util.List;
import java.util.stream.Stream;

public class VikisewsTests extends TestBase {
    MainPage mainPage = new MainPage();
    PatternsPage patternsPage = new PatternsPage();
    CartPage cartPage = new CartPage();
    CoursePage coursePage = new CoursePage();

    @ValueSource (strings = {
            "Выкройки", "Курсы", "Сертификаты", "Блог", "Отзывы"
    })
    @DisplayName("Проверка левого меню")
    @ParameterizedTest(name= "Проверяет, что по кнопке {0} в левом меню открывается страница с заголовком {0}")
    void checkMenuTest(String buttonAndHeaderName) {
        mainPage.openPage()
                .findAndClickElement(buttonAndHeaderName)
                .checkHeaderName(buttonAndHeaderName);

    }

    @CsvSource (value = {
            "154-160, 38",
            "162-168, 44",
            "170-176, 50",
            "178-184, 46",
            "154-160, 34",
            "178-184, 52"
    })
    @DisplayName("Проверка добавления выкройки определенного размера в корзину")
    @ParameterizedTest(name= "Проверяет, что в корзине выкройка на рост {0} и размером {1}")
    void sizeAndGrowthInCartShouldMatchWithChosenInCard(String growth, String size) {
        patternsPage.openPage()
                .checkHeader("Вистерия платье")
                .chooseGrowth(growth)
                .chooseSize(size)
                .clickOnAddToCartButton()
                .clickOnCart();
        cartPage.checkHeader("Корзина")
                .checkItemNameInCart("Вистерия платье")
                .checkSize(size)
                .checkGrowth(growth)
                .clearCart();
    }


    static Stream<Arguments> cardsOfItemsShouldMatchPage() {
        return Stream.of(
                Arguments.of("Курсы", List.of("2. Курс по пошиву по пошиву брюк Уитни и жакета Айнес", "Курс по пошиву косухи Джастин", "2. Курс по пошиву костюма: брюки Лени и блузка Циара", "2. Курс по пошиву пуховика Саоми")),
                Arguments.of("Сертификаты", List.of("Подарочный сертификат на 5000 ₽", "Подарочный сертификат на 200 ₽", "Подарочный сертификат на 10000 ₽", "Подарочный сертификат на 2500 ₽"))
        );
    }
    @MethodSource
    @DisplayName("Проверка соответствия страниц названию")
    @ParameterizedTest
    void cardsOfItemsShouldMatchPage(String pageName, List<String> expectedCards) {
        mainPage.openPage()
                .findAndClickElement(pageName);
        coursePage.checkFirstNumerousCardsName(expectedCards, 4);
    }

}

