package cz.czechitas.examples.cucumber;

import cz.czechitas.DriverHelper;
import cz.czechitas.lesson4.examples.pages.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopSteps {

    private static WebDriver driver;
    private static ExampleShopPage shopPage;


    @Given("user is on the shop page")
    public void userIsOnShop() {
        driver = DriverHelper.openChrome();
        shopPage = new ExampleShopPage(driver);
        shopPage.openPage();
    }

    @Then("there are {int} products")
    public void thereAreProducts(int numberOfProducts) {
        List<ExampleProductItem> products = shopPage.getProducts();
        assertEquals(numberOfProducts, products.size(), "There should be " + numberOfProducts + " products");
    }

    @Then("each product has name")
    public void productHasName() {
        shopPage.getProducts().forEach((ExampleProductItem product) -> {
            String name = product.getName();
            assertFalse(name.isEmpty(), "Product name should not be empty");
        });
    }

    @Then("each product has price")
    public void productHasPrice() {
        shopPage.getProducts().forEach((ExampleProductItem product) -> {
            String price = product.getPrice();
            assertTrue(price.matches("USD[0-9]+.[0-9]+.*"), price + " is not valid product price");
        });
    }

    @When("he searches by {string}")
    public void search(String searchString) {
        shopPage.searchInProducts(searchString);
    }

    @Then("each product name contains {string}")
    public void productNameContains(String partialName) {
        shopPage.getProductNames().forEach((String productName) -> {
            assertTrue(productName.contains(partialName), "Product name should contain " + partialName);
        });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}