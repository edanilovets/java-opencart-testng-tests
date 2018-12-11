package com.opencart.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

class BasePage {
  WebDriver driver;

  BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public CategoryPage showAll(String linkText) {
    Actions action = new Actions(driver);
    WebElement mainMenu = driver.findElement(By.id("menu"));
    WebElement menuItem = mainMenu.findElement(By.linkText(linkText));
    action.moveToElement(menuItem).build().perform();
    WebElement subMenuItem = driver.findElement(By.linkText("Show All ".concat(linkText)));
    subMenuItem.click();
    return new CategoryPage(driver);
  }
}
