package cz.czechitas.lesson1;

import cz.czechitas.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

/*
Cvičení 2:
 - Nastartuje prohlížeč
 - Maximalizovaný na celou obrazovku
 - V Inkognito módu
 - Nastavte cestu pro stahování souborů

 */
public class Lesson1Exercise2Chrome {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(Settings.DRIVER, Settings.DRIVER_PATH);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", Settings.PATH);

        ChromeOptions options = new ChromeOptions()
                .addArguments("incognito")
                .setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        Thread.sleep(5000);

        driver.quit();
    }

}