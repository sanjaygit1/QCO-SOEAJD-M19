package TestNgPratice;

import org.testng.annotations.Test;

public class DependsOmMethodTest {

	@Test
	public void createProduct() {
		System.out.println("Product Created");
		
	}

	@Test(enabled = false)
	public void modifyProduct() {
		System.out.println("Product Modified");
	}

	@Test(invocationCount = 2)
	public void deleteProduct() {
		System.out.println("Product deleted");
	}
}
