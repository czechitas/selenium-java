package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Cvičení 2:
 - Pomocí findElements najděte a uložte do kolekce elementů všechny položky eshopu na hlavní stránce
 - Vypište text každé z nich
 */
public class Lesson2Exercise2 {

    private static String shopUrl = Settings.baseUrl + "/shop/";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        List<WebElement> productItems = driver.findElements(By.className("listing-product-name"));

        System.out.println("Found " + productItems.size() + " products:");
        productItems.forEach((WebElement element) -> {
            System.out.println(element.getText());
        });

        driver.quit();
    }
}
