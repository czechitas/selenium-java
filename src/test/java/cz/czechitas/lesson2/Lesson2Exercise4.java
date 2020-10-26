package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
Cvičení 4:
 - GetAttribute
 - Získejte všechny atributy pro search box element
 */
public class Lesson2Exercise4 {

    private static String shopUrl = Settings.baseUrl + "/shop";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        WebElement searchField = driver.findElement(By.id("searchField"));
        System.out.println(searchField.getAttribute("type"));
        System.out.println(searchField.getAttribute("name"));
        System.out.println(searchField.getAttribute("class"));

        driver.quit();
    }
}
