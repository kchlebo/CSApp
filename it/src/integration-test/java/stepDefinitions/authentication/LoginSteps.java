package stepDefinitions.authentication;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cornerstone.framework.BrowserFactory;
import com.cornerstone.pageObjects.HomePage;
import com.cornerstone.pageObjects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginSteps {
	WebDriver driver;
	LoginPage loginPage;
	
	
	
	@Given("^user opens a browser$")
	public void user_opens_a_browser() {
		driver = BrowserFactory.getBrowser();
	}
	
	@When("^user enters the Cornerstone webapplication url$")
	public void user_enters_the_Cornerstone_webapplication_url() {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.openURL();
	}
	
	@Then("^user should be navigated to the login page$")
	public void user_should_be_navigated_to_the_login_page()
	{
		 assertEquals(loginPage.getLoginAsGuestButton().isDisplayed(), true);
	}
	
	

	@When("^user clicks on the Login as Guest button$")
	public void user_clicks_on_the_Login_as_Guest_button() {
		   loginPage.clickLoginAsGuestButton();
	}

	
	@Given("^user has entered (.*) username$")
	public void user_has_entered_some_username(String someUserName){
		loginPage.enterUsername(someUserName);
	}
	
	@And("^user has entered (.*) password$")
	public void user_has_entered_some_password(String somePassword){
		loginPage.enterPassword(somePassword);;
	}
	
	@When("^user clicks on the Login button$")
	public void user_clicks_on_the_Login_button() {
		   loginPage.clickLoginButton();;
	}
	
	@Then("^user (.*) be navigated to the homepage$")
	public void user_maybe_be_navigated_to_the_homepage(String maybe)
	{
		boolean isHomepageDisplayed = PageFactory.initElements(driver, HomePage.class).getMainBody().isDisplayed();
		if(maybe.equals("should")) assertEquals(isHomepageDisplayed, true); 
		else assertEquals(isHomepageDisplayed, false);

	}
	
}
