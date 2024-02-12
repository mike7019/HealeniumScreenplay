package com.co.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.co.project.userInterface.MeetingsPage.LBL_USER_VALIDATION;

public class ValidateTheMeetingName implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_USER_VALIDATION.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> value() {
        return new ValidateTheMeetingName();
    }


}