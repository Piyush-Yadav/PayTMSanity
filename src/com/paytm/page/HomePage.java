package com.paytm.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	
	WebDriver driver;

	@FindBy(className="icon-logo-Colored")
	WebElement logo;
	
	@FindBy(id="input_1")
	WebElement searchBar;
	
	@FindBy(xpath="//*[@ng-class='menuHandler[$index]']")
	List<WebElement> shopByCategoryList;
	
	@FindBy(xpath="//*[@ng-class='menuHandler[$index]' and contains(text(),'More...')]")
	WebElement moreCategories;
	
	@FindBy(xpath="//div[contains(text(),'Paytm Wallet')]/../following-sibling::span")
	WebElement walletAmmount;
	
	@FindBy(className="cartPri")
	WebElement cartAmmount;
	
	@FindBy(css="div.Cart.disabled > div.cart-text > span")
	WebElement emptyCart;

	@FindBy(xpath="//span[text()='Exclusive Discount Deals']")
	WebElement exclusiveDeals;
	
	
	//Need to pass the category name to select the 
	@FindBy(xpath="//div[@class='categoriesBar']/h1[contains(text(),'Gadget Store')]/..")
	WebElement banner;
	
	 public HomePage(WebDriver driver)
	    {
		this.driver = driver;	 
	    PageFactory.initElements(driver, this);
	    }
	 
	 public void showCategoryInList()
	     {	
		 List<WebElement> categoryList = shopByCategoryList;
		 int i=1;
			 for (WebElement string : categoryList) 
			    {
				System.out.println(string.getText()+"   "+i++);
			    }
	      }
	 
	 public void showMoreCategories()
		  {
			 
		  }
	 
	 public void search(String strUserName){
		  searchBar.sendKeys(strUserName);
     }
	
	 public void openCategory(String catName){
		  driver.findElement(By.linkText(catName)).click();
	 }
	 
	 public void getWalletAmount(){
		  System.out.println(walletAmmount.getText());
	 }
	
	 public void getBanner(){
		  System.out.println(banner.getText());
	 }
	
	 public void getCartAmount(){
		  if(emptyCart.isDisplayed()){
			    System.out.println("You have no item");
		  }
		  else{
			    System.out.println(cartAmmount.getText());
			  }
	  }
	
	
}
