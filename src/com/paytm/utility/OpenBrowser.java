package com.paytm.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class OpenBrowser {
    WebDriver driver = null;
	public WebDriver openBrowser(String browserName){
		switch(browserName){
		case "firefox":
		case "Firefox":
		case "FireFox":
			driver = new FirefoxDriver();
			break;
		case "Chrome":
		case "chrome":
			System.setProperty("", "");
			driver = new ChromeDriver();
			break;
		case "IE":
		case "ie":
		case "Internet Explorer":
			System.setProperty("", "");
			driver = new InternetExplorerDriver();
		    break;
		case "Safari":
		case "safari":
			System.setProperty("", "");
			driver = new SafariDriver();
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}	
}
