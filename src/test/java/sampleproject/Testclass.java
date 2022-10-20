package sampleproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Base;
import pages.LoginPage;

public class Testclass extends Base{
  @Test
  @Parameters("browser")
   public void test(String browser) throws InterruptedException {
	  System.out.println("Execution after setting ChromeDriver path in System Variables");
	  WebDriver driver =getDriver(browser,false);
	  LoginPage lg = new LoginPage(driver);

		 driver.get("https://www.google.co.in/webhp");
		 Thread.sleep(3000);
		 driver.quit();
		 System.out.println("Execution complete");
 }
}
