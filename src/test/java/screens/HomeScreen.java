package screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.Driver;

/**
 * The Class HomeScreen.
 */
public class HomeScreen {
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(HomeScreen.class);
	
	/** The driver. */
	private WebDriver driver;
	
	/**
	 * Instantiates a new home screen.
	 */
	public HomeScreen() {
		
	        this.driver = Driver.getDriver();
	        
	        PageFactory.initElements(driver,this);
	    
	}
	
	/** The widget layout. */
	@FindBy(className = "android.widget.LinearLayout")
	private WebElement widgetLayout;
	
	/** The btn user registration. */
	@FindBy(id = "io.selendroid.testapp:id/startUserRegistration")
	private WebElement btn_UserRegistration;
	
	/** The btn start web view. */
	@FindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
	private WebElement btn_StartWebView;
	
	/** The btn show popup window. */
	@FindBy(id = "io.selendroid.testapp:id/showPopupWindowButton")
	private WebElement btn_ShowPopupWindow;
	
	/** The btn show toast. */
	@FindBy(id = "io.selendroid.testapp:id/showToastButton")
	private WebElement btn_ShowToast;
	
	/** The btn display text view. */
	@FindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
	private WebElement btn_DisplayTextView;
	
	/** The text view. */
	@FindBy(id = "io.selendroid.testapp:id/visibleTextView")
	private WebElement txt_DisplayTextView;
	
	
	/**
	 * Click on user registration.
	 *
	 * @return true, if successful
	 */
	public boolean clickOnUserRegistration() {
		if(btn_UserRegistration!=null) {
			btn_UserRegistration.click();
			return true;
		}
		return false;
	}
	
	/**
	 * Click on web view button.
	 *
	 * @return true, if successful
	 */
	public boolean clickOnWebViewButton() {
		if(btn_StartWebView!=null) {
			btn_StartWebView.click();
			return true;
		}
		return false;
	}
	
	/**
	 * Click on show toast button.
	 *
	 * @return true, if successful
	 */
	public boolean clickOnShowToastButton() {
		if(btn_ShowToast!=null) {
			btn_ShowToast.click();
			return true;
		}
		return false;
	}
	
	/**
	 * Click on display text view button.
	 *
	 * @return true, if successful
	 */
	public boolean clickOnDisplayTextViewButton() {
		if(btn_DisplayTextView!=null) {
			btn_DisplayTextView.click();
			return true;
		}
		return false;
	}
		
	/**
	 * Verify user is on home screen.
	 *
	 * @return true, if successful
	 */
	public boolean verifyUserIsOnHomeScreen() {
    	String text = widgetLayout.getText();
    	if(text.contains("Hello Default Locale, Selendroid-test-app!")) {
    		logger.info("#########  "+text+"  #######");
    		return true;
    	}
    	return false;
    }
	
	public boolean verifyTextDisplayedOnClickingDisplayTextView() {
    	String text = txt_DisplayTextView.getText();
    	if(!text.equals("")) {
    		logger.info("#########  "+text+"  #######");
    		return true;
    	}
    	return false;
    }
}
