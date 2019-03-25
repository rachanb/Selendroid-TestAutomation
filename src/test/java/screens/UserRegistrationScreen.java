package screens;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.Driver;


/**
 * The Class UserRegisterationScreen.
 */
public class UserRegistrationScreen {
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(UserRegistrationScreen.class);
	
	/** The driver. */
	private WebDriver driver;
	
	/**
	 * Instantiates a new user registration screen.
	 */
	public UserRegistrationScreen() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}


	
	/** The widget layout. */
	@FindBy(id = "android:id/content")
	private WebElement widgetLayout;
	
    /** The txtbox username. */
    @FindBy(id = "io.selendroid.testapp:id/inputUsername")
    private WebElement txtbox_username;
    
    /** The txtbox email. */
    @FindBy(id = "io.selendroid.testapp:id/inputEmail")
    private WebElement txtbox_email;
    
    /** The txtbox password. */
    @FindBy(id = "io.selendroid.testapp:id/inputPassword")
    private WebElement txtbox_password;
    
    /** The txtbox name. */
    @FindBy(id = "io.selendroid.testapp:id/inputName")
    private WebElement txtbox_name;
    
    /** The dropdown programming lang. */
    @FindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
    private WebElement dropdown_programmingLang;
    
    /** The chkbox accept adds. */
    @FindBy(id = "io.selendroid.testapp:id/input_adds")
    private WebElement chkbox_acceptAdds;
    
    /** The btn register user. */
    @FindBy(id = "io.selendroid.testapp:id/btnRegisterUser")	
    private WebElement btn_RegisterUser;
    
    
    /**
     * Verify register user screen.
     *
     * @return true, if successful
     */
    public boolean verifyRegisterUserScreen() {
    	String text = driver.getPageSource();	
    	if(text.contains("Welcome to register a new User")) {
    		logger.info("$$$$$$$$$ "+text+"   $$$$$$$$$$$$$");
    		return true;
    	}
    	return false;
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


	/**
	 * Enter all form details.
	 *
	 * @param username the username
	 * @param email the email
	 * @param password the password
	 * @param name the name
	 * @param language the language
	 * @param termcondition the termcondition
	 * @throws InterruptedException the interrupted exception
	 */
	public void enterAllFormDetails(String username, String email, String password, String name, String language, String termcondition) throws InterruptedException {
		
		txtbox_username.click();
		txtbox_username.sendKeys(username);
		
		//txtbox_email.click();
		txtbox_email.sendKeys(email);
		
		txtbox_password.click();
		txtbox_password.sendKeys(password);
		
		txtbox_name.clear();
		txtbox_name.sendKeys(name);
		
		dropdown_programmingLang.click();
		List<WebElement> list_Language = driver.findElements(By.id("android:id/text1"));
		for(WebElement element : list_Language) {
			System.out.println(element.getText());
			if(element.getText().equals(language)){
				element.click();
				break;
			}
		}
		if(termcondition.equalsIgnoreCase("yes")) {
			chkbox_acceptAdds.click();
		}
	}

}
