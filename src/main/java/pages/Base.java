package pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base
{


	public static WebDriver launch(String browser, boolean remote)
	{
		WebDriver driver =null;

		if(remote)
		{
			driver = launchRemoteWebDriver(browser);
		}
		else {

			switch (browser)
			{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
				break;
			default :
				WebDriverManager.chromedriver().setup();

				driver=new ChromeDriver();
				break;

			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	private static WebDriver launchRemoteWebDriver(String browser) {
		String urlAddr = "\'wd\'hub";
		URL url =null;
		try {
			url = new URL(urlAddr);
		}
		catch(MalformedURLException e)
		{
			throw new CustomeException(e);
		}

		DesiredCapabilities cap = constructDesiredCapabilities(browser);

		RemoteWebDriver driver = new RemoteWebDriver(url,cap);
		driver.setFileDetector(new LocalFileDetector());
		return driver;
	}

	private static DesiredCapabilities constructDesiredCapabilities(String browser) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browser);

		switch (TestParameters.BROWSER)
		{
		case TestParameters.FIREFOXBROWSER:
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, constructFirefoxoptions());
			break;
		case TestParameters.CHROMEBROWSER:
			cap.setCapability(ChromeOptions.CAPABILITY, constructChromeoptions());
			break;
		default :
			break;
		}
		return cap;
	}

	private static FirefoxOptions constructFirefoxoptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.dir", "testpath");
		return options;
	}
	private static ChromeOptions constructChromeoptions() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> chromeprefs =new HashMap<String, Object>() ;
		options.setExperimentalOption("prefs", chromeprefs);
		return options;
	}
	public WebDriver getDriver(String browser, boolean remote)
	{
		return launch(browser, remote);
	}
}
