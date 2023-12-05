package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.basket.BasketPage;
import pages.basket.MapModalWindow;
import pages.basket.BuyFirstProduct;

import static com.codeborne.selenide.Selenide.$x;

@Owner("Ukondy")
@Epic("Проверка корзины")
@Feature("Проверка поиска товара из корзины и установка адресса доставки")
public class BasketTest {
    private BasketPage basket = new BasketPage();

    @Test
    @Feature("Проверка поисковой строки")
    @Description("Добавление в корзину 14-Iphone с помошью поисковой строки")
    public void searchTest() {
        BuyFirstProduct buyFirstProduct = basket.search("Iphone 14 купить");
        buyFirstProduct.addToBasket();

        Assertions.assertEquals("1", basket.getValue().innerText());
    }

    @Test
    @Feature("Проверка яндекс карты")
    @Description("Открытие и установка адреса в яндекс карту")
    public void mapTest() throws InterruptedException {
        MapModalWindow map = basket.map();
        String expected = map.setAddress("Юго-Западная территория", "1", "1", "1", "1");

        Assertions.assertTrue(basket.getAddress().innerText().contains(expected));
    }

}
