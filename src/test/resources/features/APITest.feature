Feature: Request example for Udemy

Scenario: Test GET to endpoint.
  Given I send a GET request to the https://api.github.com URI
  Then I get a 200 status code

Scenario: Validate the quantity of elements in the response. 
  Given I send a GET request to the https://jsonplaceholder.typicode.com URI
  Then I validate there are 10 items on the /users endpoint

Scenario: Validate an element exist in the response.
  Given I send a GET request to the https://jsonplaceholder.typicode.com URI
  Then I validate there is a username: Delphine in the response at /users endpoint

@API
Scenario: Validate a value nested within the response
  Given I send a GET request to the https://jsonplaceholder.typicode.com URI
  Then I validate there is a address.street: Kattie Turnpike in the response at /users endpoint
