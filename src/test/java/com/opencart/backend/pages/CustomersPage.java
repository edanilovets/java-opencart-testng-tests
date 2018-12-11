package com.opencart.backend.pages;

import com.opencart.backend.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomersPage extends BasePage {

	CustomersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@data-original-title='Add New']")
	private WebElement addNewButton;
	@FindBy(xpath = "//button[@data-original-title='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@data-original-title='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//button[@data-original-title='Delete']")
	private WebElement deleteButton;

	//Fields
	@FindBy(id = "input-firstname")
	private WebElement firstNameLocator;
	@FindBy(id = "input-lastname")
	private WebElement lastNameLocator;
	@FindBy(id = "input-email")
	private WebElement emailLocator;
	@FindBy(id = "input-telephone")
	private WebElement phoneLocator;
	@FindBy(id = "input-password")
	private WebElement passwordLocator;
	@FindBy(id = "input-confirm")
	private WebElement confirmLocator;

	public CustomersPage addNewCustomer(Customer customer) {
		addNewButton.click();
		firstNameLocator.sendKeys(customer.getFirstName());
		lastNameLocator.sendKeys(customer.getLastName());
		emailLocator.sendKeys(customer.getEmail());
		phoneLocator.sendKeys(customer.getPhone());
		passwordLocator.sendKeys(customer.getPassword());
		confirmLocator.sendKeys(customer.getPassword());
		saveButton.click();
		return this;
	}

	public boolean isInCustomersList(Customer customer) {
		List<WebElement> lines = driver.findElements(By.cssSelector("#form-customer > table > tbody > tr"));
		for (WebElement element: lines){
			String email = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
			if (email.equals(customer.getEmail())){
				return true;
			}
		}
		return false;
	}
}
