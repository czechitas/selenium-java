package cz.czechitas.lesson4;

import cz.czechitas.lesson4.pages.ShopPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
Vytvořit druhou page na kterou se lze navigovat z první a použít v testu
 */
public class Lesson4Exercise2 {

    private static final String PATH = "/Users/monikaprotivova/IdeaProjects/Czechitas/czechitas-selenium-java";

    private static final String baseUrl = "https://czechitas-shopizer.azurewebsites.net";

    private static WebDriver driver;
    private static ShopPage shopPage;

    @BeforeClass
    public static void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", PATH + "/src/test/resources/drivers/geckodriver");
        FirefoxOptions options = new FirefoxOptions()
                .addArguments("-private");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);

        shopPage = new ShopPage(driver, baseUrl);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void navigateToNextPage() {
        shopPage.openPage();
        shopPage.gotProductsHandbags();
        Assert.assertEquals("Should be on handbags page", driver.getCurrentUrl(), baseUrl + "/shop/category/handbags.html/ref=c:2");
    }

}
