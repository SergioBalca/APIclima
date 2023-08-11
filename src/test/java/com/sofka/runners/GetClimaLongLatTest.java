package com.sofka.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"com.sofka.stepdefinitions"},
        features = {"src/test/resources/features/getclimalonglat.feature"}
)
public class GetClimaLongLatTest {
}
