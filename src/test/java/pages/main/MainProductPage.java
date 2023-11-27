package pages.main;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainProductPage {
    private final SelenideElement addToBasket = $x("//section[@id='cardAddButton']//button[@target='_self']");
    private final SelenideElement continueBuying = $x("//div[@id='cardContent']//div[@class='_3NMhq _2UfdH']/button");

    @Step
    public void addToBasket() {
        addToBasket.click();
        continueBuying.click();
    }
}
