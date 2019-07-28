/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cornerstone.utilities;

/**
 *
 * @author Kornel
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

import com.cornerstone.framework.BrowserFactory;

import com.cornerstone.utilities.Log;
import com.cornerstone.utilities.TableHelper;





public class Utility {
	public static enum WAIT_TYPE{CLICKABLE, VISIBLE, SELECTED}
	private static final int WAIT_TIME=90;
    private static final int POLLING_TIME=1;
    private static final int WINDOW_SWITCH_RETRY=10;

	 public static void fluentWaitForElement(WebElement element, WAIT_TYPE type) {
		 		WebDriver driver = BrowserFactory.getBrowser();
		 
		     	WebDriverWait fWait = new WebDriverWait(driver, WAIT_TIME);
		     	fWait.pollingEvery(POLLING_TIME, TimeUnit.SECONDS);
		         fWait.ignoring(NoSuchElementException.class, TimeoutException.class);
		         fWait.ignoring(StaleElementReferenceException.class);
		         fWait.ignoring(NullPointerException.class);
		         
		         	if (type.equals(WAIT_TYPE.VISIBLE))
		         	{
		         		fWait.until(ExpectedConditions.visibilityOf(element));
		         		}
		         	else if(type.equals(WAIT_TYPE.CLICKABLE))
		         	{
		         		fWait.until(ExpectedConditions.elementToBeClickable(element));
		         	}
		         	else if(type.equals(WAIT_TYPE.SELECTED))
		         	{
		         		fWait.until(ExpectedConditions.elementToBeSelected(element));
		         	}
		         }
	 
	 public static void smartClick(WebElement element){
	    	fluentWaitForElement(element, WAIT_TYPE.CLICKABLE);
	    	element.click();
	    	//fluentWaitForElement(element, WAIT_TYPE.CLICKABLE);
	    }
	 
	 public static void switchToWindow(String title) throws InterruptedException
	 {
		 switchToWindow2(title, WINDOW_SWITCH_RETRY);
	 }
	 
	 public static void switchToWindow(String title, int retries) throws InterruptedException{
	        WebDriver popup = BrowserFactory.getBrowser();
	        Set<String> windowIterator = popup.getWindowHandles();
	        Log.info("No of windows :  " + windowIterator.size());
	        for (String s : windowIterator) {
	          String windowHandle = s; 
	          try{
	          popup=popup.switchTo().window(windowHandle);
	          Log.info("Found window Title : " + popup.getTitle());
		          if (title.equals(popup.getTitle()) ){
		              Log.info("Selected Window Title : " + popup.getTitle());
		              return;
		          }
		          else {
		              Thread.sleep(250);
		              
		          }
	          }
	          catch(NoSuchWindowException e) 
	          {
	              Log.error("no such window exception, retry");
	              if (retries>0){switchToWindow(title, --retries);}
	              else {
	            	  Log.error("No such window found even after "+WINDOW_SWITCH_RETRY+" retries");
	              }
		       }
	        }	        	            
	        }
	 
	 public static void switchToWindow2(String title, int retries) throws InterruptedException{
	        WebDriver popup = BrowserFactory.getBrowser();
	        Set<String> windowIterator = popup.getWindowHandles();
	        Log.info("No of windows :  " + windowIterator.size());
	        for (int i=0; i<windowIterator.size();i++) {
	          String windowHandle = windowIterator.toArray()[i].toString(); 
	          try{
	          popup=popup.switchTo().window(windowHandle);
	          Log.info("Found window Title : " + popup.getTitle());
		          if (title.equals(popup.getTitle()) ){
		              Log.info("Selected Window Title : " + popup.getTitle());
		              return;
		          }
		          else {
		              Thread.sleep(250);
		              if (i==windowIterator.size()-1&&retries>0){switchToWindow(title, --retries);}
		              else {
		            	  Log.error("No such window found even after "+WINDOW_SWITCH_RETRY+" retries");
		              }
		          }
	          }
	          catch(NoSuchWindowException e) 
	          {
	              Log.error("no such window exception, retry");
	              if (retries>0){switchToWindow(title, --retries);}
	              else {
	            	  Log.error("No such window found even after "+WINDOW_SWITCH_RETRY+" retries");
	              }
		       }
	        }	        	            
	        }
	 
	 public static WebElement getDynamicDropdownEntry(String id) throws IOException
	    {
		 	WebDriver driver = BrowserFactory.getBrowser();
	    	List<WebElement> table_set=driver.findElements(By.xpath("/html/body/div[@class='MenuOuter' and contains(@style, 'visibility: inherit')]/div[@class='MenuTableContainer']/table[@class='MenuTable']"));
	        WebElement dropDown= Utility.getCellFromTableSetFast(table_set, id);
	        while (dropDown==null)
	        {
	        	table_set=driver.findElements(By.xpath("/html/body/div[@class='MenuOuter']/div[@class='MenuTableContainer']/table[@class='MenuTable']"));
	        	dropDown= Utility.getCellFromTableSetFast(table_set, id);
	        }
	        return dropDown;
	        
	    }
	 
	 public static WebElement getCellFromTableSetFast(List<WebElement> table_set, String id) throws IOException
	    {
	        WebElement cell=null;
	        HtmlTable hTable=null;
	        TableHelper pos=null;
	        WebDriver driver = BrowserFactory.getBrowser();
	        for (WebElement table:table_set)
	        {
	            hTable=convertWebElementToHtmlTable(table);
	            pos=findCellPosInHtmlTable(hTable, id);
	            if(pos.getRowNum()!=-1)
	            {
	            String cellXpath=getAbsoluteXPath(table)+"/tbody/tr["+pos.getRowNum()+"]/td["+pos.getColNum()+"]";
	            cell=driver.findElement(By.xpath(cellXpath));
	            return cell;
	            }
	            
	        }
	        return cell;
	    }
	 public static HtmlTable convertWebElementToHtmlTable(WebElement table) throws MalformedURLException, IOException
	    {
	        URL url=new URL("http://www.example.com");
	        String elementHtmlSource=table.getAttribute("outerHTML");
	        StringWebResponse response;
	        response = new StringWebResponse(elementHtmlSource, url);
	        WebClient client = new WebClient();
	        HtmlPage page = HTMLParser.parseHtml(response, client.getCurrentWindow());
	        HtmlTable hTable=page.getFirstByXPath("//table");
	        client.close();
	        return hTable;
	    }
	    
	    public static TableHelper findCellPosInHtmlTable(HtmlTable table, String id)
	    {
	        int rowNum=1;
	        int colNum=1;
	        TableHelper pos=new TableHelper(-1,-1);
	        for (final HtmlTableRow row : table.getRows()) {
	        	Log.info("Found row");
	            for (final HtmlTableCell cell : row.getCells()) {
	            	Log.info("   Found cell: " + cell.asText());
	                    if(cell.asText().equals(id))
	                    {
	                        pos.setRowNum(rowNum);
	                        pos.setColNum(colNum);
	                        return pos;
	                    }
	                colNum++;
	            }
	            colNum=1;
	            rowNum++;
	        }
	        return pos;
	    }
	    
	    public static String getAbsoluteXPath(WebElement element)
	    {
	    	WebDriver driver = BrowserFactory.getBrowser();
	        return (String) ((JavascriptExecutor) driver).executeScript(
	                "function absoluteXPath(element) {"+
	                        "var comp, comps = [];"+
	                        "var parent = null;"+
	                        "var xpath = '';"+
	                        "var getPos = function(element) {"+
	                        "var position = 1, curNode;"+
	                        "if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
	                        "return null;"+
	                        "}"+
	                        "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling){"+
	                        "if (curNode.nodeName == element.nodeName) {"+
	                        "++position;"+
	                        "}"+
	                        "}"+
	                        "return position;"+
	                        "};"+

	    "if (element instanceof Document) {"+
	    "return '/';"+
	    "}"+

	    "for (; element && !(element instanceof Document); element = element.nodeType ==Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
	    "comp = comps[comps.length] = {};"+
	    "switch (element.nodeType) {"+
	    "case Node.TEXT_NODE:"+
	    "comp.name = 'text()';"+
	    "break;"+
	    "case Node.ATTRIBUTE_NODE:"+
	    "comp.name = '@' + element.nodeName;"+
	    "break;"+
	    "case Node.PROCESSING_INSTRUCTION_NODE:"+
	    "comp.name = 'processing-instruction()';"+
	    "break;"+
	    "case Node.COMMENT_NODE:"+
	    "comp.name = 'comment()';"+
	    "break;"+
	    "case Node.ELEMENT_NODE:"+
	    "comp.name = element.nodeName;"+
	    "break;"+
	    "}"+
	    "comp.position = getPos(element);"+
	    "}"+

	    "for (var i = comps.length - 1; i >= 0; i--) {"+
	    "comp = comps[i];"+
	    "xpath += '/' + comp.name.toLowerCase();"+
	    "if (comp.position !== null) {"+
	    "xpath += '[' + comp.position + ']';"+
	    "}"+
	    "}"+

	    "return xpath;"+

	"} return absoluteXPath(arguments[0]);", element);
	    }
	    
	    public static void switchToWindowUsingPartialUrl(String url) throws InterruptedException
	    {
	    	//switchToWindowUsingPartialUrl2(url, WINDOW_SWITCH_RETRY, 0 );
	    	switchToWindowUsingPartialUrl(url, WINDOW_SWITCH_RETRY );
	    }
	    
	    public static void switchToWindowUsingPartialUrl(String url, int retries) throws InterruptedException {
	        WebDriver popup = null;
	        
	        int tries=20;
	        for (int i=0;i<tries;i++){
	        Set<String> windowIterator = popup.getWindowHandles();
	        Log.info("No of windows :  " + windowIterator.size());
	        for (String s : windowIterator) {
	          String windowHandle = s; 
	           try{
	          popup=popup.switchTo().window(windowHandle);
	          Log.info("Window Title : " + popup.getTitle());
	          Log.info("Window Url : " + popup.getCurrentUrl());
	          if (popup.getCurrentUrl().endsWith(url)) {
	        	  Log.info("Selected Window Title : " + popup.getTitle());
	              
	              return;
	          }
	          else {
	              Thread.sleep(500);
	          }
	          }
	          catch(NoSuchWindowException e) 
	          {
	        	  Log.info("no such window exception, retry");
	              if (retries>0){switchToWindow(url);}
	              retries--;
	         }
	         }
	        }
	            
	        }
	    
	    public static void switchToWindowUsingPartialUrl2(String url, int retries, int i) throws InterruptedException {
	        
	        WebDriver popup = BrowserFactory.getBrowser();
	        String currentWindowHandle=popup.getWindowHandle();
	        Set<String> windowIterator = popup.getWindowHandles();
	        Log.info("No of windows :  " + windowIterator.size());
	        //int i=0;
	        if (i<windowIterator.size()) {
	        	// swapWindows(windowIterator, i, retries, url);
	          
	        	String windowHandle = windowIterator.toArray()[i].toString(); 
	           try{
	          popup=popup.switchTo().window(windowHandle);
	          Log.info("Window Title : " + popup.getTitle());
	          Log.info("Window Url : " + popup.getCurrentUrl());
	          if (popup.getCurrentUrl().contains(url)) {
	        	  Log.info("Selected Window Title : " + popup.getTitle());
	              return;
	          }
	          else {
	              Thread.sleep(100);
	              Log.info("Window doesn't match criteria");
	              if (i<windowIterator.size()) {
	            	  //switchToWindowUsingPartialUrl(url, retries, ++i);
	              }
	              else {
		              if ( retries>0){
		            	 // switchToWindowUsingPartialUrl(url, --retries, 0);
		            	  }
		              else {
		            	  Log.error("No such window found even after "+WINDOW_SWITCH_RETRY+" retries");
		              }
	              }
	          }
	          }
	          catch(NoSuchWindowException e) 
	          {
	        	  Log.info("No such window exception, retry");
	        	  if (i<windowIterator.size()) {
	            	  //switchToWindowUsingPartialUrl(url, retries, ++i);
	              }
	        	  else {
	        		  
	        	  
		              if ( retries>0){
		            	  //switchToWindowUsingPartialUrl(url, --retries, 0);
		            	  }
		              else {
		            	  Log.error("No such window found even after "+WINDOW_SWITCH_RETRY+" retries");
		              }
	        	  }
	                      
	         }
	         
	         
	         }
	        //Switching back to original window in case no match found 
	        popup=popup.switchTo().window(currentWindowHandle);  
	        }
	    public static void swapWindows(Set<String> windowIterator, int winCount, int retries, String url) throws InterruptedException
	    {
	    	WebDriver popup = BrowserFactory.getBrowser();
	    	String windowHandle = windowIterator.toArray()[winCount].toString(); 
	           try{
	          popup=popup.switchTo().window(windowHandle);
	          Log.info("Window Title : " + popup.getTitle());
	          Log.info("Window Url : " + popup.getCurrentUrl());
	          if (popup.getCurrentUrl().contains(url)) {
	        	  Log.info("Selected Window Title : " + popup.getTitle());
	              return;
	          }
	          else {
	              Thread.sleep(100);
	              Log.info("Window doesn't match criteria");
	              
	              if ( retries>0){
	            	   // switchToWindowUsingPartialUrl(url, --retries);
	            	  }
	              else {
	            	  Log.error("No such window found even after "+WINDOW_SWITCH_RETRY+" retries");
	              }
	              
	          }
	          }
	          catch(NoSuchWindowException e) 
	          {
	        	  Log.info("No such window exception, retry");
	              if ( retries>0){
	            	  //switchToWindowUsingPartialUrl(url, --retries);
	            	  }
	              else {
	            	  Log.error("No such window found even after "+WINDOW_SWITCH_RETRY+" retries");
	              }
	                      
	         }
	    }
	    
	    
	    public static void handlePopups() throws IOException, InterruptedException
	    {
	    	WebDriver driver = BrowserFactory.getBrowser();
        // you can reach each frame on your site
	        //for(WebElement iframe:iframes)
	        try {
	            // switch to every frame
	        	switchToCurrentFrame();
	            Log.info("switched to frame");
	            switchToActiveFrame();
	            // now within the frame you can navigate like you are used to
	           if(isPopupMessagePresent())
	           {
	            String popupText=driver.findElement(By.xpath("//*[@id='PopupMsgBox']")).getText();
	            Log.info(popupText);
	            
	            WebElement popup=driver.findElement(By.xpath("/html"));
	            
	            //You Cannot Accept the Task as you do not belong to the Assigned Group (ARNOTE 10000)
	           
	           //The task is already accepted by the user. (ARERR 10000)
	           if(popupText.contains("ARERR 10000") || popupText.contains("ARNOTE 62094")|| popupText.contains("ARNOTE 60506")|| popupText.contains("The Notification has been sent")||popupText.contains("has been created"))
	           {
	        	   String okbtn="//div[@id='PopupMsgFooter']/a";
	        	   Utility.fluentWaitForElement(popup.findElement(By.xpath(okbtn)), WAIT_TYPE.CLICKABLE);
	        	   popup.findElement(By.xpath(okbtn)).click();
	        	   try {
	        	   Utility.switchToCurrentWindow();
	        	   }
	        	   catch (NoSuchWindowException ex)
	        	   {
	        		   Log.info("window got closed");
	        	   }
	        	   
	           }
	           //This record has been updated by another user since you retrieved it. 
	           //Saving your changes will overwrite the changes made by that user. 
	           //Do you want to save your changes? (ARWARN 9299)
	           else if (popupText.contains("ARNOTE 10000"))
	           {
	        	   String okbtn="//div[@id='PopupMsgFooter']/a";
	        	   Utility.fluentWaitForElement(popup.findElement(By.xpath(okbtn)), WAIT_TYPE.CLICKABLE);
	        	   popup.findElement(By.xpath(okbtn)).click();
	               Utility.switchToCurrentWindow();
	        	   //IMD_Page.UpdateTaskPage.reassignTaskGroup("BT Testing", "First_Tier_Dedicated_Group1");
	        	   //IMD_Page.UpdateTaskPage.acceptTask();
	           }
	           else if(popupText.contains("ARWARN 9299")||popupText.contains("Your changes have not been saved or sent"))
	           {
	        	   Utility.fluentWaitForElement(popup.findElement(By.xpath("//div[@id='PopupMsgFooter']/a[@arid='4']")), WAIT_TYPE.CLICKABLE);
	        	   popup.findElement(By.xpath("//div[@id='PopupMsgFooter']/a[@arid='4']")).click();
	        	   Utility.switchToCurrentWindow();
	        	   //Utility.fluentWaitForElement(IMD_Page.UpdateTaskPage.getElementLov_WorkInfoType(), WAIT_TYPE.CLICKABLE);
	           }
	           
	        }
	           else if (isAlertPresent()) {
	          	    driver.switchTo().alert();
	          	    driver.switchTo().alert().accept();
	          	    driver.switchTo().defaultContent();
	          		}
	        }
	        catch (NoSuchFrameException e)
	        {
	        	Log.info("no popup");
	        	return;
	        }
	    }
	    
	    public static void switchToCurrentFrame()
	    {
	    	WebDriver driver = BrowserFactory.getBrowser();
	    	driver.switchTo().defaultContent();
	    	driver.switchTo().frame(0);

	    }
	    
	    public static boolean isAlertPresent() {
	    	WebDriver driver = BrowserFactory.getBrowser();
	    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	        try {
	            driver.switchTo().alert();
	            return true;
	        } // try
	        catch (NoAlertPresentException  e) {
	            return false;
	        } // catch
	        finally {
	    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	    	}
	    }
	    
	    public static void switchToActiveFrame()
	    {
	    	WebDriver driver = BrowserFactory.getBrowser();
	    	driver.switchTo().defaultContent();
	    	List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
	        // print your number of frames
	           //System.out.println("number of frames: "+iframes.size());
	           for (WebElement iframe:iframes)
	           {
	        	   Log.info("iframe name: "+iframe.toString());
	        	   Log.info("iframe text: "+iframe.getText());
	        	   Log.info("iframe is displayed: "+iframe.isDisplayed());
	        	   if(iframe.isDisplayed())
	        	   {
	        		   driver.switchTo().frame(iframe);
	        		   Log.info("result found - active frame selected");
	        		   return;
	        	   }
	           	
	           }
	    }
	    public static boolean isPopupMessagePresent() {
	    	WebDriver driver = BrowserFactory.getBrowser();
	    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	    	try {
	    		driver.findElement(By.xpath("//*[@id='PopupMsgBox']"));
	    		//driver.findElement(By.cssSelector("div[id^='popup'][style*='visibility: inherit'] [@id='PopupMsgBox']"));
	            return true;
	        } // try
	        catch (Exception e) {
	            return false;
	        } // catch
	    	finally {
	    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	    	}
	    }
	    
	    public static void switchToCurrentWindow()
	    {
	    	WebDriver driver = BrowserFactory.getBrowser();
	    	driver.switchTo().defaultContent();
	    }
	    
	    public static void maximizeCurrentWindow()
	    {
	    	WebDriver driver = BrowserFactory.getBrowser();
	    	driver.manage().window().maximize();
	    }
	    
	    public static boolean isElementClickable(WebElement element) {
	    	WebDriver driver = BrowserFactory.getBrowser();
	    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	    	try {
	    		element.click();
	    		//driver.findElement(By.cssSelector("div[id^='popup'][style*='visibility: inherit'] [@id='PopupMsgBox']"));
	            return true;
	        } // try
	        catch (Exception e) {
	            return false;
	        } // catch
	    	finally {
	    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	    	}
	    }
	    
	    public static void handleAlert()
	    {
	    	WebDriver driver = BrowserFactory.getBrowser();
	    	if (isAlertPresent()) {
	      	    
	      	    driver.switchTo().alert().accept();
	      	    //driver.switchTo().defaultContent();
	      		}
	    }
	    
	    public static void realign(WebElement alignElement)
     	{
	    	WebDriver driver = BrowserFactory.getBrowser();
     		//WebElement element = Header.getPnl_HeaderPanel();
     		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alignElement);

     	}
	    
}

