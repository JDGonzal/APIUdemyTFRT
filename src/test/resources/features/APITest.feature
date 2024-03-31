Feature: Request example for Udemy

Scenario: Test GET to endpoint.
  Given I send a GET request to the endpoint
  Then I get a list with 10 users
