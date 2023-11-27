package pages.main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class MainPage {
    private final ElementsCollection productsList = $$x("//div[@id='cleanable']/div/div/div/div/div[1]/div");
    private final SelenideElement genre = $x("//div[@class='cia-vs cia-cs']/button");
    private final SelenideElement phoneGenre = $x("//ul[@data-autotest-id='subItems']/li/div/a[text()='Смартфоны']");
    private final SelenideElement continueBuying = $x("//div[@class='_2OnNc']/div[@class='_3NMhq _2UfdH']/button");
    private final SelenideElement addToBasket = $x("//div[@data-index='1']//div/div/div/button[@target='_self']");
    private final String BASE_URL = "https://market.yandex.ru";

    public MainPage() {
        Selenide.open(BASE_URL);
    }

    @Step
    public void choseProduct(int number) {
        SelenideElement product = $x(By.xpath(
                        productsList.toString().substring(0, productsList.toString().length() - 1) + "[" + number + "]" + "//a"
        ).toString().split(" ")[2]);

        product.click();
        addToBasket.click();
        continueBuying.click();
    }
}
