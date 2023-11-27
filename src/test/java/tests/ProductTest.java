package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.product.MoreVariantPage;
import pages.product.ProductPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ProductTest {
    private final SelenideElement basketValue = $x("//div[@id=\"CART_ENTRY_POINT_ANCHOR\"]/a/div/div[@class='b7Sg3']/span");
    private final SelenideElement productTitle =  $x("//div[@class='x__tN']/div/div/h1");
    private ProductPage productPage;


    @Test
    @Feature(value = "Добавление в корзину")
    @Description(value = "Добавление в корзину несколько штук одного и того же товара со страницы товара (я выбрал 10)")
    public void addToBasketTest() throws InterruptedException {
        productPage = new ProductPage();
        productPage.clickAddSeveralTimes(10);

        Thread.sleep(500);
        Assertions.assertEquals("10", basketValue.innerText());
    }

    @Test
    @Feature("Проверка кнопки больше вариантов")
    @Description("Открытие страницы с похожими товарами и последующим выбором товара (я выбрал 4)")
    public void moreVariantsTest() {
        productPage = new ProductPage();
        productPage.clickMoreVariant();
        MoreVariantPage moreVariantPage = new MoreVariantPage();
        moreVariantPage.chooseVariant(1);

        Assertions.assertEquals(moreVariantPage.getChosePhone(), productTitle.getText());
    }

}
