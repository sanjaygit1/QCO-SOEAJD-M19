package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationNavigationPage;
import ObjectRepository.ValidateOrganization;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = {"SmokeTest","RegressionTest"})
	public void createOrganizationTest() throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		HomePage home = new HomePage(driver);
		home.clickOrgLink();

		OrganizationNavigationPage orgPlus = new OrganizationNavigationPage(driver);
		orgPlus.clickOrgnization();

		int ranNum = jlib.getRandomNum();

		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		System.out.println(OrgName);

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.enterOrgName(OrgName);

		// --------------------------------------------------------------------------------------------

		String PhoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		System.out.println(PhoneNum);
		orgPage.enterPhnNum(PhoneNum);

		// ------------------------------------------------------------------------------------------

		String Email = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
		System.out.println(Email);
		orgPage.enterMailId(Email);

		// -------------------------------------------------------------------------------------------

		orgPage.clickSaveButton();

		ValidateOrganization validate = new ValidateOrganization(driver);
		validate.validateOrgName(driver, OrgName);

	//	home.logOutFromApp();
	}

}
