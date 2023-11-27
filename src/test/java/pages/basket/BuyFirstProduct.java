package pages.basket;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BuyFirstProduct {
    private final SelenideElement addToBasket = $x("//div[@data-index='1']//div/div/div/button[@target='_self']");
    private final SelenideElement continueBuying = $x("//div[@class='_2OnNc']/div[@class='_3NMhq _2UfdH']/button");

    @Step
    public void addToBasket() {
        addToBasket.click();
        continueBuying.click();
    }
}
