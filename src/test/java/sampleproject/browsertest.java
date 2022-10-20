package sampleproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browsertest {

	public static void main(String[] args) throws InterruptedException{
		 
		 System.out.println("Execution after setting ChromeDriver path in System Variables");
		
		WebDriverManager.chromedriver().setup();
	 
		 WebDriver driver=new ChromeDriver();
	
		 
		 driver.get("https://www.google.co.in/webhp");
		 Thread.sleep(3000);
		 driver.quit();
		 System.out.println("Execution complete");
		 
		 }

}

