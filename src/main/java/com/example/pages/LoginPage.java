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

public class LoginPage {

   WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "email")
    private WebElement emailInputBox;


    @FindBy(name = "password")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained WithStyles(ForwardRef(Button))-root-38 MuiButton-containedPrimary\"]")
    private WebElement signInButton;
    @FindBy(xpath = "//*[@class=\"Toastify__toast Toastify__toast--error\"]")
    private WebElement errorMessage;



    public void loginFunctionality() throws InterruptedException {

        emailInputBox.sendKeys("hello@gmail.com");
        passwordInputBox.sendKeys("12345678");


        //To be removed
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .pollingEvery(Duration.ofSeconds(2))
//                        .withMessage("Sign In button")
//                                .withTimeout(Duration.ofSeconds(10))
//                                        .ignoring(Exception.class);
//        wait.until(mydriver->signInButton);
//        Actions actions = new Actions(driver);
//        actions.click(signInButton).perform();

        Thread.sleep(5000);
        signInButton.click();
    }

    public String getErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));

        return errorMessage.getText();
    }
}
