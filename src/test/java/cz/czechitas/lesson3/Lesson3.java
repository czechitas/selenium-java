package cz.czechitas.lesson3;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Lesson3 {

    private static String shopUrl = Settings.baseUrl + "/shop";

    private static WebDriver driver;

    @Before
    public void setupBrowser() {
        // inicializujte webdriver
    }

    @After
    public void closeBrowser() {
        // ukončete webdriver
    }

    @Test
    public void openShopPage() {
        // otevřete stránku
    }
}
