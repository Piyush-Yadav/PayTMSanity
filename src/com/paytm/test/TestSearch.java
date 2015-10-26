    package com.paytm.test;
	import java.io.IOException;
import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
    import com.paytm.page.HomePage;
import com.paytm.utility.OpenBrowser;
import com.paytm.utility.ReadExcel;
	 
	public class TestSearch 
	{
	    WebDriver driver;
	    HomePage hp;
 
	    @BeforeTest
	    public void setup() throws IOException
	        {
	    	
	    	
	    	ReadExcel rd = new ReadExcel();
	    	rd.getRow("s");
	    	String[][] data = rd.getData();
	        for (int i = 0; i < data.length; i++) {
	        	for (int j = 0; j < data[0].length; j++) {
					System.out.print(data[i][j]+"     ");
				}
	        	System.out.println();
				
			}
	    	
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://www.paytm.com");
	 	    }
	  
	    @Test(priority=0)
	    public void test_Home_Page_Appear_Correct()
	        {
	        hp = new HomePage(driver);
	        hp.search("i phone");
	        hp.showCategoryInList();
	        hp.getWalletAmount();
	        hp.getCartAmount();
	        hp.openCategory("Mobile & Accessories");
	        hp.getBanner();
	        }
	 }
