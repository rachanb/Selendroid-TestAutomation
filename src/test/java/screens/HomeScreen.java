package screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.Driver;


public class HomeScreen {
	
	final static Logger logger = Logger.getLogger(HomeScreen.class);
	
	private WebDriver driver;
	public HomeScreen() {
		
	        this.driver = Driver.getDriver();
	        
	        PageFactory.initElements(driver,this);
	    
	}
	
	@FindBy(className = "android.widget.LinearLayout")
	private WebElement widgetLayout;
	
	@FindBy(id = "io.selendroid.testapp:id/startUserRegistration")
	private WebElement btn_UserRegistration;
	
	@FindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
	private WebElement btn_StartWebView;
	
	@FindBy(id = "io.selendroid.testapp:id/showPopupWindowButton")
	private WebElement btn_ShowPopupWindow;
	
	@FindBy(id = "io.selendroid.testapp:id/showToastButton")
	private WebElement btn_ShowToast;
	
	@FindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
	private WebElement btn_DisplayTextView;
	
	public boolean clickOnUserRegistration() {
		if(btn_UserRegistration!=null) {
			btn_UserRegistration.click();
			return true;
		}
		return false;
	}
	
	public boolean clickOnWebViewButton() {
		if(btn_StartWebView!=null) {
			btn_StartWebView.click();
			return true;
		}
		return false;
	}
	
	public boolean clickOnShowToastButton() {
		if(btn_ShowToast!=null) {
			btn_ShowToast.click();
			return true;
		}
		return false;
	}
	
	public boolean clickOnDisplayTextViewButton() {
		if(btn_DisplayTextView!=null) {
			btn_DisplayTextView.click();
			return true;
		}
		return false;
	}
		
	public boolean verifyUserIsOnHomeScreen() {
    	String text = widgetLayout.getText();
    	if(text.contains("Hello Default Locale, Selendroid-test-app!")) {
    		logger.info("#########  "+text+"  #######");
    		return true;
    	}
    	return false;
    }
}
