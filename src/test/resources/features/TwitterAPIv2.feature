@xAPIv2
Feature: Twitter API v2 some scenarios.

  Rule: When I send POST request to the endpoint, I receive a token I can use to make further authenticated calls.

    Scenario: As a user, I can retrieve a Token when making a valid POST request
      Given I have a valid API Key for the https://api.twitter.com URI
      When I send a POST request with the value body to the /oauth2/token endpoint
      Then I can validate I receive a valid token in the response

    Scenario: As a user, I use and invalid API Key, I get an HTTP Code Status 403
      Given I have an invalid API Key for the https://api.twitter.com URI
      When I send a POST request with the value body to the /oauth2/token endpoint
      Then I receive an HTTP Code Status 403

    Scenario: As a user, when I send the POST request witout "grant_type", I get an HTTP Code Status 400
      Given I have an invalid API Key for the https://api.twitter.com URI
      When I send a POST request witout "grant_type" in it's body
      Then I receive an HTTP Code Status 400
