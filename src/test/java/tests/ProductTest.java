package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.product.MoreVariantPage;
import pages.product.ProductPage;

@Owner("Ukondy")
@Epic("Проверка страницы продукта")
@Feature("Проверка добавления и выбор больше вариантов на страницы продукта")
public class ProductTest {
    private final ProductPage productPage = new ProductPage();

    @Test
    @Feature("Добавление в корзину")
    @Description("Добавление в корзину несколько штук одного и того же товара со страницы товара (я выбрал 10)")
    public void addToBasketTest() {
        productPage.clickAddSeveralTimes(10);

        Assertions.assertEquals("10", productPage.getBasketValue().innerText());
    }

    @Test
    @Feature("Проверка кнопки больше вариантов")
    @Description("Открытие страницы с похожими товарами и последующим выбором товара (я выбрал 4)")
    public void moreVariantsTest() {
        productPage.clickMoreVariant();
        MoreVariantPage moreVariantPage = new MoreVariantPage();
        moreVariantPage.chooseVariant(1);

        Assertions.assertEquals(moreVariantPage.getChosePhone(), productPage.getProductTitle().getText());
    }

}
