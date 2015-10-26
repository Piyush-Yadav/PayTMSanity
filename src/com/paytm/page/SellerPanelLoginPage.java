package com.paytm.page;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerPanelLoginPage {
	WebDriver driver;
	String LoginWindow;
	
	@FindBy(id="authentication_email")
	WebElement userId;
	
	@FindBy(id ="authentication_password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'sign in')]")
	WebElement signIn;
	
	
	public SellerPanelLoginPage(WebDriver driver)
    {
	this.driver = driver;	 
    PageFactory.initElements(driver, this);
    }
	
	public void sign(){
		userId.sendKeys("samarth@paytm.com");
		signIn.click();
		password.sendKeys("crappydoo");
	    signIn.click();
	    driver.switchTo().window(LoginWindow);
	}
	
	public void switchTologinPage(){
		LoginWindow = driver.getWindowHandle();
		 Set<String> SigninWindowHandle = driver.getWindowHandles();
		 for(String currentWindow : SigninWindowHandle){//advance for loop
		if(!(currentWindow.equals(LoginWindow))){//!=for not
		driver.switchTo().window(currentWindow);
	}
		 }
	}
}
