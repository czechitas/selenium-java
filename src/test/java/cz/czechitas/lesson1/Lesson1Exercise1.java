package cz.czechitas.lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
Cvičení 1:
 - Nastavte selenium a web driver v novém Java projektu v IntelliJ Idea
 - Inicializujte FireFox driver
 - uspěte vykonávání kódu po 5 vteřin
 - Ukončete správně driver tak aby došlo u uvolnění všech zdrojů
 */
public class Lesson1Exercise1 {

    public static final String PATH = "/Users/monikaprotivova/IdeaProjects/Czechitas/czechitas-selenium-java";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", PATH + "/src/test/resources/drivers/geckodriver");

        WebDriver driver = new FirefoxDriver();

        Thread.sleep(5000);

        driver.quit();
    }

}