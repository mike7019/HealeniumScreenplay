package com.co.project.driver.util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static net.serenitybdd.core.Serenity.getDriver;


public class DriverFactory {

    public static WebDriver createWebDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return createChromeDriver();
            case "chrome-headless":
                return createChromeHeadLessDriver();
            case "firefox":
               return createFirefoxDriver();
            case "firefox-headless":
                return createFirefoxHeadlessDriver();
            case "edge":
                return createEdgeDriver();
            default:
                break;

        }
        return getDriver();
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --incognito --no-sandbox --disable-download-notification");
        options.addArguments("use-fake-ui-for-media-stream");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver createChromeHeadLessDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createFirefoxHeadlessDriver() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        firefoxBinary.addCommandLineOptions("--window-size=1280x720");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }


}
