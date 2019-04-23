package com.mrjunos.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {

    private WebDriver driver;

    public MyDriver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\juanjose.cano\\Documents\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
