package stepdefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screens.HomeScreen;
import screens.UserRegisterationScreen;


public class HomeStepDefs {

	@Given("^I am on the \"([^\"]*)\" screen$")
	public void i_am_on_the_something_screen(String appScreen) throws Throwable {

		if(appScreen.equals("Selendroid Home")){
			HomeScreen homeScreen  = new HomeScreen();
			homeScreen.verifyUserIsOnHomeScreen();
		}
		else if(appScreen.equalsIgnoreCase("User Registration")) {
			UserRegisterationScreen userRegistrationScreen = new UserRegisterationScreen();
			userRegistrationScreen.verifyRegisterUserScreen();
		}
	}
	
	@When("^I click on \"([^\"]*)\" button on Home Screen$")
	public void i_click_on_something_button_on_home_screen(String button) throws Throwable {
		HomeScreen homeScreen = new HomeScreen();
		if(button.equals("User Registration")) {
			homeScreen.clickOnUserRegistration();
		}
	}
	
	@Then("^I land on the \"([^\"]*)\" screen$")
	public void i_land_on_the_something_screen(String appScreen) throws Throwable {

		if(appScreen.equals("Selendroid Home")){
			HomeScreen homeScreen  = new HomeScreen();
			homeScreen.verifyUserIsOnHomeScreen();
		}
		else if(appScreen.equalsIgnoreCase("User Registration")) {
			UserRegisterationScreen userRegistrationScreen = new UserRegisterationScreen();
			userRegistrationScreen.verifyRegisterUserScreen();
		}
	}

}