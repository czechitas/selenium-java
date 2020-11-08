package cz.czechitas.lesson3;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Lesson3Excercise2 {

    private static final String shopUrl = Settings.baseUrl + "/shop/";
    private static WebDriver driver;

    private static final int defaultProductsOnPage = 4;

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

        WebElement searchField = driver.findElement(By.id("searchField"));
        assertEquals("", searchField.getAttribute("value"), "Search text should be empty");

        WebElement searchButton = driver.findElement(By.className("searchButton"));
        assertTrue(searchButton.isEnabled(), "Search button should be enabled");

        List<WebElement> allProducts = driver.findElements(By.className("listing-product-name"));
        assertEquals(defaultProductsOnPage, allProducts.size(), "There should be " + defaultProductsOnPage + " products on the page");
    }

}
