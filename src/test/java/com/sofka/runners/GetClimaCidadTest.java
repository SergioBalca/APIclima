package com.sofka.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"com.sofka.stepdefinitions"},
        features = {"src/test/resources/features/getclimaciudad.feature"}
)
public class GetClimaCidadTest {
}
