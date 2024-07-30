package pages.register;

import java.time.Duration;
import java.util.function.BooleanSupplier;

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

    public boolean isRegisterDisplayed(){
        return driver.findElement(By.xpath("//form[@class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY']")).isDisplayed();
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
        return driver.getPageSource().contains("foi criada com sucesso");
        
        //return driver.findElement(By.xpath("//div[@class='styles__ContainerContent-sc-8zteav-1 cSdWPv']"));
        
    }

    public String getUserAcountFromScreen () {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));
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

	public void addBalance() {
		driver.findElement(By.xpath("//label[@class='styles__Container-sc-1pngcbh-0 kIwoPV']")).click();
	}

    public boolean backToLoginForm() {
        return driver.findElement(By.xpath("//form[@class='style__ContainerFormLogin-sc-1wbjw6k-0 eTrcYr']")).isDisplayed();
    }
    
    public boolean msgErrorRequiredFild() {
        return driver.getPageSource().contains("É campo obrigatório");

    }

    public boolean isDisplayedMsgErrorDifferentPasswords() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));
        return driver.getPageSource().contains("As senhas não são iguais.");

    }

    public boolean isDisplayedMsgErrorInvalidFormat() {
        return driver.getPageSource().contains("Formato inválido");

    }

    public boolean isDisplayedMsgErrorNameEmpty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));

        return driver.getPageSource().contains("Nome não pode ser vazio.");

    }

    
}
