package com.co.project.driver;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Auth implements Task {
    private static final Target TXT_USER = Target.the("txt")
            .located(By.id("LoginPanel0_Username"));
    private static final Target TXT_PASS = Target.the("txt")
            .located(By.id("LoginPanel0_Password"));
    private static final Target BTN_SUBMIT = Target.the("txt")
            .located(By.id("LoginPanel0_LoginButton"));
    public static final Target TXT_VALIDATION = Target.the("txt")
            .located(By.xpath("//h1"));


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("admin").into(TXT_USER),
                Enter.theValue("serenity").into(TXT_PASS),
                JavaScriptClick.on(BTN_SUBMIT),
                WaitUntil.the(TXT_VALIDATION, isVisible()).forNoMoreThan(10).seconds());
    }

    public static Auth on() {
        return Instrumented.instanceOf(Auth.class).withProperties();
    }
}
