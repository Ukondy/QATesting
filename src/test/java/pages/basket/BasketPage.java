package pages.basket;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BasketPage {
    private final String BASE_URL = "https://market.yandex.ru/my/cart";
    private final SelenideElement value = $x("//div[@id=\"CART_ENTRY_POINT_ANCHOR\"]/a/div/div[@class='b7Sg3']/span");
    private final SelenideElement address = $x("//button[@id='hyperlocation-unified-dialog-anchor']/div/div/span[1]");
    private final SelenideElement search = $x("//input[@id='header-search']");

    public BasketPage() {
        Selenide.open(BASE_URL);
    }

    @Step("Поисков товара по запросу {String}")
    public BuyFirstProduct search(String text) {
        search.sendKeys(text);
        search.pressEnter();
        return new BuyFirstProduct();
    }

    @Step("Открытие карты")
    public MapModalWindow map() {
        address.click();
        return new MapModalWindow();
    }
}
