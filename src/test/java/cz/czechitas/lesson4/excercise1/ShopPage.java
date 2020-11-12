package cz.czechitas.lesson4.excercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopPage {

    private final By searchFieldSelector = By.id("searchField");
    private final By searchButtonSelector = By.className("searchButton");
    private final By produtItemSelector = By.className("listing-product-name");
    private final WebDriver driver;
    private final String baseUrl;

    ShopPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;

    }

    public void openPage() {
        driver.navigate().to(baseUrl + "/shop/");
    }

    public void searchInProducts(String text) {
        WebElement searchField = driver.findElement(By.id("searchField"));
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        searchField.sendKeys(text);
        searchButton.click();
    }

    public List<WebElement> getProducts() {
        return driver.findElements(By.className("listing-product-name"));
    }

//    public List<String> getProductNames() {
//        return driver.findElements(By.className("listing-product-name"));
//    }
}
