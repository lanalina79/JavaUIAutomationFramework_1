package online.opencart_automation.pageobjects;

import online.opencart_automation.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page {

    public AccountCreatedPage(WebDriver driver){
        super(driver);
    }

    public void clickContinueButton(){
        BrowserUtils.safeClick(driver, By.xpath("//a[normalize-space()='Continue']") );
        System.out.println("Account is created, user is on Home page");

    }
}
