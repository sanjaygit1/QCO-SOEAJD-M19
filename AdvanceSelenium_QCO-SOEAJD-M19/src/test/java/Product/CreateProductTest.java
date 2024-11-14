package Product;

import java.io.FileInputStream;
import java.io.IOException;
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
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUp;
import ObjectRepository.ValidatePrdName;

@Listeners(Generic_Utility.ExtentReportImp.class)
public class CreateProductTest extends BaseClass {

	@Test
	public void CreateProductTest() throws Throwable {

		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);
		home.clickProductLink();

		ProductLookUp prd = new ProductLookUp(driver);
		prd.clickOnPlusSign();

		int ranNum = jlib.getRandomNum();
	//Assert.fail("Im failing the script");
		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

		
		ValidatePrdName validate = new ValidatePrdName(driver);
		String actData = validate.validatePrd(driver, PrdName);
		
        Assert.assertEquals(actData, PrdName,"product not created");
		System.out.println("Product name created");
	//	home.logOut(driver);
	}

}
