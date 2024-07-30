package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Setup {
    private WebDriver driver; 

    public void inicializeSetup(WebDriver driverReceived){

        if(driverReceived == null){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            driver.get("https://bugbank.netlify.app/");
       }

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    
}
