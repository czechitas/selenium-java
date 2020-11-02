package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
Cvičení 1:
 - Zkuste najít na stránce internetového obchodu element políčko Search a tlačítko Search
 - Zjistěte, jestli jsou editovatelné (enabled) a viditelné
 - Vypište hodnotu atributu value na tlačítku Search
 */
public class Lesson2Exercise1 {

    private static String shopUrl = Settings.baseUrl + "/shop/";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        WebElement searchField = driver.findElement(By.id("searchField"));
        System.out.println("Search field is enabled: " + searchField.isEnabled());
        System.out.println("Search field is displayed: " + searchField.isDisplayed());

        WebElement searchButton = driver.findElement(By.className("searchButton"));
        System.out.println("Search button is enabled: " + searchButton.isEnabled());
        System.out.println("Search button is displayed: " + searchButton.isDisplayed());
        System.out.println("Search button value is: " + searchButton.getAttribute("value"));

        driver.quit();
    }
}
