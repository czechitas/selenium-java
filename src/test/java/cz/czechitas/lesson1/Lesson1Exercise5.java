package cz.czechitas.lesson1;

import cz.czechitas.Settings;
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

    private static String downloadsPath = Settings.PATH;
    private static String shopUrl = Settings.baseUrl + "/shop";

    private static final String baseUrl = "https://czechitas-shopizer.azurewebsites.net/shop/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", Settings.PATH + "/src/test/resources/drivers/geckodriver");

        FirefoxOptions options = new FirefoxOptions()
                .addArguments("-private")
                .addPreference("browser.download.dir", downloadsPath)
                .addPreference("browser.download.folderList", 2);

        WebDriver driver = new FirefoxDriver(options);

        driver.manage().window().maximize();

        Thread.sleep(5000);

        driver.navigate().to(shopUrl);

        Thread.sleep(5000);

        takeScreenshot(driver, "shop1");

        String title = driver.getTitle();
        System.out.println(title + " " + title.length());

        String url = driver.getCurrentUrl();
        System.out.println(url);

        System.out.println(url.equals(shopUrl));

        System.out.println(driver.getPageSource().length());

        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        srcFile.renameTo(new File(Settings.PATH + "/" + screenshotName + ".png"));
    }

}