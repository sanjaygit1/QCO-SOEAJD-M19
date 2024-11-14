package TestNgPratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {

	@Test
	public void m1() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(false, false);
		System.out.println("Step3");
		System.out.println("Step4");
	}

	@Test
	public void m2() {
		int a = 1;
		int b = 10;
		Assert.assertEquals(a, b, "Not equals = ");
		System.out.println("It is Equal");
	}

	@Test
	public void m3() {
		int a = 10;
		int b = 1;
		Assert.assertNotEquals(a, b, "It is Equal =");
		System.out.println("Not Equal =");
	}

	@Test
	public void m4() {
		String s = "Hello";
		String s1 = "Hell";
		Assert.assertTrue(s.equalsIgnoreCase(s1), "False =");
		// System.out.println("True=");
	}

	@Test
	public void m5() {
		String s = "Hello";
		String s1 = "Hell";
		Assert.assertFalse(s.equalsIgnoreCase(s1), "Assert COntains");
		System.out.println("Assert not contains");

	}

	@Test
	public void m6() {
		String s = "Hi";
		Assert.assertNull(s, "it is not null");
		System.out.println("it is null");
	}

	@Test
	public void m7() {
		String s = null;
		Assert.assertNull(s, "it is not null");
		System.out.println("it is null");
	}

	@Test
	public void m8() {
		int a = 1;
		int b = 1;
		Assert.assertSame(a, b, "Not same");
		System.out.println("AssertSame");
}
	@Test
	public void m9()
	{
		int a=10;
		int b=20;
		Assert.assertNotSame(a, b, "Assert same");
		System.out.println("Assert not same");
	}
	
	@Test
	public void m10()
	{
	Assert.fail("Im failing the TestScript");
	}
}




