package online.opencart_automation;

import com.google.common.annotations.VisibleForTesting;
import online.opencart_automation.managers.DataGeneratorManager;
import online.opencart_automation.managers.DriverManager;
import online.opencart_automation.pageobjects.AccountCreatedPage;
import online.opencart_automation.pageobjects.HomePage;
import online.opencart_automation.pageobjects.SignUpLoginPage;
import online.opencart_automation.pageobjects.SignUpPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRegistrationFlowWithJUnit {

    static WebDriver driver;
    private static final String email = DataGeneratorManager.getRandomEmail();
    HomePage homePage;
    SignUpLoginPage signUpLoginPage;

    @BeforeAll
    public static void executeOnceBeforeAllTests(){
        System.out.println("Th test suite has been started!");
    }


    @BeforeEach
    public void executeTheCodeBeforeEachTest(){
        driver= DriverManager.getInstance().getDriver();
        driver.get("https://automationexercise.com/");

        homePage=new HomePage(driver);
        homePage.navigateToSignUpLoginPage();

        signUpLoginPage=new SignUpLoginPage(driver);
        signUpLoginPage.CompleteInitialDataSignUp(DataGeneratorManager.getRandomUsername(),email);


    }


@Test
//@Disabled
    @DisplayName("Successful Registration of user by using valid credentials")
    public void registerWithValidData() throws InterruptedException {

        SignUpPage signUpPage=new SignUpPage(driver);
    signUpPage.chooseGenderRadiobutton();
    signUpPage.completeFinalSignUpForm(DataGeneratorManager.getRandomPass(10,20), "Lanaaa", "Linaaa", "Lana@Co", "123457", "62086308208",
            "London", "NY", "Norton str3");
    signUpPage.chooseBirthdayDate("10", "January", "1990");
    signUpPage.chooseCountryFromDropdown("India");
    signUpPage.clickSignUpButton();

    Thread.sleep(3000);

    AccountCreatedPage accountCreatedPage=new AccountCreatedPage(driver);
    accountCreatedPage.clickContinueButton();

    Thread.sleep(1000);

    homePage =new HomePage(driver);

    Assertions.assertTrue(homePage.isLogoutButtonDisplayed(),"The logout button is displayed");
    homePage.logoutAction();

}


    @Test
    @DisplayName("Unable to register a user by using invalid password")
    public void registerWithInvalidData() throws InterruptedException {

        boolean isEmailErrorDisplayed =signUpLoginPage.getError();
        Assertions.assertTrue(isEmailErrorDisplayed,"The correct email is displayed");
    }
@AfterEach
public void executeScriptAfterEachTest(){
    DriverManager.getInstance().tearDownForDriver();
}

@AfterAll
    public static void executeAfterAllTests(){
    System.out.println("The test suite has been executed!");
}

}
