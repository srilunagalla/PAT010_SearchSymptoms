package pat010;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class LoginPage {

	WebDriver driver;
 
	
	@Test(priority=1)	
	public void Loginpagetest ()throws Exception  {  // valid login
    	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
     LoginUtilities utils=new LoginUtilities(driver);
	    utils.validateLoginPage("ria1", "Ria12345");
	     Assert.assertEquals(driver.getTitle(),"home");
 utils.takeSnapShot(driver, "./reports/iitAutomation.png");
	}
    
 @Test(priority=1)
	public void  InvalidLoginPage() throws Exception{    //invalid credentials
	 WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		LoginUtilities utils=new LoginUtilities(driver); 
	 utils.InvalidUserName("ria", "Ria12345");
     boolean alert = utils.isalertpresent();
	 if(alert==true){
		 driver.switchTo().alert().dismiss();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(true);
	 }
	 
	 utils.takeSnapShot(driver, "./reports/iitAutomation.png");
 }


}
