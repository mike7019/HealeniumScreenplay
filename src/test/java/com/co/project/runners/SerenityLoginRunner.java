package com.co.project.runners;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/serenityLogin.feature",
        glue = "com.co.project.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SerenityLoginRunner {
}
