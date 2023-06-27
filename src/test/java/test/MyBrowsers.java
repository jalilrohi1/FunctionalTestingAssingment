package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyBrowsers {
	
	public enum Browsers {
		CHROME,
		FIREFOX
		,EDGE
	}

	public static WebDriver getBrowser( final Browsers driver ) {
		// add default options
		switch ( driver ) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver();
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				return new FirefoxDriver();
			case EDGE:
				WebDriverManager.edgedriver().setup();
				return new EdgeDriver();
			default:
				throw new IllegalArgumentException( "No '" + driver + "' driver available." );
		}
	}



}
