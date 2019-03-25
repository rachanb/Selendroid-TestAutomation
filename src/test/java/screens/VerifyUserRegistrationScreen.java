package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.Driver;


/**
 * The Class VerifyUserRegistrationScreen.
 */
public class VerifyUserRegistrationScreen {

/** The driver. */
private WebDriver driver;
	
	/**
	 * Instantiates a new verify user registration screen.
	 */
	public VerifyUserRegistrationScreen() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	/** The label name data. */
	@FindBy(id = "io.selendroid.testapp:id/label_name_data")
	private WebElement label_name_data;
	
	/** The label user name data. */
	@FindBy(id = "io.selendroid.testapp:id/label_username_data")
	private WebElement label_userName_data;
	
	/** The label password data. */
	@FindBy(id = "io.selendroid.testapp:id/label_password_data")
	private WebElement label_password_data;
	
	/** The label email data. */
	@FindBy(id = "io.selendroid.testapp:id/label_email_data")
	private WebElement label_email_data;
	
	/** The label programming lang data. */
	@FindBy(id = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
	private WebElement label_programmingLang_data;
	
	/** The label accepts adds data. */
	@FindBy(id = "io.selendroid.testapp:id/label_acceptAdds_data")
	private WebElement label_acceptsAdds_data;
	
	/** The btn register user. */
	@FindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
	private WebElement btn_RegisterUser;
	
	

	/**
	 * Validate user details.
	 *
	 * @param username the username
	 * @param email the email
	 * @param password the password
	 * @param name the name
	 * @param language the language
	 * @param termcondition the termcondition
	 * @return the string
	 */
	public String validateUserDetails(String username, String email, String password, String name, String language, String termcondition) {
		
		String message = "";
		
		String actualName = label_name_data.getText();
		if(!actualName.equals(name)) {
			message = message+" ACTUAL Name: "+name;
		}
		String actualUserName = label_userName_data.getText();
		if(!actualUserName.equals(username)) {
			message = message+" ACTUAL UserName: "+actualUserName;
		}
		String actualPassword = label_password_data.getText();
		if(!actualPassword.equals(password)) {
			message = message+" ACTUAL Password: "+actualPassword;
		}
		String actualEmail = label_email_data.getText();
		if(!actualEmail.equals(email)) {
			message = message+ " ACTUAL Email: "+actualEmail;
		}
		String actualProgrammingLang = label_programmingLang_data.getText();
		if(!actualProgrammingLang.equals(language)) {
			message = message+" ACTUAL Programming Language: "+actualProgrammingLang;
		}
		String actualAcceptAddsStatus = label_acceptsAdds_data.getText();
		if(termcondition.equalsIgnoreCase("yes")) {
			if(!actualAcceptAddsStatus.equals("true")) {
				message = message+" ACTUAL Accept Adds Status: "+actualAcceptAddsStatus;
			}
		}
		else {
			if(!actualAcceptAddsStatus.equals("false")) {
				message = message+" ACTUAL Accept Adds Status: "+actualAcceptAddsStatus;
			}
		}
		
		clickOnRegisterUserButton();

		return message;	
		
	}
	
	/**
	 * Click on register user button.
	 *
	 * @return true, if successful
	 */
	public boolean clickOnRegisterUserButton() {
		if(btn_RegisterUser!=null) {
			btn_RegisterUser.click();
			return true;
		}
		return false;
	}
	
	
}
