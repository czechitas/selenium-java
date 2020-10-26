package cz.czechitas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

public class DriverHelper {

    public static WebDriver openFirefox() {
        setDriver("geckodriver");
        FirefoxOptions options = new FirefoxOptions()
                .addArguments("-private")
                .addPreference("browser.download.dir", getPath(""))
                .addPreference("browser.download.folderList", 2);
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static void setDriver(String driver) {
        String driverPath = Objects.requireNonNull(DriverHelper.class.getClassLoader().getResource("drivers/" + driver)).getPath();
        System.setProperty("webdriver.gecko.driver", driverPath);
    }

    public static String getPath(String path) {
        return Objects.requireNonNull(DriverHelper.class.getClassLoader().getResource(path)).getPath();
    }

}
