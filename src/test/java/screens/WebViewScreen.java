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
public class WebViewScreen {
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(WebViewScreen.class);
	
	/** The driver. */
	private WebDriver driver;
	
	/**
	 * Instantiates a new user registration screen.
	 */
	public WebViewScreen() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}


	
	/** The widget layout. */
	@FindBy(id = "io.selendroid.testapp:id/tableHeader")
	private WebElement widgetLayout;
	
	@FindBy(id = "io.selendroid.testapp:id/spinner_webdriver_test_data")
	private WebElement dropdown_SayHello;
	
	
	@FindBy(id = "android:id/alertTitle")
	private WebElement popup_WebdriverTemplateFile;
	
	
    
    /**
     * Verify register user screen.
     *
     * @return true, if successful
     */
    public boolean verifyWebViewScreen() {
    	
    	String text = driver.getPageSource();    	
    	if(text.contains("Web View Interaction")) {
    		//logger.info("$$$$$$$$$ "+text+"   $$$$$$$$$$$$$");
    		return true;
    	}
    	return false;
    }   
 
	
	public boolean clickOnSayHelloDropDown() {
		if(dropdown_SayHello!=null) {
			dropdown_SayHello.click();
			return true;
		}
		return false;
	}
	
	public boolean verifyWebdriverTestFilePopupDisplayed() {
		if(popup_WebdriverTemplateFile!=null) {
			String title = popup_WebdriverTemplateFile.getText();
			if(title.equals("Webdriver Test File")) {
	    		logger.info("$$$$$$$$$ "+title+"   $$$$$$$$$$$$$");
	    		return true;
	    	}	    	
		}
		return false;
	}


	

}
