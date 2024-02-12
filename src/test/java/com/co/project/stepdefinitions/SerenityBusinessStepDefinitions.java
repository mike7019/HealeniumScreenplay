package com.co.project.stepdefinitions;

import com.co.project.questions.ValidateTheMeetingName;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


import com.co.project.tasks.CreateANewBusinessUnit;
import com.co.project.tasks.CreateANewMeeting;
import net.serenitybdd.screenplay.actors.OnStage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SerenityBusinessStepDefinitions {

    @When("^Mike creates a new unit business and setups a meeting$")
    public void mikeCreatesANewUnitBusinessAndSetupsAMeeting() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateANewBusinessUnit.onTheSite(),
                CreateANewMeeting.onTheSite()
        );

    }

    @Then("^Mike will be able see the meeting was successfully scheduled$")
    public void mikeWillBeAbleSeeTheMeetingWasSuccessfullyScheduled() {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateTheMeetingName.value()));

    }
}
