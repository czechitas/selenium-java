package cz.czechitas.lesson1;

import cz.czechitas.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        Thread.sleep(5000);

        driver.quit();
    }

}