package org.example.panaBank.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //By Locators
    private  By userInputLocator= By.name("username");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.className("button");
    private By forgottenPasswordLocator = By.linkText("forgot login info?");
   // private  By registerLocator = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
    private By logoutLinkLocator = By.cssSelector("#leftPanel > ul > li:nth-child(8) > a");
    private String logout ="logout";


    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;

    }

    // Page methods-Actions
    public void enterUsername(String username){
       WebElement usernameInput = driver.findElement(userInputLocator);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }
    public void clickForgottenPasswordLocator(){
        WebElement forgottenPassword = driver.findElement(forgottenPasswordLocator);
        forgottenPassword.click();
    }
    public boolean checkForgottenPwdLink(){
        return driver.findElement(forgottenPasswordLocator).isDisplayed();
    }
    public String checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).getAttribute(logout);
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    public String getForgottenPwdPageUrl(){
        String forgotPwdUrl = driver.getCurrentUrl();
        return forgotPwdUrl;
    }
}
