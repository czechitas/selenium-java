package cz.czechitas.lesson4.pages;

import org.openqa.selenium.WebDriver;

public class ShopPage {

    private final WebDriver driver;
    private final String baseUrl;

    private final String productsSelector = "//a[contains(@class, 'dropdown-toggle') and normalize-space(text()) ='Products']";

    public ShopPage(WebDriver webDriver, String baseUrl) {
        this.driver = webDriver;
        this.baseUrl = baseUrl;
    }

    public void openPage() {
        driver.navigate().to(this.baseUrl + "/shop");
    }

    public void gotProductsHandbags() {

    }

}
