package com.opencart.backend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
  public WebDriver driver;

  BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "menu-catalog")
  private WebElement menuCatalog;
  @FindBy(xpath = "//*[@id=\"collapse1\"]/li[2]/a")
  private WebElement menuCatalogProducts;
  @FindBy(id = "menu-customer")
  private WebElement menuCustomer;
  @FindBy(xpath = "//*[@id=\"collapse33\"]/li[1]/a")
  private WebElement menuCustomerCustomer;
  @FindBy(css = "#header > div > ul > li.dropdown > a")
  private WebElement userLink;
  @FindBy(css = "#header > div > ul > li.dropdown.open > ul > li:nth-child(1) > a")
  private WebElement yourProfile;
  @FindBy(css = "#header > div > ul > li:nth-child(2) > a")
  private WebElement logout;

  //Admin Menu methods
  public ProductsPage openProductsPage(){
    menuCatalog.click();
    menuCatalogProducts.click();
    return new ProductsPage(driver);
  }
  public LoginPage logout(){
    logout.click();
    return new LoginPage(driver);
  }
}
