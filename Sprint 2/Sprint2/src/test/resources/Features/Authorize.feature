@tag
Feature: As an user I want to authorize and generate token.

Background: User is on Bookstore
	Given: User is on Bookstore Account Section
	
  @authorization
  Scenario: Basic Authorization
    When User enters userName and password as basic auth
    And User enter userName and password in body
    | Deepu | Deepu@123 |
    And User clicks on send option
    Then User should get Authorized successfully

  @generatingToken
  Scenario Outline: Generating Token
    When User enters "<userName>" and "<password>" in body
    And user click on send option to post
    Then Token should get generated

    Examples: 
      | userName  | password |
      | Deepu | Deepu@123 |
