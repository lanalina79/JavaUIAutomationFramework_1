package online.opencart_automation;

import com.google.common.annotations.VisibleForTesting;
import online.opencart_automation.managers.DataGeneratorManager;
import online.opencart_automation.managers.DriverManager;
import online.opencart_automation.pageobjects.AccountCreatedPage;
import online.opencart_automation.pageobjects.HomePage;
import online.opencart_automation.pageobjects.SignUpLoginPage;
import online.opencart_automation.pageobjects.SignUpPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRegistrationFlowWithJUnit {

    static WebDriver driver;
    private static final String email = DataGeneratorManager.getRandomEmail();
    private static final String emptyEmail= "";
    HomePage homePage;
    SignUpLoginPage signUpLoginPage;

    @BeforeAll
    public static void executeOnceBeforeAllTests(){
        System.out.println("The test suite has been started!");
    }


    @BeforeEach
    public void executeTheCodeBeforeEachTest(){
        driver= DriverManager.getInstance().getDriver();
        driver.get("https://automationexercise.com/");

        homePage=new HomePage(driver);
        homePage.navigateToSignUpLoginPage();

        //signUpLoginPage=new SignUpLoginPage(driver);
        //signUpLoginPage.CompleteInitialDataSignUp(DataGeneratorManager.getRandomUsername(),email);


    }


@Test
@Disabled
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
    @Disabled
    @DisplayName("Unable to register a user with same email")
    public void registerWithInvalidData() throws InterruptedException {

        boolean isEmailErrorDisplayed =signUpLoginPage.getError();
        Assertions.assertTrue(isEmailErrorDisplayed,"The correct email is displayed");
    }


    @Test
    @DisplayName("Validate Error Message")

     public void RegisterWithEmptyEmailField() {
        signUpLoginPage=new SignUpLoginPage(driver);
        signUpLoginPage.CompleteInitialDataSignUp(DataGeneratorManager.getRandomUsername(),emptyEmail);


        String expectedErrorMessage = "Please fill out this field";
        String actualErrorMessage = driver.findElement(By.cssSelector("input[data-qa='signup-email']")).getAttribute("validationMessage");

        System.out.println("Expected: " + expectedErrorMessage);
        System.out.println("Actual: " + actualErrorMessage);

        Assertions.assertEquals(actualErrorMessage,expectedErrorMessage,"The actual error message is "+expectedErrorMessage);
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
