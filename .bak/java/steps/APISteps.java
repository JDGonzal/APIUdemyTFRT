package steps;

import java.util.List;

// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APISteps {

  private static RequestSpecification request;
  private Response response;
  private ValidatableResponse json;

  @Given("^I send a GET request to the (.+) URI$")
  public void sendGETRequest(String URI) {
    request = given()
        .baseUri(URI) // la ruta URI
        .contentType(ContentType.JSON);
  }

  @Then("^I get a (\\d+) status code$")
  public void validateListOfUsers(int expectedStatusCode) {
    response = request.when()
        .get("/users/jdgonzal/repos"); // Acá va el endpoint

    json = response.then().statusCode(expectedStatusCode);
    System.out.println(json.toString());
  }

  @Then("^I validate there are (\\d+) items on the (.+) endpoint$")
  public void validateSize(int expectedSize, String endpoint) {
    response = request.when()
        .get(endpoint);
    // Obtenemos toda la lista del JSON
    List<String> jsonResponse = response.jsonPath().getList("$");
    // Cargamos el valor actual
    int actualSize = jsonResponse.size();
    // Comparamos el valor esperado con el actual
    assertEquals(expectedSize, actualSize);
  }

  @Then("^I validate there is a (.+): (.+) in the response at (.+) endpoint$")
  public void validateValue(String key, String value, String endpoint) {
    response = request.when()
        .get(endpoint);
    // Obtenemos toda la lista del JSON
    List<String> jsonResponse = response.jsonPath().getList(key);
    // System.out.println(jsonResponse);

    assertTrue("The " + key + " with value:" + value + " was not found.",
        jsonResponse.contains(value));
  }

}
