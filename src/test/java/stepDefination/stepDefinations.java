package stepDefination;

import cucumber.api.PendingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinations {

    @Given("^User is on NetBanking landing page$")
    public void user_is_on_netbanking_landing_page() throws Throwable 
    { 
    	System.out.println("I am in NetBanking login Page");
        
    }

    @When("^User is login into application with username and password$")
    public void user_is_login_into_application_with_username_and_password() throws Throwable 
    {
        System.out.println("Please enter the username and password");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable 
    {
       System.out.println("You are in Home Page");
    }

    @cucumber.api.java.en.And("^Card are displayed$")
    public void card_are_displayed() throws Throwable 
    {
        System.out.println("Card is displaying now");
    }

}