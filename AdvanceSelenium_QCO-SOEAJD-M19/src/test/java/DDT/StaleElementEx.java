package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;

public class StaleElementEx {

	public static void main(String[] args) throws Throwable {
	
		File_Utility flib = new File_Utility();
		WebDriver driver=new ChromeDriver();
		
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		System.out.println(driver.getWindowHandle());
		WebElement login = driver.findElement(By.id("submitButton"));
		driver.navigate().refresh();
		System.out.println(driver.getWindowHandle());
		login.click();
}
}
