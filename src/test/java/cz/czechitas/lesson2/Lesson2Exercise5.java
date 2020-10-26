package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Cvičení 5:
Lokalizujte elementy pomocí Xpath s použitím několika vlastností elementů
 */
public class Lesson2Exercise5 {

    private static String shopUrl = Settings.baseUrl + "/shop";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"featuredItemsContainer\"]/div/div/a/h3"));

        System.out.println("Found " + elements.size() + " elements:");
        elements.forEach((WebElement we) -> {
            System.out.println(we.getText());
        });

        driver.quit();
    }
}
