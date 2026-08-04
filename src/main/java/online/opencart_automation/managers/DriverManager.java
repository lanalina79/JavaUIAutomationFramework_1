package online.opencart_automation.managers;

import com.google.common.base.Equivalence;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome driver was initiated");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge driver was initiated");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari driver was initiated");
                break;
            default:
                System.out.println("The WebDriverType "+webDriverType+" is not defined");
        }
        driver.manage().window().maximize();
    }

    public static DriverManager getInstance()
    {if (instance ==null){
        instance= new DriverManager();
    }
    return instance;}

    public WebDriver getDriver(){
        if (driver==null)
        {getInstance();}
        return driver;
    }

    public void tearDownForDriver(){
        driver.quit();
        driver=null;
        instance=null;
        System.out.println("The driver was reset to null as instance was");
    }


}
