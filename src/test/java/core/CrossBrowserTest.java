package core;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CrossBrowserTest extends  CrossBrowser{



	    @Test
	    public void test()  throws IOException {

	        //  System.out.println(browser);}  // Firefox

	        //   "testpath"   =  /Users/anna/Desktop/kohls_api.propertie

	     String browser = System.getProperty("browser");

	  // String browser = "Firefox"; // Firefox or Chrome or Safari   HtmlUnit,  or IE or Edge  mvn test -Dbrowser="Firefox"
	        //System.out.println("from -D: " + browser);
// /CrossBrowser2017/resources/webdrivers/mac/chromedriver
	        setWebDriver(browser); //in_browser);

	    String url = "https://www.potterybarnkids.com/account/login.html";

	   driver.get(url);

	    String title = driver.getTitle();

	    System.out.println("Title of page is: " + title);



	    if (driver != null)

	    {driver.quit();}

	}

	}
