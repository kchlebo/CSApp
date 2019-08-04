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


import com.cornerstone.utilities.Log;


public class TearDown {


	public static void tear()
	{
		BrowserFactory.closeAllDriver();
		Log.end();
	}
}
