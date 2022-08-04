package com.bobtail.pages;

import com.bobtail.setup.TestBase;
import com.bobtail.utalities.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {
    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, WaitUtils.elementWait);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);


    //Net Before Vat price input field locator
    @FindBy(css = "tr:nth-child(1) > td:nth-child(3) > input")
    WebElement vatPriceInput;

    //calculate button locator on the home page
    @FindBy(css = " td > input[type=image]")
    WebElement calculateBn;

    /*sales tax calculator button locator
    @FindBy(css = "fieldset > a")
    WebElement salesTaxCalLink;*/

    //sales tax calucalotor calculate button locator
    @FindBy(css = "input[type=image]")
    WebElement salesTaxCalBtn;

    //sales tax calucaltor link
    @FindBy(xpath = "//*[@id=\"content\"]/p[14]/a")
    WebElement saleCalLink;


    public void inputVatPrice(String vatPrice){
        wait.until(ExpectedConditions.elementToBeClickable(vatPriceInput));
        vatPriceInput.sendKeys(vatPrice);
    }
    public void clickOnCalculateButton(){
        wait.until(ExpectedConditions.elementToBeClickable(calculateBn)).click();
    }

    public void clickOnSalesTaxCalculator(){

        js.executeScript("arguments[0].scrollIntoView(true);", saleCalLink);
        wait.until(ExpectedConditions.elementToBeClickable(saleCalLink)).click();
    }

    public void clickOnSalesTaxCalculatorButton(){
        wait.until(ExpectedConditions.elementToBeClickable(salesTaxCalBtn)).click();
    }

}
