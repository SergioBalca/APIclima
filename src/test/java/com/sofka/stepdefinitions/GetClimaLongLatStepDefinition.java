package com.sofka.stepdefinitions;

import com.sofka.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;

import static com.sofka.tasks.DoGet.doGet;
import static com.sofka.utils.Resources.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.notNullValue;

public class GetClimaLongLatStepDefinition extends ApiSetUp {

    public static Logger LOGGER = Logger.getLogger(GetClimaLongLatStepDefinition.class);
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    @Given("el usuario ingresa al servicio de clima OpenWeatherMap")
    public void elUsuarioIngresaAlServicioDeClimaOpenWeatherMap() {
        try {
            setUp(BASE_URL.getValue());
            LOGGER.info("INICIA AUTOMATIZACION");
        } catch (Exception e){
            LOGGER.info("Fallo en la configuracion inicial");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    @When("el usuario envia una peticion con la {double} y {double} del lugar")
    public void elUsuarioEnviaUnaPeticionConLaYDelLugar(Double latitud, Double longitud) {
        try {
            actor.attemptsTo(
                    doGet()
                            .withTheResource(String.format(
                                    GET_CLIMA_LONG_LAT.getValue(),
                                    latitud,
                                    longitud,
                                    TOKEN.getValue()
                            ))
            );
        } catch (Exception e){
            LOGGER.info("fallo al momento de realizar la peticion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
    @Then("el usuario deberia observar un {int} de respuesta OK y el reporte con el estado del clima con la {double} y {double} ingresadas")
    public void elUsuarioDeberiaObservarUnDeRespuestaOKYElReporteConElEstadoDelClimaConLaYIngresadas(Integer codigo, Double latitud, Double longitud){
        try {
            response = (Response) SerenityRest.lastResponse().body();
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            String name = responseBody.get(ATTRIBUTE_NAME.getValue()).toString();
            Object weather = responseBody.get(ATTRIBUTE_WEATHER.getValue());

            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + codigo,
                            response -> response.statusCode(codigo)),
                    seeThat(act -> weather, notNullValue()),
                    seeThat(act -> name, notNullValue())
            );

        } catch (Exception e){
            LOGGER.info("Fallo en la comparacion de resultados");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }


}
