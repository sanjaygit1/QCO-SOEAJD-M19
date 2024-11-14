package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void bs()
	{
		System.out.println("DataBase connection");
	}
	
	@BeforeTest(groups = {"SmokeTest","RegressionTest"})
	public void bt()
	{
		System.out.println("Parallel execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	
//	public void bc(String BROWSER) throws Throwable
//	{
	
	public void bc() throws Throwable
	{
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		
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
		
		sdriver=driver;
		System.out.println("launching Browser");
	}
	
//	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
//	public void bm(String URL,String USERNAME,String PASSWORD ) throws Throwable
//	{
	public void bm() throws Throwable
	{
		WebDriver_utility wlib = new WebDriver_utility();
		wlib.maximizeWindow(driver);
		wlib.waitForElementsToLoad(driver);
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);
		System.out.println("login to application");
	}
	
	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void am()
	{
		HomePage home = new HomePage(driver);
		home.logOut(driver);
		System.out.println("logout from application");
	}
	
	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void ac()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	
	@AfterTest(groups = {"SmokeTest","RegressionTest"})
	public void at()
	{
		System.out.println("Parallel execution done");
	}
	
	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void as()
	{
		System.out.println("Close database connection");
	}
}
