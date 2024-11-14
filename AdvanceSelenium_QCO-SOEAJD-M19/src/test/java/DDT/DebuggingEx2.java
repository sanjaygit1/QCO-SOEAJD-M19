package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.WebDriver_utility;

public class DebuggingEx2 {

	public static void main(String[] args) {

WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in");

WebDriver_utility wlib = new WebDriver_utility();
wlib.maximizeWindow(driver);

driver.findElement(By.name("field-keywords")).sendKeys("puma");
	}

}
