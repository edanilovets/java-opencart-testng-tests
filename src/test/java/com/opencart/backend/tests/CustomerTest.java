package com.opencart.backend.tests;

import com.opencart.backend.model.Customer;
import com.opencart.backend.pages.CustomersPage;
import com.opencart.backend.pages.DashboardPage;
import com.opencart.backend.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.opencart.backend.model.CustomerRegistry.getCustomer;
import static com.opencart.backend.model.UserRegistry.getAdmin;

//todo: Implement assertions using database

public class CustomerTest extends TestBase {

  @Test(description = "Adding of New customer with only required fields")
  public void canAddNewCustomerWithOnlyRequiredData() {
    Customer customer = getCustomer();
    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    CustomersPage customersPage = dashboardPage
            .openCustomersPage()
            .clickAddNewCustomerButton()
            .fillCustomerDetailsFormRequired(customer)
            .saveCustomer();

    Assert.assertTrue(customersPage.isInCustomersList(customer));

  }

  @Test(description = "Adding of New customer with other data enabled")
  public void canAddNewCustomerWithOtherCustomerDataEnabled(){
    Customer customer = getCustomer();
    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    CustomersPage customersPage = dashboardPage
            .openCustomersPage()
            .clickAddNewCustomerButton()
            .fillCustomerDetailsFormRequired(customer)
            .setNewsletter("Enabled")
            .setStatus("Disabled")
            .setSafe("Yes")
            .saveCustomer();

    Assert.assertTrue(customersPage.isInCustomersList(customer));
  }

  @Test(description = "Adding of New customer with address form filled")
  public void canAddNewCustomerWithOneAddress(){
    Customer customer = getCustomer();
    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    CustomersPage customersPage = dashboardPage
            .openCustomersPage()
            .clickAddNewCustomerButton()
            .fillCustomerDetailsFormRequired(customer)
            .clickAddAddress()
            .fillCustomersAddressFormRequired(customer)
            .saveCustomer();

    Assert.assertTrue(customersPage.isInCustomersList(customer));

  }

}
