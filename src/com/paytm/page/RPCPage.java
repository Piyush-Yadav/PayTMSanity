package com.paytm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RPCPage {

	WebDriver driver;
	
	@FindBy()
	WebElement inscanned;
	
	@FindBy(className="ns-message")
	WebElement notification;
	
	public RPCPage(WebDriver driver)
    {
	this.driver = driver;	 
    PageFactory.initElements(driver, this);
    }
	
	
	public void clickOn(String option){
		WebElement element = driver.findElement(By.xpath("//*[@id='tabs']/li/a"));
		Actions mouseOver = new Actions(driver);
		mouseOver.sendKeys(Keys.HOME).moveToElement(element).build().perform();
	driver.findElement(By.xpath("//a[@class='ng-binding ng-scope' and contains(text(),'"+option+"')]")).click();
	}
	
	public void QCReject(){
		WebElement element = driver.findElement(By.xpath("id('order-body')//tr[1]//a[contains(text(),'Select action')]"));
		Actions mouseOver = new Actions(driver);
		mouseOver.moveToElement(element).build().perform();
	driver.findElement(By.xpath("id('order-body')//tr[1]//a[contains(text(),'QC Reject')]")).click();
	}
	
	public void getNotification(){
		System.out.println(notification.getText());
	}
	
}
