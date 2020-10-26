package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Cvičení 3:
 - Vyplňte do Search boxu “Table”
 - Klikněte na tlačítko search
 - Najděte a uložte do kolekce všechny vyhledané položky v eshopu na stránce
 */
public class Lesson2Exercise3 {

    private static String shopUrl = Settings.baseUrl + "/shop";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        WebElement searchField = driver.findElement(By.id("searchField"));
        searchField.sendKeys("Table");

        WebElement searchButton = driver.findElement(By.className("searchButton"));
        searchButton.click();

        List<WebElement> items = driver.findElements(By.className("listing-product-name"));

        System.out.println("Found " + items.size() + " products:");
        items.forEach((WebElement element) -> {
            System.out.println(element.getText());
        });

        driver.quit();
    }
}
