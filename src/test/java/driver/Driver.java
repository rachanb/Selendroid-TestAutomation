package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

//@RunWith(Cucumber.class)
@CucumberOptions(
      	strict = true,
      	monochrome = true,
      	features = {"src/test/resources/features"},
      	glue= {"stepdefinations"},
      	plugin = {"pretty", "html:target/cucumber-html-report" }
        )

public class Driver extends AbstractTestNGCucumberTests{

	static AppiumDriverLocalService appiumDriverLocalService;
	static Properties properties;
	
	static String appiumServerURl;
	static String platform;
	static String deviceName;
	static String applicationLocation;
	
	static WebDriver driver;

	@BeforeSuite
	public void setup() {
		
		sartAppiumServer();
		initProperties();
		invokeDriver();
	}

	public void sartAppiumServer() {

		appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
		appiumDriverLocalService.start();

	}
	
	public void stopAppiumServer() {
		appiumDriverLocalService.stop();
	}

	private WebDriver invokeDriver() {

		DesiredCapabilities capabilities =  new DesiredCapabilities();
		driver=null;

		try {

			if(platform.equalsIgnoreCase("android")) {

				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				capabilities.setCapability(MobileCapabilityType.APP, new File(applicationLocation).getAbsolutePath());
				capabilities.setCapability("unicodeKeyboard", true);
				capabilities.setCapability("resetKeyboard", true);
				capabilities.setCapability("autoGrantPermissions",true);
				driver = new AndroidDriver<>(new URL(appiumServerURl), capabilities);

			} else if(platform.equalsIgnoreCase("ios")) {

				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				capabilities.setCapability(MobileCapabilityType.APP, new File(applicationLocation).getAbsolutePath());
				driver = new IOSDriver<>(new URL(appiumServerURl), capabilities);
			}

		}
		catch(Exception e) {
			System.out.println("In Exception--"+e);
		}
		return driver;
	}

	public static WebDriver getDriver () {
		return driver;
	}


	public void initProperties(){


		properties = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src\\test\\resources\\config\\automation-config.properties");

			// load a properties file
			properties.load(input);

			appiumServerURl = properties.getProperty("APPIUM.SERVER.URL");
			platform = properties.getProperty("PLATFORM.NAME");
			deviceName = properties.getProperty("DEVICE.NAME");
			applicationLocation = properties.getProperty("APPLICATION.PATH");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@AfterSuite
	public void tearDown() {
		stopAppiumServer();
	}
}
