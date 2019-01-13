package com.techfios.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class ProductServicePage extends TestBase {

	// find all locators

	@FindBy(xpath = "//*[@id=\"side-menu\"]/li[6]/a/span[1]")
	WebElement Productnservices;
	@FindBy(xpath = "//*[@id=\"side-menu\"]/li[6]/ul/li[4]/a")
	WebElement NewService;

	@FindBy(id = "name")
	WebElement Name;
	@FindBy(id = "sales_price")
	WebElement SalePrice;
	@FindBy(id = "item_number")
	WebElement ItemNumber;
	@FindBy(id = "description")
	WebElement Description;
	@FindBy(id = "submit")
	WebElement submitBut;

	// contractor
	public ProductServicePage() {

		// pagefactory
		PageFactory.initElements(driver, this);
	}

	// validate login page
	public String validateHomePage() {
		return driver.getTitle();
	}

	public void newservice(String name, String salesprice, String itemnumber, String description) {
		Productnservices.click();
		// NewProduct.click();
		NewService.click();
		Name.clear();
		Name.sendKeys(name);
		SalePrice.clear();
		SalePrice.sendKeys(salesprice);
		ItemNumber.clear();
		ItemNumber.sendKeys(itemnumber);
		Description.clear();
		Description.sendKeys(description);
		submitBut.click();

	}

}
