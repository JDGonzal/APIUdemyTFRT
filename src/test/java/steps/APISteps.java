package steps;

// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;

public class APISteps {

  @Given("^I send a GET request to the endpoint$")
  public void sendGETRequest() {

  }

  @Then("^I get a list with (\\d+) users$")
  public void validateListOfUsers(int expectedUserSize) {

  }

}
