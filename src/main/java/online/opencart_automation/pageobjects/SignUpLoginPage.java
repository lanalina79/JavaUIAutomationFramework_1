package online.opencart_automation.pageobjects;

import online.opencart_automation.managers.DataGeneratorManager;
import online.opencart_automation.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpLoginPage extends Page {

    public SignUpLoginPage(WebDriver driver)
    {super(driver);}

    @FindBy (xpath = "//input[@placeholder='Name']")
    private WebElement usernameInput;

    @FindBy (css = "input[data-qa='signup-email']")
    private WebElement emailInput;

    public void CompleteInitialDataSignUp(String username, String email){
        usernameInput.sendKeys(username);
        emailInput.sendKeys(email);
        BrowserUtils.safeClick(driver,By.cssSelector("button[data-qa='signup-button']"));
        System.out.println("The form was populated with username "+ username +" and email " +email);
        System.out.println("The SignUp button was clicked");
    }

    /*WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Name']"));
    String userNameRandom = DataGeneratorManager.getRandomUsername();
        usernameInput.sendKeys(userNameRandom);

        System.out.println("The username is "+userNameRandom);

    WebElement emailInput=driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
    String emailRandom=DataGeneratorManager.getRundomEmail();
        emailInput.sendKeys(emailRandom);
        System.out.println("email is "+emailRandom);

        BrowserUtils.safeClick(driver, By.cssSelector("button[data-qa='signup-button']"));
    //WebElement signUpButton=driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
    //signUpButton.click();*/



}
