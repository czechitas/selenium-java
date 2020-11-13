package cz.czechitas.lesson4.examples;

import cz.czechitas.DriverHelper;
import cz.czechitas.lesson4.examples.pages.ProductItem;
import cz.czechitas.lesson4.examples.pages.ShopPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Lesson4Excercise2 {

    private static WebDriver driver;
    private static ShopPage shopPage;

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
    @DisplayName("all products on page should have name and price")
    public void testAllProducts() {
        shopPage.getProducts().forEach((ProductItem product) -> {
            assertFalse(product.getName().isEmpty(), "Product name should not be empty");
            assertTrue(product.getPrice().matches("USD[0-9]+.[0-9]+.*"), product.getPrice() + " is not valid product price");
        });
    }

}
