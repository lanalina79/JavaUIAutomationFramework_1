package online.opencart_automation;

import online.opencart_automation.managers.DataGeneratorManager;
import online.opencart_automation.managers.DriverManager;
import online.opencart_automation.pageobjects.AccountCreatedPage;
import online.opencart_automation.pageobjects.HomePage;
import online.opencart_automation.pageobjects.SignUpLoginPage;
import online.opencart_automation.pageobjects.SignUpPage;
import org.openqa.selenium.WebDriver;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        // DriverManager manager= DriverManager.getInstance();
        // WebDriver driver=manager.getDriver();
        //or

        WebDriver driver = DriverManager.getInstance().getDriver();

        //String currentTabName= driver.getWindowHandle();
        // Thread.sleep(5000);
        // driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://automationexercise.com/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToSignUpLoginPage();

        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
        signUpLoginPage.CompleteInitialDataSignUp(DataGeneratorManager.getRandomUsername(), DataGeneratorManager.getRandomEmail());

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.chooseGenderRadiobutton();
        signUpPage.completeFinalSignUpForm(DataGeneratorManager.getRandomPass(10,20), "Lanaaa", "Linaaa", "Lana@Co", "123457", "62086308208",
                "London", "NY", "Norton str3");

        signUpPage.chooseBirthdayDate("10", "January", "1990");
        signUpPage.chooseCountryFromDropdown("India");
        signUpPage.clickSignUpButton();

        Thread.sleep(5000);

        AccountCreatedPage accountCreatedPage =new AccountCreatedPage(driver);
        accountCreatedPage.clickContinueButton();
        Thread.sleep(5000);

        homePage =new HomePage(driver);
        homePage.logoutAction();



        driver.quit();
        System.out.println("The test is finished and the driver is closed");
    }


    //System.out.println("The current URL is "+driver.getCurrentUrl());
    //System.out.println("The title of the page is "+ driver.getTitle());

    //WebElement userDropdownIcon= driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
    //userDropdownIcon.click();

      /*  WebElement lockButton =driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        lockButton.click();*/

    //System.out.println("The current URL is "+driver.getCurrentUrl());
    //System.out.println("The title of the page is "+ driver.getTitle());

    /*driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver/4.43.0");*/
    //driver.close();
    // driver.switchTo().window(currentTabName);
    //driver.get("https://automationexercise.com/");

        /*System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource().contains("/logout"));

        driver.findElement(By.cssSelector("a[href='/logout']")).click();
        WebElement loginEmailAddressInputButton = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginEmailAddressInputButton.sendKeys(emailRandom);

        WebElement loginPassInputButton = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        loginPassInputButton.sendKeys(passRandom);

        BrowserUtils.safeClick(driver, By.cssSelector("button[data-qa='login-button']"));

        System.out.println("The current URL is "+driver.getCurrentUrl());
        System.out.println("The title of the page is "+ driver.getTitle());*/

}

