Feature: Implementation of Demo Pet Store

Scenario: Test case execution for Demo Store Store
  Given User prepares get request to get "available" pets in pet store
  When Get request is triggered sucessfully    
  Then status code should be verify
  And Verify status "available" in the response body
  
Scenario: Test case execution for Adding new pet to store
  Given User Prepars POST request to post new pet in store   
  When POST request is triggered sucessfully
  Then status code should be verify
  And Assert newly addes pet "Cheeta" to store
  
Scenario: Test case execution to update status of Added pet 
  Given User Prepars PUT request to post new pet in store   
  When PUT request is triggered sucessfully
  Then status code should be verify
  And Asserts newly added pets status "sold" in the response 
    