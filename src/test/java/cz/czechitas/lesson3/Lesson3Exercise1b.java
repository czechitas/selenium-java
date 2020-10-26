package cz.czechitas.lesson3;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Cvičení 1:
 - Napište jednoduchý test
 - Inicializujte webdriver s použitím Before
 - V testu otevřete stránku ...
 - Korektně jej ukončete v After
 */
public class Lesson3Exercise1b {

    private static String shopUrl = Settings.baseUrl + "/shop";

    private static WebDriver driver;

    @BeforeClass
    public static void setupBrowser() {
        driver = DriverHelper.openFirefox();
        driver.navigate().to(shopUrl);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testListAllShopElementsOnPage() {
        List<WebElement> items = driver.findElements(By.className("listing-product-name"));

        System.out.println("Found " + items.size() + " products:");
        items.forEach((WebElement element) -> {
            System.out.println(element.getText());
        });
    }

    @Test
    public void testSearchOnShopPage() {
        WebElement searchField = driver.findElement(By.id("searchField"));
        searchField.sendKeys("Table");

        WebElement searchButton = driver.findElement(By.className("searchButton"));
        searchButton.click();

        List<WebElement> items = driver.findElements(By.className("listing-product-name"));

        System.out.println("Found " + items.size() + " products:");
        items.forEach((WebElement element) -> {
            System.out.println(element.getText());
        });
    }

    @Test
    public void testSearchFieldAttributes() {
        WebElement searchField = driver.findElement(By.id("searchField"));
        System.out.println(searchField.getAttribute("type"));
        System.out.println(searchField.getAttribute("name"));
        System.out.println(searchField.getAttribute("class"));
    }
}
