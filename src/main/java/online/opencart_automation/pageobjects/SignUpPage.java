package online.opencart_automation.pageobjects;

import online.opencart_automation.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends Page {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender2")
    private WebElement genderRadioButton;

    @FindBy(id = "password")
    private WebElement passButton;

    @FindBy(id = "days")
    private WebElement birthDayInput;

    @FindBy(id = "months")
    private WebElement birthMonthInput;

    @FindBy(id = "years")
    private WebElement birthYearInput;


    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "country")
    private WebElement countryInput;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipCodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    public void completeFinalSignUpForm(String password, String firstName, String lastName, String company,
                                        String zipcode, String mobileNumber, String city, String state, String address) {
        passButton.sendKeys(password);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        cityInput.sendKeys(city);
        addressInput.sendKeys(address);
        stateInput.sendKeys(state);
        zipCodeInput.sendKeys(zipcode);
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void chooseGenderRadiobutton() {
        genderRadioButton.click();
    }

    public void chooseBirthdayDate(String birthDate, String birthMonth, String birthYear) {
        Select birthDateOfMonth = new Select(birthDayInput);
        birthDateOfMonth.selectByVisibleText(birthDate);

        Select birthMonthDropdown = new Select(birthMonthInput);
        birthMonthDropdown.selectByVisibleText(birthMonth);

        Select birthYearDropdown = new Select(birthYearInput);
        birthYearDropdown.selectByVisibleText(birthYear);

        System.out.println("The date of birth is selected");


    }

    public void chooseCountryFromDropdown(String country){
        Select countryDropdownSelect = new Select(countryInput);
        countryDropdownSelect.selectByVisibleText(country);

        System.out.println("The country is selected");
    }

    public void clickSignUpButton(){
        BrowserUtils.safeClick(driver, By.cssSelector("button[data-qa='create-account']"));
        System.out.println("The SignUp button is clicked");
    }






    /*

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
     */
}
