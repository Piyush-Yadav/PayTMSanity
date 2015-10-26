package com.paytm.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerPanalPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[@href='#/rpc']")
	WebElement rpcLink;
	
	public SellerPanalPage(WebDriver driver)
    {
	this.driver = driver;	 
    PageFactory.initElements(driver, this);
    }
	
	public void visitRPC(){
		driver.get("https://seller-dev.paytm.com/#/rpc");
	}
	
	public void openRPCPanel(){
		if(rpcLink.isDisplayed()){
		rpcLink.click();
	}
	}
}
