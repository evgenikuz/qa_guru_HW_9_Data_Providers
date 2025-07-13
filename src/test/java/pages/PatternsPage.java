package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PatternsPage {
    private final SelenideElement header = $("h1"),
            addToCartButton = $("#addToCart"),
            cartIcon = $("#cartUrl");

    private final ElementsCollection growthOptions = $$("#growthRow .growth"),
            sizeOptions = $$("#sizeRow .sizes");

    public PatternsPage openPage() {
        open("/vykrojki/platja-i-sarafany/visterija-plate/");
        return this;
    }

    public PatternsPage checkHeader(String name) {
        header.shouldHave(text(name));
        return this;
    }

    public PatternsPage chooseGrowth(String growth) {
        growthOptions.findBy(text(growth)).click();
        return this;
    }

    public PatternsPage chooseSize(String size) {
        sizeOptions.findBy(text(size)).click();
        return this;
    }

    public PatternsPage clickOnAddToCartButton() {
        addToCartButton.click();
        addToCartButton.shouldHave(text("Добавлено!"));
        return this;
    }

    public void clickOnCart() {
        cartIcon.click();
    }

}
