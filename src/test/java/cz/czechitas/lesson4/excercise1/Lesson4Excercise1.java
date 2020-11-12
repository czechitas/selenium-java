package cz.czechitas.lesson4.excercise1;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson4Excercise1 {

    private static WebDriver driver;
    private static ShopPage shopPage;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        shopPage = new ShopPage(driver, Settings.baseUrl);
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("search for Vintage should yeield 3 results")
    public void testSearch1() {
        shopPage.openPage();
        shopPage.searchInProducts("Vintage");
        shopPage.getProducts();
    }

    @Test
    @DisplayName("search for Retro should yeield 1 result")
    public void testSearch2() {
        shopPage.openPage();
        shopPage.searchInProducts("Retro");
        shopPage.getProducts();
    }

}
