package Product;

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
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.DeleteProductName;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUp;
import ObjectRepository.ValidatePrdName;

public class CreateProductAndDeleteProductTest extends BaseClass {

	@Test
	public void createProductAndDeleteProductTest() throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		// Reading data from file_utility

		HomePage home = new HomePage(driver);
		home.clickProductLink();

		ProductLookUp prdImg = new ProductLookUp(driver);
		prdImg.clickOnPlusSign();

		int ranNum = jlib.getRandomNum();

		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

		ValidatePrdName validate = new ValidatePrdName(driver);
		validate.validatePrd(driver, PrdName);

		// -------------------------------------------------------------------------------------------------------------------------
		// Navigating to product table
		home.clickProductLink();

		DeleteProductName delete = new DeleteProductName(driver);
		delete.selectProdName(driver, PrdName);
		delete.selectDeletButton();

		wlib.alertAccept(driver);

		delete.validatePrdDeleted(driver, PrdName);

	//	home.logOutFromApp();
	}
}
