package TestNgPratice;

import org.testng.annotations.Test;


public class SampleTest {

	@Test(priority = 0)
	public void createProduct() {
		System.out.println("Product Created");
	}

	@Test(priority = 1)
	public void modifyProduct() {
		System.out.println("Product Modified");
	}

	@Test(priority = -1)
	public void deleteProduct() {
		System.out.println("Product deleted");
	}
}
