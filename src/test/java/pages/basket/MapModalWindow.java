package pages.basket;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MapModalWindow {
        private final ElementsCollection delivery = $$x("//input[@class='_3qxDp']");
        private final ElementsCollection firstAddress = $$x("//ul[@class='rGg6R']/li");
        private final SelenideElement setUpAddress = $x("//div[@class='_1H6O9']/div/div/button");

        @Step("Смена модального окна на 'Курьер' и установка адреса")
        public String setAddress(String address, String apartment, String entrance, String floor, String intercom) throws InterruptedException {
            $x("//div[@class='_27s-P']/div/div/span[text()='Курьер']").click();

            Thread.sleep(1000);
            delivery.get(0).setValue("");
            Thread.sleep(1000);
            delivery.get(0).sendKeys(address);
            Thread.sleep(1000);
            firstAddress.get(0).click();
            Thread.sleep(1000);

            delivery.get(1).sendKeys(apartment);
            delivery.get(2).sendKeys(entrance);
            delivery.get(3).sendKeys(floor);
            delivery.get(4).sendKeys(intercom);

            setUpAddress.click();

            return address;
        }
}
