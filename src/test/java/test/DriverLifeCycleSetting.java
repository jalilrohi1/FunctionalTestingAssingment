package test;

import java.time.Duration;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.MyBrowsers.Browsers;






public class DriverLifeCycleSetting {

	protected WebDriver driver; 
	


	@BeforeAll

	public static void beforeAll() {
		//WebDriverManager.chromedriver().setup();
	}
	@ParameterizedTest
	@EnumSource(Browsers.class)
	@BeforeEach
	public void beforeEach(Browsers browser) 
	{
		//driver = new ChromeDriver();
		driver=MyBrowsers.getBrowser(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterEach
	public void afterEach() {
		if (driver != null) {
			driver.quit();
		}
	}
}
