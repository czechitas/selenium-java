package cz.czechitas.lesson1;

import cz.czechitas.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
Cvičení 3:
 - Nav sigujtee v prohlížečí na http://czechitas-shopizer.azurewebsites.net/shop/
 - Uspěte vykonávání na 5 sec

 */
public class Lesson1Exercise3 {

    private static String shopUrl = Settings.baseUrl + "/shop/";

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions()
                .addArguments("-private")
                .addPreference("browser.download.dir", Settings.PATH)
                .addPreference("browser.download.folderList", 2);

        WebDriver driver = new FirefoxDriver(options);

        driver.manage().window().maximize();

        driver.navigate().to(shopUrl);

        Thread.sleep(5000);

        driver.quit();
    }

}