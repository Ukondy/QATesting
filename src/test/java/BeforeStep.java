import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


abstract public class BeforeStep {
    public static EventFiringWebDriver driver;
    public static WebDriverWait wait;


    private static void setUp() {
        Configuration.proxyEnabled = true;
        wait = new WebDriverWait(driver, Duration.ofMillis(500));
    }

    @BeforeEach
    private void init() {
        setUp();
    }

    @AfterEach
    private void tearDown() {
        Selenide.closeWebDriver();
    }

}
