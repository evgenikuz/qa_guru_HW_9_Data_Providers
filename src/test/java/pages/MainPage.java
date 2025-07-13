package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private ElementsCollection menuElements = $$(".navbar-nav a");
    private SelenideElement header = $("h1");

    public MainPage findAndClickElement(String buttonName) {
        menuElements.findBy(text(buttonName)).click();
        return this;
    }

    public MainPage checkHeaderName(String headerName) {
        $("h1").shouldHave(text(headerName));
        return this;
    }

}
