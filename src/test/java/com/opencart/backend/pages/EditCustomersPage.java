package com.opencart.backend.pages;

import com.opencart.backend.model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomersPage extends BasePage {

  EditCustomersPage(WebDriver driver) {
    super(driver);
  }

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

  public EditCustomersPage fillCustomerDetailsForm(Customer customer) {
    firstNameLocator.sendKeys(customer.getFirstName());
    lastNameLocator.sendKeys(customer.getLastName());
    emailLocator.sendKeys(customer.getEmail());
    phoneLocator.sendKeys(customer.getPhone());
    passwordLocator.sendKeys(customer.getPassword());
    confirmLocator.sendKeys(customer.getPassword());
    return this;
  }

  public CustomersPage saveCustomer() {
    saveButton.click();
    return new CustomersPage(driver);
  }

}
