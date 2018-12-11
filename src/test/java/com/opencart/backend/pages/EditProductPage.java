package com.opencart.backend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProductPage extends BasePage {

    EditProductPage(WebDriver driver) {
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

    //Tabs
    @FindBy(css = "#form-product > ul > li:nth-child(2) > a")
    private WebElement tabData;
    @FindBy(css = "#form-product > ul > li:nth-child(9) > a")
    private WebElement tabImage;

    //Fields
    @FindBy(id = "input-name1")
    private WebElement productName;
    @FindBy(id = "input-meta-title1")
    private WebElement metaTagTitle;
    @FindBy(id = "input-model")
    private WebElement productModel;

    public ProductsPage cancelProductEditing() {
        cancelButton.click();
        return new ProductsPage(driver);
    }

    public ProductsPage saveProduct() {
        saveButton.click();
        return new ProductsPage(driver);
    }

    public EditProductPage enterProductName(String name){
        productName.sendKeys(name);
        return this;
    }

    public EditProductPage clearProductName(){
        productName.clear();
        return this;
    }

    public EditProductPage enterMetaTagTitle(String metaTag){
        metaTagTitle.sendKeys(metaTag);
        return this;
    }

    public EditProductPage enterProductModel(String model){
        productModel.sendKeys(model);
        return this;
    }

    public EditProductPage activateDataTab(){
        tabData.click();
        return this;
    }

    public EditProductPage activateImageTab(){
        tabImage.click();
        return this;
    }

}
