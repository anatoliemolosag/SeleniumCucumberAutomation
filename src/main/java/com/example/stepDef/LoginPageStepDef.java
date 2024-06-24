package com.example.stepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utils.DriverHelper;
import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class LoginPageStepDef {

    LoginPage loginPage;

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        DriverHelper.getDriver().get(url);
    }
    @When("User inputs {string}  text in search box")
    public void user_inputs_text_in_search_box(String text) throws InterruptedException {

        loginPage = new LoginPage(DriverHelper.getDriver());
        loginPage.searchFunctionality(text);
        loginPage.clickSearchButton();

    }
    @Then("All items cointains {string} text")
    public void all_items_cointains_text(String text) {

        List<String> allItems = new ArrayList<>();
        SoftAssert softAssert = new SoftAssert();

        for (WebElement element : loginPage.getElements()){
            allItems.add(element.getText());
        }

        for (String ele : allItems){
            softAssert.assertEquals(ele.contains(text),true, "element does not contain " +
                     text + ", actual element is " + ele);
        }
        softAssert.assertAll();
        DriverHelper.getDriver().quit();

    }

    @When("User inputs {string} in search box")
    public void user_inputs_in_search_box(String text) throws InterruptedException {
        loginPage = new LoginPage(DriverHelper.getDriver());
        loginPage.searchFunctionality(text);

    }
    @When("User clicks search buttom")
    public void user_clicks_search_buttom() {

        loginPage.clickSearchButton();

    }
    @Then("the page title should be {string}")
    public void the_page_title_should_be(String title) {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getTitle(),title);
        softAssert.assertAll();
        DriverHelper.getDriver().quit();

    }


}