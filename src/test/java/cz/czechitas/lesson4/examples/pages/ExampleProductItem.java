package cz.czechitas.lesson4.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExampleProductItem {

    private final By nameSelector = By.className("listing-product-name");
    private final By priceSelector = By.tagName("h4");

    private final WebElement element;

    public ExampleProductItem(WebElement element) {
        this.element = element;
    }

    public String getName() {
        return this.element.findElement(nameSelector).getText();
    }

    public String getPrice() {
        return this.element.findElement(priceSelector).getText();
    }

}
