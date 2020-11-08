package cz.czechitas.lesson3;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Shop page search behavior")
public class Lesson3Excercise5 {

    private static final String shopUrl = Settings.baseUrl + "/shop/";
    private static WebDriver driver;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        driver.navigate().to(shopUrl);
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvSource({
            "Vintage,3",
            "Retro,1"
    })
    @DisplayName("search should filter products")
    public void testSearchBehavior2(String searchText, int expectedSize) {
        WebElement searchField = driver.findElement(By.id("searchField"));
        WebElement searchButton = driver.findElement(By.className("searchButton"));

        searchField.sendKeys(searchText);
        searchButton.click();

        List<WebElement> filteredProducts = driver.findElements(By.className("listing-product-name"));
        assertEquals(expectedSize, filteredProducts.size(),
                "There should be " + expectedSize + " products on the page");
    }

}
