package TestNgPratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	@Test(dataProvider = "setOfData")
	public void bookTickets(String src,String dest)
	{
		System.out.println("Book tickets from"+src+ "to"+dest);
	}
	
	@DataProvider
	public  Object[][] setOfData()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0]="Banglore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Banglore";
		objArr[1][1]="Mumbai";
		
		objArr[2][0]="Banglore";
		objArr[2][1]="mysore";
		
		return objArr;
		
	}
	
	
}
