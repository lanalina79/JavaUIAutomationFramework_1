package online.opencart_automation.pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page{

    public HomePage(WebDriver driver){
        super(driver);
        //acest driver sa fie pasat catre clasa parinte superioare prin cuv cheie 'super'
    }
}
