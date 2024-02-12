package com.co.project.stepdefinitions;

import com.co.project.driver.util.driver.DriverFactory;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.co.project.driver.util.driver.DriverFactory.createWebDriver;
import static com.co.project.driver.util.driver.DriverHolder.setDriver;
import static com.co.project.driver.util.driver.DriverHolder.setDriverForScreenshots;
import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {

    @Before
    public void setup() {
        WebDriver reportsDriver = createWebDriver("chrome");
        setDriverForScreenshots(reportsDriver);
        WebDriver selfHealingDriver = SelfHealingDriver.create(reportsDriver);
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(selfHealingDriver)));
    }

    @After
    public static void close() {
        getDriver().quit();
    }

}
