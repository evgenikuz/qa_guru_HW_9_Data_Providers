package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {
    private final SelenideElement header = $("h1"),
                 itemNameInCart= $(".cart-info-block .cart-item-name"),
                 clearCartButton = $(".delete-cart");

    private final ElementsCollection itemOptions = $$(".cart-info-block .cart-params");

    public CartPage checkHeader(String name) {
        header.shouldHave(text(name));
        return this;
    }

    public CartPage checkItemNameInCart(String name) {
        itemNameInCart.shouldHave(text(name));
        return this;
    }

    public CartPage checkSize(String size) {
        itemOptions.findBy(text("Размер")).shouldHave(text("Размер: " + size));
        return this;
    }

    public CartPage checkGrowth(String growth) {
        itemOptions.findBy(text("Рост")).shouldHave(text("Рост: " + growth));
        return this;
    }

    public CartPage clearCart() {
        clearCartButton.click();
        sleep(2000);
        return this;
    }



}
