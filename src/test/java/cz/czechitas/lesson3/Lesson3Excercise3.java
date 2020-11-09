package cz.czechitas.lesson3;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shop page search behavior")
public class Lesson3Excercise3 {

    private static final String shopUrl = Settings.baseUrl + "/shop/";
    private static WebDriver driver;

    private static final int defaultProductsOnPage = 4;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        driver.navigate().to(shopUrl);
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("search field should be empty when first visiting the shop page")
    public void testDefaultSearchFiled() {
        WebElement searchField = driver.findElement(By.id("searchField"));
        assertEquals("", searchField.getAttribute("value"), "Search text should be empty");
    }

    @Test
    @DisplayName("search button should be enabled when first visiting the shop page")
    public void testDefauyltSearchButton() {
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        assertTrue(searchButton.isEnabled(), "Search button is should be enabled");
    }

    @Test
    @DisplayName("there should be 4 products displayed when no search")
    public void testDefaultNumberOfProducts() {
        List<WebElement> allProducts = driver.findElements(By.className("listing-product-name"));
        assertEquals(defaultProductsOnPage, allProducts.size(), "There should be " + defaultProductsOnPage + " products on the page");
    }

    @Test
    @Tag("search")
    @DisplayName("search should filter products")
    public void testSearchBehavior() {
        WebElement searchField = driver.findElement(By.id("searchField"));
        WebElement searchButton = driver.findElement(By.className("searchButton"));

        searchField.sendKeys("Vintage");
        searchButton.click();

        List<WebElement> filteredProducts = driver.findElements(By.className("listing-product-name"));
        assertTrue(filteredProducts.size() < defaultProductsOnPage && filteredProducts.size() > 0,
                "There should be < " + defaultProductsOnPage + " and > 0 products on the page");
    }

}
