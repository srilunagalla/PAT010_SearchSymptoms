package pat010;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginUtilities {
	public   WebDriver driver;
	public  LoginUtilities(WebDriver driver2) {
			this.driver=driver2;
		}
	public void setup(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	    
	}

	public void  validateLoginPage(String uname,String pword ){             
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		 
	}
		 
	   
	    	
	  public void  InvalidUserName(String uname,String pword){           
			driver.findElement(By.id("username")).sendKeys(uname);
			driver.findElement(By.id("password")).sendKeys(pword);
			driver.findElement(By.name("submit")).click();
			
			}
	public void  Blankusernameandpassword(String uname,String pword ){          
			
		    driver.findElement(By.id("username")).sendKeys(uname);
			driver.findElement(By.id("password")).sendKeys(pword);
			driver.findElement(By.name("submit")).click();
			
			
	}
	public void Dashboard(String uname,String pword){
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		List<WebElement> colname = driver.findElements(By.xpath("//div[@class='panel-body nopadding']//thead//th"));
		int size = colname.size();
		if(size==4){
				Assert.assertTrue(true);
			}
	}
		public boolean isalertpresent(){
			try {
				driver.switchTo().alert();
				return true;
			} catch (Exception e) {
				
			}
			return false;
		}
	public  HashMap<String, String> bookanappointment(){
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("1", "Beth");
	map.put("2", "Charlie");
	map.put("3", "Smith");
	map.put("4", "Alexander");
	map.put("5", "Becky");
	map.put("7", "Annabeth");
	return map;
		

	}


			
			
				
			
	public void setreport(){
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/iitAutomation");
		 ExtentReports extent = new ExtentReports();
		 extent.attachReporter(html);
	}
		
	public void takeSnapShot(WebDriver driver,String filepath) throws Exception{
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 File DestFile=new File(filepath);
		 FileUtils.copyFile(SrcFile, DestFile);


	}
}
