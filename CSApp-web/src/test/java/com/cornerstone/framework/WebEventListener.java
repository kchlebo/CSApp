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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import com.cornerstone.utilities.Log;



public class WebEventListener extends AbstractWebDriverEventListener {

        @Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		Log.info("Before navigating to: '" + url + "'");
	}

        @Override
	public void afterNavigateTo(String url, WebDriver driver) {
		Log.info("Navigated to:'" + url + "'");
	}

	//
	
	
	
        @Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		Log.info("Trying to click webelement at "+element.toString()+"");
	}

        @Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		Log.info("Clicked on: " + element.toString());
	}
	
	public void beforeFindBy(WebElement element, WebDriver driver) {
		Log.info("Trying to find webelement at "+element.toString()+"");
	  }

	  public void afterFindBy(WebElement element, WebDriver driver) {
		  Log.info("Webelement at "+element.toString()+" found");
	  }

        @Override
	public void onException(Throwable error, WebDriver driver) {
		Log.info("Error occurred: " + error);
	}
}