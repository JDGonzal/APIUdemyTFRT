package steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class TwitterAPIv2Steps {
  private static RequestSpecification request;
  private Response response;
  private ValidatableResponse json;

  @Given("^I have a valid API Key for the (.+) URI$")
  public void iSetTheRequestPArams(String URI) {
    String username = System.getenv("TwitterAPIv2consumer_key");
    String password = System.getenv("TwitterAPIv2consumer_secret");
    request = given().relaxedHTTPSValidation().auth().preemptive()
        .basic(username, password) // Variables de Ambiente
        .contentType(ContentType.URLENC) // Toca usa este Formato
        .baseUri(URI) // La ruta del URI
        .log().all(); // loguea todo el movimiento `DEBUG CONSOLE`
  }

  @When("^I send a POST request with the value body to the (.+) endpoint$")
  public void sendPOSTResquest(String endpoint) {
    // String requestBody = "{\n" + " \"grant_type\": \"client_credentials\"\n" +
    // "}";
    response = request.when()
        .params("grant_type", "client_credentials")
        // .body(requestBody) // No funciona en el body
        .post(endpoint).prettyPeek();
  }

  @Then("^I can validate I receive a valid token in the response$")
  public void valiadateTheToken() {
    response.then().statusCode(200);
  }
}
