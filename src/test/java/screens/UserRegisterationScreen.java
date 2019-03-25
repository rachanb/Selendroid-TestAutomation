package screens;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class UserRegisterationScreen {
	
	final static Logger logger = Logger.getLogger(UserRegisterationScreen.class);
	
	private WebDriver driver;
	
	public UserRegisterationScreen() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(id = "android:id/content")
	private WebElement widgetLayout;
	
    @FindBy(id = "io.selendroid.testapp:id/inputUsername")
    private WebElement txtbox_username;
    
    @FindBy(id = "io.selendroid.testapp:id/inputEmail")
    private WebElement txtbox_email;
    
    @FindBy(id = "io.selendroid.testapp:id/inputPassword")
    private WebElement txtbox_password;
    
    @FindBy(id = "io.selendroid.testapp:id/inputName")
    private WebElement txtbox_name;
    
    @FindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
    private WebElement dropdown_programmingLang;
    
    @FindBy(id = "io.selendroid.testapp:id/input_adds")
    private WebElement chkbox_acceptAdds;
    
    @FindBy(id = "io.selendroid.testapp:id/btnRegisterUser")	
    private WebElement btn_RegisterUser;
    
    
    public boolean verifyRegisterUserScreen() {
    	
    	String text = widgetLayout.getText();    	
    	if(text.contains("Welcome to register a new User")) {
    		logger.info("$$$$$$$$$ "+text+"   $$$$$$$$$$$$$");
    		return true;
    	}
    	return false;
    }
    
 
	public boolean clickOnRegisterUserButton() {
		if(btn_RegisterUser!=null) {
			btn_RegisterUser.click();
			return true;
		}
		return false;
	}


	public void enterAllFormDetails(String username, String email, String password, String name, String language, String termcondition) throws InterruptedException {
		Thread.sleep(2000);
		txtbox_username.click();
		txtbox_username.sendKeys(username);
		
		txtbox_email.click();
		txtbox_email.sendKeys(email);
		
		txtbox_password.click();
		txtbox_password.sendKeys(password);
		
		txtbox_name.clear();
		txtbox_name.sendKeys(name);
		
		dropdown_programmingLang.click();
		List<WebElement> list_Language = Driver.getDriver().findElements(By.id("android:id/text1"));
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
		//clickOnRegisterUserButton();	
	}

}
