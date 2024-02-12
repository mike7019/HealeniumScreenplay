package com.co.project.tasks;

import com.co.project.interactions.ChooseFromList;
import com.co.project.interactions.ExplicitWait;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.co.project.userInterface.BusinessUnitPage.BTN_BUSSINESS;
import static com.co.project.userInterface.DashBoardPage.*;

import static com.co.project.userInterface.NewBusinessUnitPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class CreateANewBusinessUnit implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_ORGANIZATION, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_ORGANIZATION),
                JavaScriptClick.on(BTN_BUSSINESS_UNIT),
                JavaScriptClick.on(BTN_BUSSINESS),
                Enter.theValue("Bussiness_Name").into(TXT_BUSSINESS_NAME),
                Click.on(TXT_PARENT_UNIT),
                ChooseFromList.index(LST_PARENT_UNIT,0),
                JavaScriptClick.on(BTN_SAVE_UNIT)

        );
    }

    public static CreateANewBusinessUnit onTheSite() {
        return Instrumented.instanceOf(CreateANewBusinessUnit.class).withProperties();
    }
}