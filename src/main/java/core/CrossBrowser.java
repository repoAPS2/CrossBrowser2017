package core;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CrossBrowser {
	


	   WebDriver driver;
	  
	  public  void setWebDriver (String  browser ) throws IOException       //  String  browser
	  //  public  void setWebDriver () throws IOException
	    {

	        Logger logger = Logger.getLogger("");
	        logger.setLevel(Level.OFF);
	        String driverPath ="";
	                                       String osname = System.getProperty("os.name");
	                                     // String browser = System.getProperty("browser");

	                                       
	      System.out.println("os.name = " + osname + "; browser = " + browser);

	        if (( browser.equals("Firefox"))   && (System.getProperty("os.name").toUpperCase().contains("MAC")))  {
	               driverPath = "./resources/webdrivers/mac/geckodriver";
	        	// /CrossBrowser2017/resources/webdrivers/mac/geckodriver.sh
	             //   driverPath = "./resources/webdrivers/mac/geckodriver.sh";
	        System.out.println("identified driver = " + driverPath);}

	        else  if (( browser.equals("Firefox"))  &&   (System.getProperty("os.name").toUpperCase().contains("WINDOWS")))  {
	                 driverPath = "./resources/webdrivers/pc/geckodriver.exe";    }

	        else if  ((browser .equals("Chrome")) && (System.getProperty("os.name").toUpperCase().contains("MAC")) ) {
	        		 driverPath = "./resources/webdrivers/mac/chromedriver";
	        		 
	                 System.out.println("identified driver = " + driverPath);
	                }
	        else if  ((browser .equals("Chrome")) && (System.getProperty("os.name").toUpperCase().contains("LINUX")) ) {
       		 driverPath = "./resources/webdrivers/lnx/chromedriver";
       		
                System.out.println("identified driver = " + driverPath);
               }

	        else if  ((browser.equals("Chrome"))&& (System.getProperty("os.name").toUpperCase().contains("WINDOWS")))   {
	                  driverPath = "./resources/webdrivers/pc/chromedriver.exe"; }


	                      else  { throw new IllegalArgumentException("Unknown OS");}

           switch (browser) {


	            case "Firefox": 
	            	
	            System.setProperty("webdriver.gecko.driver", driverPath);
	            
	            String binaryPath = "/Applications/Firefox55.0.3.app/Contents/MacOS/firefox-bin";
	        //    /Applications/Firefox55.0.3.app/Contents/MacOS/firefox-bin
	            FirefoxOptions options = new FirefoxOptions();
	            options.setBinary(binaryPath); //This is the location where you have installed Firefox on your machine
	            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	               capabilities.setCapability("moz:firefoxOptions", options);
	               capabilities.setCapability(FirefoxDriver.MARIONETTE, true);

	               driver = new FirefoxDriver(capabilities);
	               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	               driver.manage().window().maximize();
	            
//                driver = new FirefoxDriver();
//                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//                driver.manage().window().maximize();
	                break;

	            case  "Chrome":

	                System.setProperty("webdriver.chrome.driver", driverPath);
	                System.setProperty("webdriver.chrome.silentOutput", "true");
	                ChromeOptions option = new ChromeOptions();
	                    option.addArguments("disable-infobars");
	                    option.addArguments("--disable-notifications");
	                 
	                    if (System.getProperty("os.name").toUpperCase().contains("MAC"))
	                    option.addArguments("-start-fullscreen");

	                    else if (System.getProperty("os.name").toUpperCase().contains("LINUX"))
		                    option.addArguments("-start-fullscreen");

	                    else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))

	                                                 option.addArguments("--start-maximized");

	                        else {throw new IllegalArgumentException("Unknown OS");}

	                  driver = new ChromeDriver(option);
	                  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	            break;
	            
	            default: throw new IllegalArgumentException("Unknown Browser");

	            
	        }  // switch block

	    }
}
