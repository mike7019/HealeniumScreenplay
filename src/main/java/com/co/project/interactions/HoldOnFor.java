package com.co.project.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.core.Serenity.getDriver;


public class HoldOnFor implements Interaction {

    private int seconds;

    public HoldOnFor(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

    }

    public static Performable thisSeconds(int seconds)
    {
        return Instrumented.instanceOf(HoldOnFor.class).withProperties(seconds);
    }
}
