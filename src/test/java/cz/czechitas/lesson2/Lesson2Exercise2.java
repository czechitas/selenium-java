package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Cvičení 2:
Najděte a uložte do kolekce elementů všechny položky eshopu na hlavní stránce pomocí driver.findElements
 */
public class Lesson2Exercise2 {

    private static String shopUrl = Settings.baseUrl + "/shop";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        WebElement searchField = driver.findElement(By.id("searchField"));
        System.out.println(searchField.isEnabled());

        WebElement searchButton = driver.findElement(By.className("searchButton"));
        System.out.println(searchButton.isEnabled());

        List<WebElement> items = driver.findElements(By.className("listing-product-name"));

        System.out.println("Found " + items.size() + " products:");
        items.forEach((WebElement element) -> {
            System.out.println(element.getText());
        });

        driver.quit();
    }
}
