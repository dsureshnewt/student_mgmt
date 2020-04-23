package config;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StudentIntegrationTest extends AppTest {
	
	public static final String USERNAME = "sso-aa-Muthuselvan.Sankaravel";
	public static final String ACCESS_KEY = "cf09c4aa-ea08-4d94-b21d-ead4ecaec7ef";
	public static final String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";
	
	public static WebDriver driver = null;
	
	@BeforeClass
	public static void setup() throws MalformedURLException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Windows 10");
	    //caps.setCapability("platform", "Linux");
	    //caps.setCapability("platform", "macOS 10.13");
	    caps.setCapability("version", "latest");
	    //caps.setCapability("name", "Test1");
	    //caps.setCapability("extendedDebugging", "true");
	    //caps.setCapability("buildNumber", "3.0");
	    driver = new RemoteWebDriver(new URL(URL), caps);
	}
	
	@Test
	public void shouldLoadWebpage() {
		System.out.println("Happy");
		//driver.navigate().to("https://newtglobal.com/");
		driver.get("https://newtglobal.com/");
		String title = driver.getTitle();
		System.out.println(title);
		assertTrue(title.contains("Newt Global"));
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
