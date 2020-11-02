package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
Cvičení 4:
 - Najděte všechny položky v eshopu za pomoci řetězení elementů
 */
public class Lesson2Exercise4 {

    private static String shopUrl = Settings.baseUrl + "/shop/";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        driver.findElement(By.id("featuredItemsContainer"))
                .findElements(By.className("listing-product-name"))
                .forEach((WebElement we) -> {
                    System.out.println(we.getText());
                });


        driver.quit();
    }
}
