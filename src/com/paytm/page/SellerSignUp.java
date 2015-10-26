package com.paytm.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerSignUp {
 
	WebDriver driver;
	
	@FindBy(xpath = "//a[@ng-click='logIn()']")
	WebElement signInLink;
	
	@FindBy(id="email_id")
	WebElement emailId;
	
	@FindBy(id="first_name")
	WebElement name;
	
	@FindBy(id="mobile")
	WebElement mobileNumber;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//a[@ng-if='showSignUpButton']")
	WebElement signUpButton;
	
	 public SellerSignUp(WebDriver driver)
	    {
		this.driver = driver;	 
	    PageFactory.initElements(driver, this);
	    }
	 
	 public void fillSignUpForm(){
		 emailId.clear();
		 emailId.sendKeys("abc@xyz.qqq");
		 name.clear();
		 name.sendKeys("Piyush");
		 mobileNumber.sendKeys("1234567891");
		 password.sendKeys("password");
		 signUpButton.click();
	 }
	
	 public void clickSignIn(){
		 
		 signInLink.click();
	 }

	
}
