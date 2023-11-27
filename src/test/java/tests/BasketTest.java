package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.basket.BasketPage;
import pages.basket.MapModalWindow;
import pages.basket.BuyFirstProduct;

import static com.codeborne.selenide.Selenide.$x;


public class BasketTest {
    private final SelenideElement close = $x("//div/div[@class='cia-cs']/button[@aria-label='Закрыть']");
    private final SelenideElement basketValue = $x("//div[@id=\"CART_ENTRY_POINT_ANCHOR\"]/a/div/div[@class='b7Sg3']/span");
    private final SelenideElement basketAddress = $x("//button[@id='hyperlocation-unified-dialog-anchor']/div/div/span[1]");
    private BasketPage basket;

    @Test
    @Feature(value = "Проверка поисковой строки")
    @Description(value = "Добавление в корзину 14-Iphone с помошью поисковой строки")
    public void searchTest() {
        basket = new BasketPage();

        BuyFirstProduct buyFirstProduct = basket.search("Iphone 14 купить");
        if(close.isDisplayed()) {
            close.click();
        }
        buyFirstProduct.addToBasket();

        Assertions.assertEquals("1", basketValue.innerText());
    }

    @Test
    @Feature(value = "Проверка яндекс карты")
    @Description(value = "Открытие и установка адреса в яндекс карту")
    public void mapTest() throws InterruptedException {
        basket = new BasketPage();

        MapModalWindow map = basket.map();
        String expected = map.setAddress("Юго-Западная территория", "1", "1", "1", "1");

        Thread.sleep(25000);

        Assertions.assertTrue(basketAddress.innerText().contains(expected));
    }

}
