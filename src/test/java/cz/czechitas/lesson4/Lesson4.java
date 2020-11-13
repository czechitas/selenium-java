package cz.czechitas.lesson4;

import cz.czechitas.DriverHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class Lesson4 {

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
    public void testSearch() {
        // kod
    }

}
