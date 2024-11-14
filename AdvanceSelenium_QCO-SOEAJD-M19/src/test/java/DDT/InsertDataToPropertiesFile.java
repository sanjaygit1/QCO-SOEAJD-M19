package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataToPropertiesFile {

	public static void main(String[] args) throws Throwable {

		//Inserting data to properties file
     FileInputStream fis = new FileInputStream("./src/test/resources/Properties_Data7am.properties");
	
    Properties pro = new Properties();
	//setProperty()--->insert data to physical file
    pro.setProperty("browser", "edge");
    pro.setProperty("url", "http://localhost:8888");
    pro.setProperty("username", "admin");
    pro.setProperty("password", "admin");
    
    //FileOutputStream--->keeps the file in write mode
    FileOutputStream fos = new FileOutputStream("./src/test/resources/Properties_Data7am.properties");
    pro.store(fos, "CommomData");
  //----------------------------------------------------------------------------------------------------------------------------
    //Fetching data from Properties file
    
    //load()---->loading keys into properties class
    pro.load(fis);
    String BROWSER = pro.getProperty("browser");
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	
	WebDriver driver;
	if (BROWSER.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}

	else if (BROWSER.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}

	else if (BROWSER.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	} else {
		driver = new EdgeDriver();
	}
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	}

}
