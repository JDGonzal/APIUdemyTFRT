package steps;

// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class APISteps {

  private static RequestSpecification request;
  private Response response;
  private ValidatableResponse json;

  @Given("^I send a GET request to the endpoint$")
  public void sendGETRequest() {
    request = given()
              .baseUri("https://api.github.com") //la ruta URI
              .contentType(ContentType.JSON);
  }

  @Then("^I get a (\\d+) status code$")
  public void validateListOfUsers(int expectedStatusCode) {
    response = request.when()
              .get("/users/jdgonzal/repos");  // Acá va el endpoint
   
    json = response.then().statusCode(expectedStatusCode);
    System.out.println(json.toString());
  }

}
