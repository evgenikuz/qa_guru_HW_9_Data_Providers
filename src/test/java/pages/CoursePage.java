package pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;

public class CoursePage {
    private final ElementsCollection itemsNames = $$(".popular-product-name");

    public void checkFirstNumerousCardsName(List<String> cardName, int amount) {
        itemsNames.first(amount).shouldHave(texts(cardName));
    }
}
