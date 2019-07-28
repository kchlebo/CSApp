package com.cornerstone.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cornerstone.framework.BrowserFactory;
import com.cornerstone.utilities.Log;
import com.cornerstone.utilities.Utility;



public class LoginPage {
	@FindBy(css="input[id='usernameTextbox']")
	private WebElement usernameTextbox;
	@FindBy(css="input[id='passwordTextbox']")
	private  WebElement passwordTextbox;
	@FindBy(css="input[id='loginButton']")
	private  WebElement loginButton;
	@FindBy(css="input[id='loginAsGuestButton']")
	private  WebElement loginAsGuestButton;
	
	private static final String loginURL = "http://localhost:8080/CSApp-web-1.0-SNAPSHOT";
	
	public void openURL()
	{
		this.openURL(loginURL);
	}
	
	public void openURL(String url)
	{
		try{
			WebDriver driver=BrowserFactory.getBrowser();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//to change zoom level to 100%
			driver.findElement(By.xpath("/html")).sendKeys(Keys.CONTROL+"0");
			driver.get(url);
	       }catch (Exception e){
	    	   	Log.error("Unexpected exception: " + e.getMessage());
	    	   	for(StackTraceElement s: e.getStackTrace())
	    	   	{
	    	   		Log.error(s.toString() + "\n");
	    	   	}
	      		//throw(e);
	      		}
	}
	

	public void enterUsername(String username)
	{
		usernameTextbox.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		Utility.smartClick(loginButton);
	}
	
	public void clickLoginAsGuestButton()
	{
		Utility.smartClick(loginAsGuestButton);
	}

	public  WebElement getLoginAsGuestButton() {
		return loginAsGuestButton;
	}

	
	public  WebElement getUsernameTextbox() {
		return usernameTextbox;
	}

	public  WebElement getPasswordTextbox() {
		return passwordTextbox;
	}

	public  WebElement getLoginButton() {
		return loginButton;
	}
	
	
	
}
