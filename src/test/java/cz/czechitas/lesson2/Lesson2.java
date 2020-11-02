package cz.czechitas.lesson2;

import cz.czechitas.DriverHelper;
import cz.czechitas.Settings;
import org.openqa.selenium.WebDriver;

public class Lesson2 {

    private static String shopUrl = Settings.baseUrl + "/shop/";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverHelper.openFirefox();

        driver.navigate().to(shopUrl);

        // sem pište kód



        driver.quit();
    }
}
