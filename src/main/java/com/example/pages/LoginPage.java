package com.example.pages;

import utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

   WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement searchButton;

//    @FindBy(xpath = "//div[@id=\"srp-river-results\"]//li//a")
//    private List<WebElement> elements;

    @FindBy(xpath = "/html/body/div[5]/div[4]/div[3]/div[1]/div[3]/ul/li")
    private List<WebElement> elements;



    public void searchFunctionality(String text) throws InterruptedException {
        searchBox.sendKeys(text);


    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public List<WebElement> getElements() {
        return elements;
    }
}
