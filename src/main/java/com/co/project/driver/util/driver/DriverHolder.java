package com.co.project.driver.util.driver;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;



public class DriverHolder {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DriverHolder.driver.set(driver);
    }

    public static void setDriverForScreenshots(WebDriver driver){
        setDriver(driver);
        Serenity.getWebdriverManager().setCurrentDriver(driver);
    }

}
