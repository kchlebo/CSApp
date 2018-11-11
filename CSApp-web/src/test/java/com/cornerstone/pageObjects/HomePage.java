package com.cornerstone.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(css="div[id='main']")
	private  WebElement mainBody;

	public WebElement getMainBody() {
		return mainBody;
	}
	
	

}
