package pages.product;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;

@Getter
public class MoreVariantPage {
    private final ElementsCollection morePhones = $$x("//div[@class='nyBEU']/div[@class='_1yHwd cia-vs']//h3/a");
    private String chosePhone;

    @Step
    public void chooseVariant(int variant) {
        chosePhone = morePhones.get(variant).getText();
        morePhones.get(variant).click();
    }
}
