package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


import cucumber.api.CucumberOptions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * The Class Driver.
 */
@CucumberOptions(
      	strict = true,
      	monochrome = true,
      	features = {"src/test/resources/features"},
      	glue= {"stepdefinations"},
      	plugin = {"pretty", "html:target/cucumber-report" }
        )

public class Driver extends AbstractTestNGCucumberTests{
	
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(Driver.class);

	/** The appium driver local service. */
	static AppiumDriverLocalService appiumDriverLocalService;
	
	/** The properties. */
	static Properties properties;
	
	/** The appium server U rl. */
	static String appiumServerURl;
	
	/** The platform. */
	static String platform;
	
	/** The device name. */
	static String deviceName;
	
	/** The application location. */
	static String applicationLocation;
	
	/** The driver. */
	static WebDriver driver;

	/**
	 * Setup.
	 */
	@BeforeSuite
	public void setup() {
		logger.info("--- SETUP -- ");
		sartAppiumServer();
		initProperties();
		invokeDriver();
	}

	/**
	 * Sart appium server.
	 */
	public void sartAppiumServer() {

		logger.info("--- STARTING APPIUM SERVER -- ");
		
		appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
		appiumDriverLocalService.start();

	}
	
	/**
	 * Stop appium server.
	 */
	public void stopAppiumServer() {
		logger.info("--- STOPPING APPIUM SERVER -- ");
		appiumDriverLocalService.stop();
	}

	/**
	 * Invoke driver.
	 *
	 * @return the web driver
	 */
	private WebDriver invokeDriver() {

		DesiredCapabilities capabilities =  new DesiredCapabilities();
		driver=null;
		
		logger.info("--- INVOKING DRIVER -- ");

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
			logger.error("Into Exception, Unable to initialize the driver -- "+e);
		}
		return driver;
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver () {
		return driver;
	}


	/**
	 * Inits the properties.
	 */
	public void initProperties(){

		logger.info("--- INITIALIZING PROPERTIES -- ");
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

		} catch (IOException e) {
			logger.error("Into Exception -- "+e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("Into Exception -- "+e);
				}
			}
		}

	}

	/**
	 * Tear down.
	 */
	@AfterSuite
	public void tearDown() {
		logger.info("--- TEAR DOWN -- ");
		stopAppiumServer();
	}
}
