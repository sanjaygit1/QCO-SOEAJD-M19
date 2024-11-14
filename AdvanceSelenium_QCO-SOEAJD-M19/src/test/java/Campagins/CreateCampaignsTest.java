package Campagins;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CampaignCreateNavigationPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationNavigationPage;
import ObjectRepository.ValidateCampaigns;
import ObjectRepository.ValidateOrganization;

@Listeners(Generic_Utility.ExtentReportEx.class)
public class CreateCampaignsTest extends BaseClass {

	@Test
	public void createCampaignsTest() throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampaignCreateNavigationPage camp = new CampaignCreateNavigationPage(driver);
		camp.clickCampPlus();

		int ranNum = jlib.getRandomNum();
//Assert.fail("Im Failing the script");
		String CampName = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(CampName);

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.enterCampName(CampName);
		campPage.clickSaveButton();

		ValidateCampaigns valid = new ValidateCampaigns(driver);
		String actData = valid.validateCampName(driver, CampName);
		
		Assert.assertEquals(actData, CampName);
		System.out.println("campaign data created");
	//	home.logOut(driver);
	}
	
}