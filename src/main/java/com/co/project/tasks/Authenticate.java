package com.co.project.tasks;

import com.co.project.models.UsersLoombokData;
import com.co.project.userInterface.SerenityDemoUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Authenticate implements Task {

    UsersLoombokData userData;

    public Authenticate(UsersLoombokData userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SerenityDemoUI.TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userData.getUser()).into(SerenityDemoUI.TXT_USER),
                Enter.theValue(userData.getPass()).into(SerenityDemoUI.TXT_PASS),
                JavaScriptClick.on(SerenityDemoUI.BTN_SUBMIT),
                WaitUntil.the(SerenityDemoUI.TXT_VALIDATION, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static Authenticate on(UsersLoombokData userData){
        return Instrumented.instanceOf(Authenticate.class).withProperties(userData);
    }
}
