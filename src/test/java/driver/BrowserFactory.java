package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserFactory {
	WebDriver driver;

	public BrowserFactory() {

	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver setDriver(String browser, String nodeURL) throws MalformedURLException {
		System.getProperty("java.classpath");
		new DesiredCapabilities();
		
		switch (browser.toString().toUpperCase()) {
		case "CHROME":

			ChromeOptions capc = new ChromeOptions();
			driver = new RemoteWebDriver(new URL(nodeURL), capc);
			break;
		case "FIREFOX":
			FirefoxOptions capf = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL(nodeURL), capf);

			break;
		case "OPERA":
			OperaOptions capo = new OperaOptions();
			driver = new RemoteWebDriver(new URL(nodeURL), capo);

			break;
		case "ANDROID":
			try {
					String nodeappiumURL = "http://localhost:4723/wd/hub";
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
					caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
					caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-J71MN");
					caps.setCapability(MobileCapabilityType.UDID, "52032936c0e08321");
					caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
					caps.setCapability(MobileCapabilityType.BROWSER_NAME, "CHROME");
					caps.getBrowserName();
					URL node = new URL(nodeURL);
					//driver = new RemoteWebDriver(new URL(nodeappiumURL), caps);
					driver= new AppiumDriver<MobileElement>(node, caps);
					break;
					
			}catch(Exception exp) {
				System.out.println("Cause is : "+exp.getCause());
				System.out.println("Message is : "+exp.getMessage());
				exp.printStackTrace();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;

	}

	public void removeDriver() {
		driver.close();
		driver.quit();

	}

}
