package stepdefinations;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screens.UserRegisterationScreen;
import screens.VerifyUserRegistrationScreen;
import cucumber.api.java.en.And;

import org.testng.Assert;

public class UserRegistrationStepDefs {
	
	UserRegisterationScreen userRegistrationScreen;
	
	public UserRegistrationStepDefs() {
		userRegistrationScreen = new UserRegisterationScreen();
	}

	
	@When("^I fill all the details (.+) (.+) (.+) (.+) (.+) (.+)$")
	public void i_fill_all_the_details(String username, String email, String password, String name, String language, String termcondition) throws Throwable {

		userRegistrationScreen.enterAllFormDetails(username,email,password,name,language,termcondition);
		
	}

    @And("^I click on \"([^\"]*)\" button on Register New User screen$")
    public void i_click_on_something_button_on_register_new_user_screen(String strArg1) throws Throwable {
        
    	userRegistrationScreen.clickOnRegisterUserButton();
    }

    @Then("^I validate user for (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void i_validate_user_for(String username, String email, String password, String name, String language, String termcondition) throws Throwable {
    	
    	VerifyUserRegistrationScreen verifyUserRegistrationScreen = new VerifyUserRegistrationScreen();
    	Assert.assertEquals(verifyUserRegistrationScreen.validateUserDetails(username, email, password, name, language, termcondition),"");
    }								
}