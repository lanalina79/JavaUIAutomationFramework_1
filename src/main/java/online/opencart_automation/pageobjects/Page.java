package online.opencart_automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//i[@class='fa fa-lock']")
    protected WebElement lockButton;
        //WebElement lockButton =driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        //lockButton.click();
    @FindBy(css = "header[id='header'] li:nth-child(1) a:nth-child(1)")
    protected WebElement home;

    @FindBy(css = "a[href='/logout']")
    protected WebElement logoutButton;

    public void navigateToSignUpLoginPage () {lockButton.click();
        System.out.println("The lock button was clicked");
    }

    public void navigateToHomePage(){
        home.click();
        System.out.println("The Home button was clicked");
    }

    public void logoutAction(){
        logoutButton.click();
        System.out.println("Logout button was clicked, user is logged out");
    }

    }
