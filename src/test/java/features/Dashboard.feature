Feature: Application Dashboard

Scenario: Home page default login
Given User is on NetBanking landing page
When User is login into application with username and password
Then Home page is populated
And Card are displayed