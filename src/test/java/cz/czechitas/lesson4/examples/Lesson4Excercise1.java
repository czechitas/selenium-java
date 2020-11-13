package cz.czechitas.lesson4.examples;

import cz.czechitas.DriverHelper;
import cz.czechitas.lesson4.examples.pages.ShopPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson4Excercise1 {

    private static WebDriver driver;
    private static ShopPage shopPage;

    private static List<String> defaultProducts = Arrays.asList(
            "Chic Vintage DeVille",
            "Vintage Laptop Bag",
            "Vintage Beach Bag",
            "Retro Style Bag"
    );

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        shopPage = new ShopPage(driver);
        shopPage.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("there should be 4 products displayed when no search")
    public void testDefault() {
        List<String> products = shopPage.getProductNames();
        assertEquals(defaultProducts, products, "Expected products are " + defaultProducts);
    }

    @Test
    @DisplayName("search for Vintage should yield 3 results")
    public void testSearch1() {
        shopPage.searchInProducts("Vintage");
        List<String> products = shopPage.getProductNames();

        List<String> expected = Arrays.asList("Chic Vintage DeVille", "Vintage Laptop Bag", "Vintage Beach Bag");
        assertEquals(expected, products, "Expected products are " + expected);
    }

    @Test
    @DisplayName("search for Retro should yield 1 result")
    public void testSearch2() {
        shopPage.searchInProducts("Retro");
        List<String> products = shopPage.getProductNames();

        List<String> expected = Arrays.asList("Retro Style Bag");
        assertEquals(expected, products, "Expected products are " + expected);
    }

}
