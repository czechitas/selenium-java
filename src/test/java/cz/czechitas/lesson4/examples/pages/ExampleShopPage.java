package cz.czechitas.lesson4.examples.pages;

import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ExampleShopPage {

    private final By searchFieldSelector = By.id("searchField");
    private final By searchButtonSelector = By.className("searchButton");
    private final By produtNameSelector = By.className("listing-product-name");
    private final By produtSelector = By.className("product");
    private final int maxWaitInSeconds = 10;
    private final WebDriver driver;

    public ExampleShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.navigate().to(Settings.baseUrl + "/shop/");
    }

    public void searchInProducts(String text) {
        driver.findElement(searchFieldSelector).sendKeys(text);
        driver.findElement(searchButtonSelector).click();
    }

    public List<String> getProductNames() {

        List<WebElement> productsAwaited = new WebDriverWait(driver, maxWaitInSeconds)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(produtNameSelector));

        // jednodušší
        List<String> names = new ArrayList();
        productsAwaited.forEach((WebElement element) -> names.add(element.getText()));
        return names;

        // složitější, ale lepší
        // return driver.findElements(produtNameSelector).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<ExampleProductItem> getProducts() {
        List<WebElement> productsAwaited = new WebDriverWait(driver, maxWaitInSeconds)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(produtSelector));

        // jednodušší
        List<ExampleProductItem> products = new ArrayList();
        productsAwaited.forEach((WebElement element) -> products.add(new ExampleProductItem(element)));
        return products;

        // složitější, ale lepší
        // return productsAwaited.stream().map(ExampleProductItem::new).collect(Collectors.toList());
    }

}
