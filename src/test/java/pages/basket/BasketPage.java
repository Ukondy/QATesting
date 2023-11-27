package pages.basket;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BasketPage {
    private final SelenideElement search = $x("//input[@id='header-search']");
    private final SelenideElement map = $x("//button[@id='hyperlocation-unified-dialog-anchor']//span");
    private final String BASE_URL = "https://market.yandex.ru/my/cart";

    public BasketPage() {
        Selenide.open(BASE_URL);
    }

    @Step
    public BuyFirstProduct search(String text) {
        search.sendKeys(text);
        search.pressEnter();
        return new BuyFirstProduct();
    }

    @Step
    public MapModalWindow map() {
        map.click();
        return new MapModalWindow();
    }
}
