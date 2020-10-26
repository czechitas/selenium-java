package cz.czechitas.lesson4.pages;

import org.openqa.selenium.WebDriver;

public class AdminPage {

    private final WebDriver driver;
    private final String baseUrl;

    public AdminPage(WebDriver webDriver, String baseUrl) {
        this.driver = webDriver;
        this.baseUrl = baseUrl;
    }

    public void openPage() {
        driver.navigate().to(this.baseUrl + "/admin");
    }

}
