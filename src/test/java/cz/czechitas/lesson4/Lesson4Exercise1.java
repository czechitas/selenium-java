package cz.czechitas.lesson4;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import cz.czechitas.lesson4.pages.ShopPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
Vytvořte page object pro Home page internetového obchodu, page bude mít konstruktor přes který bude do page předána instance webdriveru.
Používejte junit, driver inicializujte v “before” a vypněte jej v “after”
Test bude ověřovat zda se pro správnou url otevře opravdu home page internetového obchodu.
 */
public class Lesson4Exercise1 {

    private static final String baseUrl = Settings.baseUrl;

    private static WebDriver driver;
    private static ShopPage shopPage;

    @BeforeClass
    public static void setupBrowser() {
        driver = DriverHelper.openFirefox();
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);

        shopPage = new ShopPage(driver, baseUrl);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void openShopPage() {
        shopPage.openPage();
        Assert.assertEquals("Should be on main shop page", driver.getCurrentUrl(), baseUrl + "/shop");
    }

}
