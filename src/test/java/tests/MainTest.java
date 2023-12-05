package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.main.MainPage;

import static com.codeborne.selenide.Selenide.$x;

@Owner("Ukondy")
@Epic("Проверка главной страницы")
@Feature("Тестирование выбора продукта и фильтрация продуктов")
public class MainTest {
    private MainPage mainPage = new MainPage();;

    @Test
    @Feature("Выбор товара")
    @Description("Выбирается первый товар на главной страницы и добовляется в корзину (я выбрал число 3)")
    public void productsTest() {
        mainPage.choseProduct(3);

        Assertions.assertEquals("1", mainPage.getBasketValue().innerText());
    }

    @Test
    @Feature("Проверка выподающего списка")
    @Description("Проверка открытия выподающего меню со смартфонами")
    public void genreTest() {
        mainPage.getGenre().click();
        mainPage.getPhoneGenre().click();

        Assertions.assertEquals("Смартфоны", $x("//div[@class='cia-vs']/h1[text()='Смартфоны']").innerText());
    }
}
