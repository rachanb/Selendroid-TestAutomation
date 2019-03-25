package stepdefinations;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screens.HomeScreen;
import screens.UserRegistrationScreen;
import screens.WebViewScreen;


// TODO: Auto-generated Javadoc
/**
 * The Class HomeStepDefs.
 */
public class HomeStepDefs {
	
	HomeScreen homeScreen;

	/**
	 * I am on the something screen.
	 *
	 * @param appScreen the app screen
	 * @throws Throwable the throwable
	 */
	@Given("^I am on the \"([^\"]*)\" screen$")
	public void i_am_on_the_something_screen(String appScreen) throws Throwable {

		if(appScreen.equals("Selendroid Home")){
			homeScreen  = new HomeScreen();
			homeScreen.verifyUserIsOnHomeScreen();
		}
		else if(appScreen.equalsIgnoreCase("User Registration")) {
			UserRegistrationScreen userRegistrationScreen = new UserRegistrationScreen();
			userRegistrationScreen.verifyRegisterUserScreen();
		}
		else if(appScreen.equalsIgnoreCase("web View")) {
			WebViewScreen webViewScreen = new WebViewScreen();
			webViewScreen.verifyWebViewScreen();
		}
	}
	
	/**
	 * I click on something button on home screen.
	 *
	 * @param button the button
	 * @throws Throwable the throwable
	 */
	@When("^I click on \"([^\"]*)\" button on Home Screen$")
	public void i_click_on_something_button_on_home_screen(String button) throws Throwable {
		homeScreen = new HomeScreen();
		if(button.equals("User Registration")) {
			homeScreen.clickOnUserRegistration();
		}
		else if(button.equals("Start Web View")) {
			homeScreen.clickOnWebViewButton();
		}
		else if(button.equals("Display Text View")) {
			homeScreen.clickOnDisplayTextViewButton();
		}
	}
	
	/**
	 * I land on the something screen.
	 *
	 * @param appScreen the app screen
	 * @throws Throwable the throwable
	 */
	@Then("^I land on the \"([^\"]*)\" screen$")
	public void i_land_on_the_something_screen(String appScreen) throws Throwable {

		if(appScreen.equals("Selendroid Home")){
			homeScreen  = new HomeScreen();
			Assert.assertTrue(homeScreen.verifyUserIsOnHomeScreen());
		}
		else if(appScreen.equalsIgnoreCase("User Registration")) {
			UserRegistrationScreen userRegistrationScreen = new UserRegistrationScreen();
			Assert.assertTrue(userRegistrationScreen.verifyRegisterUserScreen());
		}
		else if(appScreen.equalsIgnoreCase("Web View")) {
			WebViewScreen webViewScreen = new WebViewScreen();
			Assert.assertTrue(webViewScreen.verifyWebViewScreen());
		}
	}
	
	@Then("^I get to see the text on screen$")
    public void i_get_to_see_the_text_on_screen() throws Throwable {
		Assert.assertTrue(homeScreen.verifyTextDisplayedOnClickingDisplayTextView());
    }

}