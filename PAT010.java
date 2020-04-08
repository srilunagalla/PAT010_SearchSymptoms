package pat010;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class PAT010 {
	public  static WebDriver driver;
	
	@Test(dataProvider="symp")

	public void Validatesymptomcold(String symp) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		    WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/login.php");
		LoginUtilities loginpage=new LoginUtilities(driver);
		loginpage.validateLoginPage("Ria1", "Ria12345");
			driver.findElement(By.xpath("//span[contains(text(),'Search Symptoms')]")).click();
		     String title = driver.getTitle();
			System.out.println(title);
			if (title.contains("search Symptoms")){
				System.out.println("********symptoms page opened successfully*****");
			}
			else{
				System.out.println("****not successfully loaded******");
			}
		 
		      WebElement searchtext = driver.findElement(By.name("search"));
		      searchtext.sendKeys(symp);
			  driver.findElement(By.name("submit")).click();
			  Thread.sleep(3000);
			  List<WebElement> trdata = driver.findElements(By.xpath("//table[@class='table']//tbody//tr/td"));
			  System.out.println("***size of column is:****" +trdata.size());
		
			   if(trdata.size()==3){
			  
				  System.out.println("Data is Displayed");
				  
			  }
			   else{
				  System.out.println("Data is not Displayed");
			  }

	}
			  
		


	@DataProvider(name="symp")
	public Object[][] testdata(){
	Excelutils exl = new Excelutils("./Excelsheet/symptoms.xlsx");
	int rows = exl.getrowcount(0);
	Object[][] table = new Object[rows][1];
	for(int i=0;i<rows;i++){
		table[i][0]=exl.getcelldata(0, i, 0);
		

	}
	return table;
	}
		
		   




}
