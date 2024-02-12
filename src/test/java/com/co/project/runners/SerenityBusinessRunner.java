package com.co.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/serenityBusiness.feature",
        glue = "com.co.project.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class SerenityBusinessRunner {
}
