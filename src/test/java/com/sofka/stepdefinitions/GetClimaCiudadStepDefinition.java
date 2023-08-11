package com.sofka.stepdefinitions;

import com.sofka.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static com.sofka.tasks.DoGet.doGet;
import static com.sofka.utils.Resources.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;



public class GetClimaCiudadStepDefinition extends ApiSetUp {

    public static Logger LOGGER = Logger.getLogger(GetClimaCiudadStepDefinition.class);
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    @Given("el usuario ingresa al servicio OpenWeathermap")
    public void elUsuarioIngresaAlServicioOpenWeathermap() {
        try {
            setUp(BASE_URL.getValue());
            LOGGER.info("INICIA AUTOMATIZACION");
        } catch (Exception e){
            LOGGER.info("Fallo en la configuracion inicial");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    @When("el usuario envia una peticion con el nombre de la {string}")
    public void elUsuarioEnviaUnaPeticionConElNombreDeLa(String ciudad) {
        try {
            actor.attemptsTo(
                    doGet()
                            .withTheResource(String.format(
                                    GET_CLIMA_CIUDAD.getValue(),
                                    ciudad,
                                    TOKEN.getValue()
                            ))
            );
        } catch (Exception e){
            LOGGER.info("fallo al momento de realizar la peticion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    @Then("Deberia observar un {int} de respuesta OK, el nombre de la {string} elegida y el reporte del clima")
    public void deberiaObservarUnDeRespuestaOKElNombreDeLaElegidaYElReporteDelClima(Integer codigo, String ciudad) throws ParseException {
        try {
            response = (Response) SerenityRest.lastResponse().body();
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            String name = responseBody.get("name").toString();
            Object weather = responseBody.get("weather");

            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + codigo,
                            response -> response.statusCode(codigo)),
                    seeThat(act -> name, equalTo(ciudad)),
                    seeThat(act -> weather, notNullValue())
            );

        } catch (Exception e){
            LOGGER.info("Fallo en la comparacion de resultados");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }




    }
}
