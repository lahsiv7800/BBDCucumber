Feature: Get Available Pets

    Scenario: Sending get request to "/pet/findByStatus" endpoints to get the available pets
       Given User prepares a get request to find pet by providing status "available"
       When Get request is triggered sucessfully
       Then status code "<statusCode>" should be verified
       And Verify the status "available" in the response body