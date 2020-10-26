package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
Cvičení 1:
Zkuste najít na stránce internetového obchodu element Search input box a Search button pomocí driver.findElement

 */
public class Lesson2Exercise1 {

    private static String shopUrl = Settings.baseUrl + "/shop";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        WebElement searchField = driver.findElement(By.id("searchField"));
        System.out.println(searchField.isEnabled());

        WebElement searchButton = driver.findElement(By.className("searchButton"));
        System.out.println(searchButton.isEnabled());

        driver.quit();
    }
}
