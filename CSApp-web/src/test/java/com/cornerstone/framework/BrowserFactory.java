/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.framework;

/**
 *
 * @author Kornel
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
//import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.RefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;





public class BrowserFactory {
	private static Map<BrowserType, Pair<EventFiringWebDriver, WebEventListener>> drivers = new HashMap<BrowserType, Pair<EventFiringWebDriver,WebEventListener>>();
        public enum BrowserType {IE, CHROME, FIREFOX, HEADLESSCHROME, HTMLUNIT};
        
	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(BrowserType browserName) {
		WebDriver driver = null;

		switch (browserName) {
		case FIREFOX:
			
			if (drivers.get(BrowserType.FIREFOX)==null) {
				getFirefoxBrowser(driver);
			}
			driver = drivers.get(BrowserType.FIREFOX).getKey();
			break;
		case IE:
			
			if (drivers.get(BrowserType.IE) == null) {
				getIEBrowser(driver);				
			}
			
			driver = drivers.get(BrowserType.IE).getKey();
			
			break;
		case CHROME:
			
			if (drivers.get(BrowserType.CHROME) == null) {
				
				getChromeBrowser(driver);
			}
			driver = drivers.get(BrowserType.CHROME).getKey();
			break;
		case HEADLESSCHROME:
			
			if (drivers.get(BrowserType.HEADLESSCHROME) == null) {
				
				getHeadlessChromeBrowser(driver);
			}
			driver = drivers.get(BrowserType.HEADLESSCHROME).getKey();
			break;
		case HTMLUNIT:
			
			if (drivers.get(BrowserType.HTMLUNIT) == null) {
				
				getHTMLUnitBrowser(driver);
			}
			driver = drivers.get(BrowserType.HTMLUNIT).getKey();
			break;
			
		
		}
		
		return driver;
	}
	
	
	


	//Default option
	public static WebDriver getBrowser()
	{
		return getBrowser(BrowserType.IE);
	}
	
	private static InternetExplorerOptions InitializeIEContext()
    {
        //Setting path to Selenium IE driver
        System.setProperty("webdriver.ie.driver", "C:\\ProgramData\\App-V\\Selenium\\IEDriverServer.exe");
        InternetExplorerOptions IEOptions =new InternetExplorerOptions();
        //Set ieCapabilities to avoid stopping on Zoom error
         IEOptions.ignoreZoomSettings();
        IEOptions.introduceFlakinessByIgnoringSecurityDomains();
        IEOptions.destructivelyEnsureCleanSession();
        IEOptions.requireWindowFocus();
        IEOptions.elementScrollTo(ElementScrollBehavior.TOP);
        return IEOptions;
     }
	
	private static void getIEBrowser(WebDriver driver)
	{
		
		driver = new InternetExplorerDriver(InitializeIEContext());
		drivers.put(BrowserType.IE, generateEventHandler(driver));
	}
	
	private static void getChromeBrowser(WebDriver driver)
	{
		//System.setProperty("webdriver.chrome.driver","./src/main/java/ChromeDriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\App-V\\Selenium\\ChromeDriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\ProgramData\\App-V\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe");
		//options.setBinary("c:\\Users\\604772006\\Documents\\apps\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe");
		//options.setBinary("c:/Users/604772006/Documents/apps/GoogleChromePortable/App/Chrome-bin/chrome.exe");
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		drivers.put(BrowserType.CHROME, generateEventHandler(driver));
	}
	
	private static void getFirefoxBrowser(WebDriver driver)
	{
		//System.setProperty("webdriver.gecko.driver","./src/main/java/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		//options.setBinary("C:\\Users\\604772006\\Documents\\apps\\FirefoxPortable\\App\\Firefox\\firefox.exe");
		driver = new FirefoxDriver(options);
		drivers.put(BrowserType.FIREFOX, generateEventHandler(driver));
	}
	
	private static void getHTMLUnitBrowser(WebDriver driver)
	{
		//DesiredCapabilities options=DesiredCapabilities.htmlUnit();
		
		//options.setAcceptInsecureCerts(true);
		//options.setJavascriptEnabled(true);
		
		driver = new HtmlUnitDriver() {

                        @Override
			protected WebClient modifyWebClient(WebClient client) {
				client.getOptions().setUseInsecureSSL(true);
				RefreshHandler rh = new RefreshHandler() {
					@Override
					public void handleRefresh(Page arg0, java.net.URL arg1, int arg2) throws IOException {
						//Do nothing
					}
			    };
			    java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.ALL); 
			    client.setRefreshHandler(rh);
			    client.getOptions().setJavaScriptEnabled(true);
			    client.getOptions().setCssEnabled(false);
			    client.getOptions().setRedirectEnabled(true);
			    client.setAjaxController(new NicelyResynchronizingAjaxController());
			    client.getCookieManager().setCookiesEnabled(true);

			    //client.getBrowserVersion().setDefault(BrowserVersion.FIREFOX_52);
			    return client;
			}
		};
		
		//driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
		//((HtmlUnitDriver)driver).setJavascriptEnabled(true);
		//((HtmlUnitDriver)driver).getBrowserVersion().set
		drivers.put(BrowserType.HTMLUNIT, generateEventHandler(driver));
	}
	
	private static void getHeadlessChromeBrowser(WebDriver driver) {
		//System.setProperty("webdriver.chrome.driver",	"./src/main/java/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.setBinary("c:\\Users\\604772006\\Documents\\apps\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe");
		//options.setBinary("c:/Users/604772006/Documents/apps/GoogleChromePortable/App/Chrome-bin/chrome.exe");
		options.setHeadless(true);
		options.setAcceptInsecureCerts(true);
		//options.addArguments("disable-gpu");
		//options.addArguments("remote-debugging-port=9222");
		driver = new ChromeDriver(options);
		drivers.put(BrowserType.HEADLESSCHROME, generateEventHandler(driver));
		
	}
	
	//Registering the WebEventListener with the EventFiringWebDriver
	private static Pair<EventFiringWebDriver, WebEventListener> generateEventHandler(WebDriver driver)
	{
		EventFiringWebDriver e_driver=new EventFiringWebDriver(driver);
		WebEventListener eventListener = new WebEventListener();
		e_driver.register(eventListener);
		return Pair.of(e_driver, eventListener);
	}
	
	public static void closeAllDriver() {
		for (BrowserType key : drivers.keySet()) {
			drivers.get(key).getKey().close();
			drivers.get(key).getKey().quit();
		}
	}
}
