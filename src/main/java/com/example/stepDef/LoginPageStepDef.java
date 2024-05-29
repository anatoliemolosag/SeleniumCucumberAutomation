package com.example.stepDef;

import utils.DriverHelper;
import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginPageStepDef {

    LoginPage loginPage;

    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        DriverHelper.getDriver().navigate().to(url);

    }

    @When("user inputs invalid credentials")
    public void user_inputs_invalid_credentials() throws InterruptedException {

        loginPage = new LoginPage(DriverHelper.getDriver());
        loginPage.loginFunctionality();
    }

    @Then("user receives an error message {string}")
    public void user_receives_an_error_message(String errorMessage) {

        Assert.assertEquals(errorMessage,loginPage.getErrorMessage());
        DriverHelper.getDriver().quit();

    }
}