package cz.czechitas.lesson3;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/*
Cvičení 1:
 - Napište jednoduchý test
 - Inicializujte webdriver s použitím Before
 - V testu otevřete stránku ...
 - Korektně jej ukončete v After
 */
public class Lesson3Exercise1 {

    private static String shopUrl = Settings.baseUrl + "/shop";

    private static WebDriver driver;

    @Before
    public void setupBrowser() {
        driver = DriverHelper.openFirefox();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void openShopPage() {
        driver.navigate().to(shopUrl);
    }
}
