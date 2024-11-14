package TestNgPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Java_Utility;

public class DataProviderEx2 {

	@Test(dataProvider = "getData")
	public void organizationModuleTest(String orgName,String phnNum,String mailId) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		}
	
	@DataProvider
	public Object[][] getData()
	{
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRandomNum();
		Object[][] ObjArr = new Object[2][3];

		ObjArr[0][0]="AAA"+ranNum;
		ObjArr[0][1]="654465165";
		ObjArr[0][2]="svc@gmail.com";
		
		ObjArr[1][0]="BBB"+ranNum;
		ObjArr[1][1]="654465165";
		ObjArr[1][2]="jhfb@gmail.com";
		return ObjArr;
		
	}
	
	
	
}
