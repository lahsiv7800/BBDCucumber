Feature: Implementation of Demo Pet Store

Scenario: Test case execution for Demo Store Store
  Given User prepares get request to get "available" pets in pet store
  When Get request is triggered sucessfully    
  Then status code "<statusCode>" should be verify
  And Verify status "available" in the response body
   