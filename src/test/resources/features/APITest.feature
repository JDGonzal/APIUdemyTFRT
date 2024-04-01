Feature: Request example for Udemy

@API
Scenario: Test GET to endpoint.
  Given I send a GET request to the endpoint
  Then I get a 400 status code
