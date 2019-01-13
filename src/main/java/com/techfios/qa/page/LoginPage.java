package com.techfios.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.techfios.util.TestUtil;

public class LoginPage extends TestBase {

	// find all locators
	@FindBy(id = "username")
	WebElement un;
	@FindBy(id = "password")
	WebElement pw;
	@FindBy(name = "login")
	WebElement SignInBut;
	@FindBy(xpath = "//*[@class='logo']")
	WebElement logo;

	// contractor
	public LoginPage() {

		// pagefactory
		PageFactory.initElements(driver, this);
	}

	// validate login page
	public String validateLoginPage() {
		return driver.getTitle();
	}

	// We will use this boolean for assertion. To check if page is opened
	public boolean logo() {
		return logo.isDisplayed();
	}

	public HomePage login(String username, String password) {
		un.clear();
		un.sendKeys(username);
		pw.clear();
		pw.sendKeys(password);
		SignInBut.click();
		TestUtil.captureScreenshot(driver, "HomePage");
		return new HomePage();

	}

}
