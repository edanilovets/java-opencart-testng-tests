package com.opencart.backend.tests;

import com.opencart.backend.model.Customer;
import com.opencart.backend.pages.CustomersPage;
import com.opencart.backend.pages.DashboardPage;
import com.opencart.backend.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.opencart.backend.model.CustomerRegistry.getCustomer;
import static com.opencart.backend.model.UserRegistry.getAdmin;


public class CustomerTest extends TestBaseRemote {

  @Test(description = "Adding of New customer")
  public void canAddNewCustomer() {
    Customer customer = getCustomer();
    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    CustomersPage customersPage = dashboardPage.
            openCustomersPage()
            .clickAddNewCustomerButton()
            .fillCustomerDetailsForm(customer)
            .saveCustomer();

    Assert.assertTrue(customersPage.isInCustomersList(customer));

  }

}
