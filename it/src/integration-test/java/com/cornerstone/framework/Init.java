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
//import org.apache.log4j.xml.DOMConfigurator;



import com.cornerstone.utilities.Log;

public class Init {

	
	public static void initialize()
	{
		//DOMConfigurator.configure("./src/main/java/log4j2.xml");
		Log.start();

	}
}
