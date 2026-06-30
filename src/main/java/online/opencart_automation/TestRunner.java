package online.opencart_automation;

import online.opencart_automation.managers.DataGeneratorManager;
import online.opencart_automation.managers.DriverManager;
import online.opencart_automation.utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
       // DriverManager manager= DriverManager.getInstance();
       // WebDriver driver=manager.getDriver();
        //or

        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName= driver.getWindowHandle();
       // Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://automationexercise.com/");
        System.out.println("The current URL is "+driver.getCurrentUrl());
        System.out.println("The title of the page is "+ driver.getTitle());

        //WebElement userDropdownIcon= driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        //userDropdownIcon.click();

        WebElement lockButton =driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        lockButton.click();

        System.out.println("The current URL is "+driver.getCurrentUrl());
        System.out.println("The title of the page is "+ driver.getTitle());

        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        String userNameRandom = DataGeneratorManager.getRandomUsername();
        usernameInput.sendKeys(userNameRandom);

        System.out.println("The username is "+userNameRandom);

        WebElement emailInput=driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        String emailRandom=DataGeneratorManager.getRundomEmail();
        emailInput.sendKeys(emailRandom);
        System.out.println("email is "+emailRandom);

        BrowserUtils.safeClick(driver, By.cssSelector("button[data-qa='signup-button']"));
        //WebElement signUpButton=driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        //signUpButton.click();

        System.out.println("The current URL is "+driver.getCurrentUrl());
        System.out.println("The title of the page is "+ driver.getTitle());


        WebElement genderRadioButton =driver.findElement(By.id("id_gender2"));
        genderRadioButton.click();

        WebElement passButton =driver.findElement(By.id("password"));
        String passRandom = DataGeneratorManager.getRandomPass(10,15);
        passButton.sendKeys(passRandom);

        System.out.println("The pass is "+passRandom);

        WebElement birthDayInput=driver.findElement(By.id("days"));
        Select birthDateOfMonth= new Select(birthDayInput);
        birthDateOfMonth.selectByVisibleText("10");

        WebElement birthMonthInput=driver.findElement(By.id("months"));
        Select birthMonth= new Select(birthMonthInput);
        birthMonth.selectByVisibleText("January");

        WebElement birthYearInput=driver.findElement(By.id("years"));
        Select birthYear= new Select(birthYearInput);
        birthYear.selectByVisibleText("2000");


        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        firstNameInput.sendKeys("Helena");

        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        lastNameInput.sendKeys("Miren");

        WebElement companyInput = driver.findElement(By.id("company"));
        companyInput.sendKeys("Helen&Co");

        WebElement addressInput = driver.findElement(By.id("address1"));
        addressInput.sendKeys("Trafalgar str1");

        WebElement countryInput = driver.findElement(By.id("country"));
        Select countryDropdownSelect = new Select(countryInput);
        countryDropdownSelect.selectByVisibleText("United States");

        WebElement stateInput = driver.findElement(By.id("state"));
        stateInput.sendKeys("NW");

        WebElement cityInput = driver.findElement(By.id("city"));
        cityInput.sendKeys("New York");

        WebElement zipCodeInput = driver.findElement(By.id("zipcode"));
        zipCodeInput.sendKeys("NY34567");

        WebElement mobileNumberInput = driver.findElement(By.id("mobile_number"));
        mobileNumberInput.sendKeys("+12345678990");

        BrowserUtils.safeClick(driver,By.cssSelector("button[data-qa='create-account']"));
        //WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        //createAccountButton.click();

        System.out.println("The current URL is "+driver.getCurrentUrl());
        System.out.println("The title of the page is "+ driver.getTitle());

        /*driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver/4.43.0");*/
        driver.close();
        driver.switchTo().window(currentTabName);
        driver.get("https://automationexercise.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource().contains("/logout"));

        driver.findElement(By.cssSelector("a[href='/logout']")).click();
        WebElement loginEmailAddressInputButton = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginEmailAddressInputButton.sendKeys(emailRandom);

        WebElement loginPassInputButton = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        loginPassInputButton.sendKeys(passRandom);

        BrowserUtils.safeClick(driver, By.cssSelector("button[data-qa='login-button']"));

        System.out.println("The current URL is "+driver.getCurrentUrl());
        System.out.println("The title of the page is "+ driver.getTitle());



        driver.quit();


        System.out.println("The test is finished and the driver is closed");
    }

}