package com.co.project.tasks;

import com.co.project.interactions.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.project.userInterface.DashBoardPage.*;
import static com.co.project.userInterface.MeetingsPage.*;
import static com.co.project.userInterface.NewMeetingPage.*;
import static com.co.project.userInterface.NewMeetingPage.TXT_MEETING_NAME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateANewMeeting implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {



        actor.attemptsTo(
                WaitUntil.the(BTN_MEETING, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_MEETING),
                JavaScriptClick.on(BTN_MEETINGS),
                Ensure.that(LBL_TEXT).isDisplayed(),
                JavaScriptClick.on(BTN_NEW_MEETING),
                Enter.theValue("Meeting_Name").into(TXT_MEETING_NAME),
                Click.on(TXT_MEETING_TYPE),
                ChooseFromList.index(LST_MEETING_TYPE, 2),
                Click.on(TXT_START_DATE),
                Clear.field(TXT_START_DATE),
                Enter.keyValues("02/22/2024 19:17").into(TXT_START_DATE),
                Enter.keyValues("123456789").into(TXT_MEETING_NUMBER),
                JavaScriptClick.on(TXT_END_DATE),
                Clear.field(TXT_END_DATE),
                Enter.keyValues("02/25/2024 20:17").into(TXT_END_DATE),
                Click.on(TXT_LOCATION),
                ChooseFromList.index(LST_LOCATION_OPTIONS, 3),
                Click.on(TXT_ORGANIZED_BY),
                Enter.keyValues("Andrew").into(TXT_ORGANIZED_BY_FIELD).then(HitEnterKey.onScreen()),
                HitEnterKey.onScreen(),
                Click.on(TXT_UNIT),
                SelectUnit.on(LST_UNIT, "Administration"),
                Click.on(TXT_REPORTER),
                Enter.keyValues("Andrew").into(TXT_REPORTED_BY_FIELD).then(HitEnterKey.onScreen()),
                HitEnterKey.onScreen(),
                Click.on(TXT_ATENDEE_LIST),
                Enter.keyValues("Alexandra").into(TXT_ATTENDEE_BY_FIELD).then(HitEnterKey.onScreen()),
                ExplicitWait.here(1),
                HitEnterKey.onScreen(),
                Click.on(BTN_SAVE),
                ExplicitWait.here(5),
                Ensure.that(LBL_USER_VALIDATION).isDisplayed()
        );
    }

    public static CreateANewMeeting onTheSite() {
        return Instrumented.instanceOf(CreateANewMeeting.class).withProperties();
    }
}