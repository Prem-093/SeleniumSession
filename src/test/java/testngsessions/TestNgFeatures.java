package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgFeatures {

	@BeforeSuite
	public void DBConnection() {
		System.out.println("BS-----db connection");

	}

	@BeforeTest
	public void createuser() {
		System.out.println("BT-------Create user");
	}

	@BeforeClass

	public void openBrowser() {
		System.out.println("BC----Open Browser");

	}

	@BeforeMethod

	public void brforeMethod() {
		System.out.println("BM------Login to APP");
	}

	@Test
	public void searchText() {
		System.out.println("Text is getting eneter SearchPage ");
	}

	@Test
	public void addToCart() {
		System.out.println("Add to cart");
	}

	@Test
	public void paymentPay() {
		System.out.println("Payment method working fine");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("BM------Logout to APP");
	}

	@AfterClass

	public void closedBrowser() {
		System.out.println("BC----Closed Browser");

	}

	@AfterTest
	public void Deleteeuser() {
		System.out.println("BT-------Delete user");
	}

	@AfterSuite
	public void closeDBConnection() {
		System.out.println("BS-----close connection");

	}

}
