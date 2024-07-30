package pages.login;

import java.time.Duration;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PageObject;

public class LoginPage extends PageObject{


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://bugbank.netlify.app/");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    }
    public void goToRegisterPage(){
        driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();
    }
    

    public boolean isLoginPage () {
        return driver.getCurrentUrl().equals("https://bugbank.netlify.app/");

    }


    public void fillLoginForm(String email, String password) {

        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys(email);

        driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys(password);
    }


    public void submitLoginForm() {
        driver.findElement(By.xpath("//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']")).submit();
    }

    public boolean chhangeToHomePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='home__ContainerInfos-sc-1auj767-4 hZrCpL']")));

        return driver.getCurrentUrl().equals("https://bugbank.netlify.app/home");
    }

    public boolean msgErrorRequiredFild() {
        return driver.getPageSource().contains("É campo obrigatório");
        // return driver.findElement(By.xpath("//p[@class='input__warging']")).getText().contains("É campo obrigatório");
    }
    public boolean msgErrorInvalidUserOrPasswoord() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='modalText']")));

        return driver.getPageSource().contains("Usuário ou senha inválido.");

    }


    


}
