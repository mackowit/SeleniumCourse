package testngtutorial;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNG_ITestResultDemo {

	@Test
	public void testMethod1() {
		System.out.println("Running test method 1");
		Assert.assertTrue(false);
	}

	@Test
	public void testMethod2() {
		System.out.println("Running test method 2");
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed: " + testResult.getMethod().getMethodName());
		}
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Passed: " + testResult.getName());
		}
	}

}
