package pages.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.login.LoginPage;
import utils.PageObject;

public class RegisterPage extends PageObject{


    public RegisterPage() {
        super(null);
        this.driver.get("https://bugbank.netlify.app/");

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void goToRegisterPage(){
        driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();
    }

    public void fillRegisterFilds(String email, String name, String password, String passwordConfirmation) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY']")));
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);

        driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys(password);

        driver.findElement(By.xpath("//input[@name='passwordConfirmation']")).sendKeys(passwordConfirmation);

        this.email = email;
    }

    public void submitRegiterForm() {
        driver.findElement(By.xpath("//form[@class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY']")).submit();
        createLocalStorage(this.email);
    }

    public boolean successMessage() {
        
        return driver.findElement(By.xpath("//div[@class='styles__ContainerContent-sc-8zteav-1 cSdWPv']")).isDisplayed();
        
    }

    public String getUserAcountFromScreen () {

        String countCriatedMessage = driver.findElement(By.id("modalText")).getText();
        String countNumber = countCriatedMessage.split(" ")[2];
        System.out.println(countNumber);
        return countNumber;
    }

    public LoginPage closeModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='btnCloseModal']")));
        driver.findElement(By.xpath("//a[@id='btnCloseModal']")).click();
        return new LoginPage(driver);
    }
    

    
}
