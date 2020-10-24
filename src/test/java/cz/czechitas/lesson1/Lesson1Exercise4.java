package cz.czechitas.lesson1;

import cz.czechitas.Settings;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

/*
Cvičení 4:
 - Vyfoťte screenshot
 - Vytvořte metodu pro focení screenshotů
 */
public class Lesson1Exercise4 {

    private static String downloadsPath = Settings.PATH;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", Settings.PATH + "/src/test/resources/drivers/geckodriver");

        FirefoxOptions options = new FirefoxOptions()
                .addArguments("-private")
                .addPreference("browser.download.dir", downloadsPath)
                .addPreference("browser.download.folderList", 2);

        WebDriver driver = new FirefoxDriver(options);

        driver.manage().window().maximize();

        Thread.sleep(5000);

        driver.navigate().to("https://czechitas-shopizer.azurewebsites.net/shop");

        Thread.sleep(5000);

        takeScreenshot(driver, "shop1");

        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        srcFile.renameTo(new File(Settings.PATH + "selenium-java/" + screenshotName + ".png"));
    }

}