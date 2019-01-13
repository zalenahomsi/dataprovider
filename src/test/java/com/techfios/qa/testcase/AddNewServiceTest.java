package com.techfios.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.techfios.qa.page.HomePage;
import com.techfios.qa.page.LoginPage;
import com.techfios.qa.page.ProductServicePage;
import com.techfios.util.TestUtil;

public class AddNewServiceTest extends TestBase {

	// import all classes
	HomePage homepage;
	LoginPage loginpage;
	ProductServicePage addservices;
	TestUtil testutil;
	String sheetName = "service"; // excel file name

	// constructor

	public AddNewServiceTest() {

		super();
	}

// 
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();

		addservices = new ProductServicePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	/*
	 * @Test(priority = 1)
	 * 
	 * public void homePageTitle() { String title = addservices.validateHomePage();
	 * Assert.assertEquals(title, "Dashboard- TechFios Test Application - Billing");
	 * }
	 */
	@DataProvider(name = "userdata")
	public Object[][] userFormdata() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "userdata")
	public void newservice(String Name, String SalePrice, String ItemNumber, String Description) throws Exception {

		addservices.newservice(Name, SalePrice, ItemNumber, Description);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
