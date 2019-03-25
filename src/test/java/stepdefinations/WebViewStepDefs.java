package stepdefinations;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screens.WebViewScreen;

public class WebViewStepDefs {

	WebViewScreen webViewScreen;
	
	@When("^I click on \"([^\"]*)\" button on Web View$")
    public void i_click_on_something_button_on_web_view(String strArg1) throws Throwable {
        webViewScreen = new WebViewScreen();
        webViewScreen.clickOnSayHelloDropDown();
    }

	@Then("^I land on the \"([^\"]*)\" pop on Web View$")
    public void i_land_on_the_something_pop_on_web_view(String strArg1) throws Throwable {
		 webViewScreen = new WebViewScreen();
		 Assert.assertTrue(webViewScreen.verifyWebdriverTestFilePopupDisplayed());
    }

}
