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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
 
// Initialize Log4j logs
 
     private static Logger Log = LogManager.getLogger(Log.class.getName()); 
 
// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
 
public static void start(){
 
    Log.info("****************************************************************************************");
 
    Log.info("****************************************************************************************");
 
    Log.info("$$$$$$$$$$$$$$$$$$$$$                 START       $$$$$$$$$$$$$$$$$$$$$$$$$");
 
    Log.info("****************************************************************************************");
 
    Log.info("****************************************************************************************");
 
    }
 
    //This is to print log for the ending of the test case
 
public static void end(){
 
    Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
 
    Log.info("X");
 
    Log.info("X");
 
    Log.info("X");
 
    Log.info("X");
 
    }
 
    // Need to create these methods, so that they can be called  
 
public static void info(String message) {
 
        Log.info(message);
 
        }
 
public static void warn(String message) {
 
    Log.warn(message);
 
    }
 
public static void error(String message) {
 
    Log.error(message);
 
    }
 
public static void fatal(String message) {
 
    Log.fatal(message);
 
    }
 
public static void debug(String message) {
 
    Log.debug(message);
 
    }
 
}