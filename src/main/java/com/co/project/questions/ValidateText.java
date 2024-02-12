package com.co.project.questions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateText implements Question<String> {

    Target element;

    public ValidateText(Target element) {
        this.element = element;
    }

    @Override
    public String answeredBy(Actor actor) {
        return element.resolveFor(actor).getText();
    }

    public static ValidateText of(Target element){
        return Instrumented.instanceOf(ValidateText.class).withProperties(element);
    }
}
