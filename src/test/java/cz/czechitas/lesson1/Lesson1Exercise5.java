package cz.czechitas.lesson1;

import cz.czechitas.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

/*
Cvičení 5:
 - Získejte Page Title a jeho délku
 - Vypište Page Title a jeho délku do konzole
 - Získejte Page URL a ověřte že je otevřena správná stránka
 - Získejte zdrojový kód stránky (HTML Source code)
 - Vypište délku zdrojového kódu do konzole
 */
public class Lesson1Exercise5 {

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

        takeScreenshot(driver, "shop1");

        String title = driver.getTitle();
        System.out.println(title + " " + title.length());

        String url = driver.getCurrentUrl();
        System.out.println(url);

        System.out.println(url.equals(shopUrl));

        System.out.println(driver.getPageSource().length());

        Thread.sleep(5000);

        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot saved in: " + srcFile.getAbsolutePath());

        File newFile = new File(Settings.PATH + "/" + screenshotName + ".png");
        srcFile.renameTo(newFile);
        System.out.println("Screenshot moved to: " + newFile.getAbsolutePath());
    }

}