package com.co.project.stepdefinitions;


import com.co.project.models.UsersLoombokData;

import com.co.project.questions.ValidateText;
import com.co.project.tasks.Authenticate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static com.co.project.driver.Auth.*;


import static com.co.project.utils.Global.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SerenityLoginStepDefinitions {

    @Given("that Mike was on the serenity demo page")
    public void thatMikeWasOnTheSerenityDemoPage() {
        OnStage.theActorCalled(MIKE).wasAbleTo(Open.url(URL));
    }
    @When("attempts to log in with this info")
    public void attemptsToLogInWithThisInfo(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Authenticate.on(UsersLoombokData.setData(table).get(0))
        );
    }
    @Then("^will try to heal in case of change and validate the (.*) on screen$")
    public void willTryToHealInCaseOfChangeAndValidateTheDashboardOnScreen(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(TXT_VALIDATION), Matchers.containsString(text)));

    }

}
