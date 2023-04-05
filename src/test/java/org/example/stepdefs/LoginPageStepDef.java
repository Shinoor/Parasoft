package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.panaBank.Page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



// Hooks
   public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;
    private String expectedTitle = "Account Overview";

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if (driver!=null){
            driver.quit();

        }
    }


    @Given("I am on the ParaBank login page")
    public void i_am_on_the_para_bank_login_page() {
      driver.get("https://parabank.parasoft.com/parabank/index.htm");
      loginPage = new LoginPage(driver);
    }
    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterUsername("Ade");
        loginPage.enterPassword("Mayowa123");
    }

    @Given("I have entered invalid {string} and {string}>")
    public void i_have_entered_invalid_and(String username, String password) {
       loginPage.enterUsername(username);
       loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
     }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        //WebDriverWait WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.switchTo().window(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),expectedTitle);



    }
    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String error_message) {
        // Assert that an error message is displayed on the page
        Assert.assertEquals(driver.findElement(By.cssSelector("#rightPanel > p")).isDisplayed(), true);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String link) {
        loginPage.clickLoginButton();
    }
    @Then("I should be redirected to the Customer lookup page")
    public void i_should_be_redirected_to_the_customer_lookup_page() {  }


}
