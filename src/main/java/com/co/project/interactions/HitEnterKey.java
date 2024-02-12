package com.co.project.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.core.Serenity.getDriver;


public class HitEnterKey implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions action = new Actions(getDriver());
        action.sendKeys(Keys.ENTER).build().perform();

    }

    public static HitEnterKey onScreen(){
        return Instrumented.instanceOf(HitEnterKey.class).withProperties();
    }
}
