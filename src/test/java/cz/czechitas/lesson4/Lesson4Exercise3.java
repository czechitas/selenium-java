package cz.czechitas.lesson4;

import cz.czechitas.lesson4.pages.ShopPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
Vytvořit page pro https://czchitasshopizer.azurewebsites.net/admin/
Přidejte do ní metodu LogIn(string userName, string password)
username:admin@shopizer.com password:password
 */
public class Lesson4Exercise3 {

    private static final String PATH = "/Users/monikaprotivova/IdeaProjects/Czechitas/czechitas-selenium-java";

    private static final String baseUrl = "https://czechitas-shopizer.azurewebsites.net";

    private static WebDriver driver;
    private static ShopPage shopPage;

    @BeforeClass
    public static void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", PATH + "/src/test/resources/drivers/geckodriver");
        FirefoxOptions options = new FirefoxOptions()
                .addArguments("-private");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);

        shopPage = new ShopPage(driver, baseUrl);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testAdminPage() {
        // TODO
    }

}
