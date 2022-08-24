package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
		case "ANCHROME":
			try {
				UiAutomator2Options options = new UiAutomator2Options()
				.setPlatformName("Android")
				.setDeviceName("SM-J71MN")//"emulator-5554"//"SM-J71MN"
				.setAdbExecTimeout(Duration.ofSeconds(150))
				.setAutomationName("UiAutomator2")
				//.setAppPackage("com.android.chrome")
				//.setAppActivity("com.google.android.apps.chrome.Main")
				.setNewCommandTimeout(Duration.ofSeconds(60))
				
				.setChromedriverExecutable("/home/WebDriver/chromedriver")
				.setChromedriverUseSystemExecutable(true)
				//.setUnlockKey("1526")
				.setUdid("52032936c0e08321")
				.setPlatformVersion("8.1.0");//"8.1.0"//11
				ChromeOptions opt=new ChromeOptions();
				options.setCapability(ChromeOptions.CAPABILITY, opt);
				
				driver = new AndroidDriver(new URL(nodeURL),options);
					break;
					
			}catch(Exception exp) {
				System.out.println("Cause is : "+exp.getCause());
				System.out.println("Message is : "+exp.getMessage());
				exp.printStackTrace();
			}
		}
		if(browser!="ANDROID") {
		driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		return driver;

	}

	public void removeDriver() {
		//driver.close();
		driver.quit();

	}

}
