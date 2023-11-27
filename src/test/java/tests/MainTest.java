package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.main.MainPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainTest {
    private final SelenideElement close = $x("//div/div[@class='cia-cs']/button[@aria-label='Закрыть']");
    private final SelenideElement basketValue = $x("//div[@id=\"CART_ENTRY_POINT_ANCHOR\"]/a/div/div[@class='b7Sg3']/span");
    private MainPage mainPage;

    @Test
    @Feature(value = "Выбор товара")
    @Description(value = "Выбирается первый товар на главной страницы и добовляется в корзину (я выбрал число 3)")
    public void productsTest() {
        mainPage = new MainPage();
        mainPage.choseProduct(3);

        Assertions.assertEquals("1", basketValue.innerText());
    }

    @Test
    @Feature("Проверка выподающего списка")
    @Description(value = "Проверка открытия выподающего меню со смартфонами")
    public void genreTest() {
        mainPage = new MainPage();
        if(close.isDisplayed()) {
            close.click();
        }
        mainPage.getGenre().click();
        mainPage.getPhoneGenre().click();

        Assertions.assertEquals("Смартфоны", $x("//div[@class='cia-vs']/h1[text()='Смартфоны']").innerText());
    }
}
