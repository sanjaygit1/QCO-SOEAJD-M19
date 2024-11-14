package Campagins;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections4.functors.IfClosure;
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
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CampaignCreateNavigationPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUp;
import ObjectRepository.SwitchingProductPage;
import ObjectRepository.ValidateCampaignsWithProduct;

public class CreateCampWithProductTest extends BaseClass {

	@Test(groups = "RegressionTest")
	public void createCampWithProductTest() throws Throwable {

		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);
		home.clickProductLink();

		ProductLookUp prodImg = new ProductLookUp(driver);
		prodImg.clickOnPlusSign();
		// driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

		int ranNum = jlib.getRandomNum();

		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

//-----------------------------------------------------------------------------------------------------------
		// Navigating to campaign Module

		home.clickMoreLink();

		home.clickCampLink();

		CampaignCreateNavigationPage campImg = new CampaignCreateNavigationPage(driver);
		campImg.clickCampPlus();

		String CampName = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(CampName);

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.enterCampName(CampName);

		// Click on + sign To Navigate Product Table
		campPage.clickPrdPlusSign();

		wlib.switchingWindow(driver, "Products&action");

		SwitchingProductPage switchWin = new SwitchingProductPage(driver);
		switchWin.enterPrdName(PrdName);
		switchWin.searchPrdName();

		// Dynamic Xpath
		switchWin.selectExpPrdName(driver, PrdName);

		wlib.switchingWindow(driver, "Campaigns&action");

		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		campPage.clickSaveButton();

		ValidateCampaignsWithProduct validate = new ValidateCampaignsWithProduct(driver);
		validate.validateCampName(driver, CampName);

		validate.validatePrdName(driver, PrdName);

	//	home.logOutFromApp();
	}

}
