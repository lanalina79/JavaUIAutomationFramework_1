package online.opencart_automation;

import online.opencart_automation.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
       // DriverManager manager= DriverManager.getInstance();
       // WebDriver driver=manager.getDriver();
        //or

        WebDriver driver = DriverManager.getInstance().getDriver();
        String currentTabName= driver.getWindowHandle();
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver/4.43.0");
        driver.close();
        driver.switchTo().window(currentTabName);
        driver.get("https://ru.wikipedia.org/wiki/%D0%A2%D0%B5%D1%80%D0%BC%D0%B8%D0%BD%D0%B0%D1%82%D0%BE%D1%80_2:_%D0%A1%D1%83%D0%B4%D0%BD%D1%8B%D0%B9_%D0%B4%D0%B5%D0%BD%D1%8C");
        Thread.sleep(10000);
        driver.quit();


        System.out.println("The test is finished and the driver is closed");
    }

}