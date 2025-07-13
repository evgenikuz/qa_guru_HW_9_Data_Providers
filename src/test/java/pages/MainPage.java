package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final ElementsCollection menuElements = $$(".navbar-nav a");
    private final SelenideElement header = $("h1");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage findAndClickElement(String buttonName) {
        menuElements.findBy(text(buttonName)).click();
        return this;
    }

    public void checkHeaderName(String headerName) {
        header.shouldHave(text(headerName));
    }

}
