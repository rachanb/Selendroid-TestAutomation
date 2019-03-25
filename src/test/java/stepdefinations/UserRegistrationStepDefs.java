package stepdefinations;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screens.UserRegistrationScreen;
import screens.VerifyUserRegistrationScreen;
import cucumber.api.java.en.And;

import org.testng.Assert;

/**
 * The Class UserRegistrationStepDefs.
 */
public class UserRegistrationStepDefs {
	
	/** The user registration screen. */
	UserRegistrationScreen userRegistrationScreen;

	public UserRegistrationStepDefs() {
		userRegistrationScreen = new UserRegistrationScreen();
	}

	
	/**
	 * I fill all the details.
	 *
	 * @param username the username
	 * @param email the email
	 * @param password the password
	 * @param name the name
	 * @param language the language
	 * @param termcondition the termcondition
	 * @throws Throwable the throwable
	 */
	@When("^I fill all the details (.+) (.+) (.+) (.+) (.+) (.+)$")
	public void i_fill_all_the_details(String username, String email, String password, String name, String language, String termcondition) throws Throwable {

		userRegistrationScreen.enterAllFormDetails(username,email,password,name,language,termcondition);
		
	}

    /**
     * I click on something button on register new user screen.
     *
     * @param strArg1 the str arg 1
     * @throws Throwable the throwable
     */
    @And("^I click on \"([^\"]*)\" button on Register New User screen$")
    public void i_click_on_something_button_on_register_new_user_screen(String strArg1) throws Throwable {
        
    	userRegistrationScreen.clickOnRegisterUserButton();
    }

    /**
     * I validate user for.
     *
     * @param username the username
     * @param email the email
     * @param password the password
     * @param name the name
     * @param language the language
     * @param termcondition the termcondition
     * @throws Throwable the throwable
     */
    @Then("^I validate user for (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void i_validate_user_for(String username, String email, String password, String name, String language, String termcondition) throws Throwable {
    	
    	VerifyUserRegistrationScreen verifyUserRegistrationScreen = new VerifyUserRegistrationScreen();
    	Assert.assertEquals(verifyUserRegistrationScreen.validateUserDetails(username, email, password, name, language, termcondition),"");
    }								
}