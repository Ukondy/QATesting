package pages.product;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class ProductPage {
    private final String BASE_URL = "https://market.yandex.ru/product--smartfon-xiaomi-poco-m5s/1769448256?sku=101882158798&do-waremd5=LEdy22gH3EpuOQ4I5zsxpw&uniqueId=924574&resale_goods=resale_new";
    private final SelenideElement increaseValueProduct = $x("//section[@id='cardAddButton']//div[@class='cia-cs']/button/span[text()='+']");
    private final SelenideElement basketValue = $x("//div[@id=\"CART_ENTRY_POINT_ANCHOR\"]/a/div/div[@class='b7Sg3']/span");
    private final SelenideElement continueBuying = $x("//div[@id='cardContent']//div[@class='_3NMhq _2UfdH']/button");
    private final SelenideElement moreVariants = $x("//div[@class='cia-vs cia-cs']/div/div[@class='_xtBJ _1X9HJ']/a");
    private final SelenideElement addToBasket = $x("//section[@id='cardAddButton']//button[@target='_self']");
    private final SelenideElement productTitle =  $x("//div[@class='x__tN']/div/div/h1");

    public ProductPage() {
        Selenide.open(BASE_URL);
    }

    @Step("Простое добавление продукта")
    public void clickAdd() {
        addToBasket.click();
        if(continueBuying.isDisplayed()) continueBuying.click();
    }

    @Step("Добавление продукта {int} раз")
    public void clickAddSeveralTimes(int n) {
        clickAdd();
        plusNProduct(n);
    }

    @Step("Вспомогательный метод для добавления продукта")
    private void plusNProduct(int n) {
        for (int i = 1; i < n; i++) {
            increaseValueProduct.click();
        }
    }

    @Step("Нажатие на кнопку 'больше вариантов'")
    public void clickMoreVariant() {
        moreVariants.click();
    }

}
