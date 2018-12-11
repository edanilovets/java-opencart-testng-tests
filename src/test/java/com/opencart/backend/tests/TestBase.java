package com.opencart.backend.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {
  public WebDriver driver;

  @BeforeClass
  public void init() {
    driver = new ChromeDriver();
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }


}
