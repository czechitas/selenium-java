package cz.czechitas.lesson3;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class Lesson3Excercise1 {

    private static final String shopUrl = Settings.baseUrl + "/shop/";
    private static WebDriver driver;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    public void testShop() {
        driver.navigate().to(shopUrl);
    }

}
