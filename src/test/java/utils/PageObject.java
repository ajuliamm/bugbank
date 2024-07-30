package utils;

import java.time.Duration;

import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {

        protected WebDriver driver; 
        protected WebDriverWait wait;

        protected Object UserDataLocalStorage; 

        protected String name;
        protected String email;
        protected String password;
        protected String accountNumber;
        protected String balance; 
        protected boolean logged;

        public PageObject(WebDriver driver){
                if(driver == null){
                        this.driver = new ChromeDriver();

                } else {

                        this.driver = driver; 
                }
                this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        }


        public void createLocalStorage(String key) {

                // Executa o JavaScript para obter o item do localStorage
                JavascriptExecutor js = (JavascriptExecutor) driver;
                String jsonString = (String) js.executeScript("return localStorage.getItem(arguments[0]);", key);

                if (jsonString != null && !jsonString.isEmpty()) {
                // Processa o JSON retornado
                JSONObject jsonObject = new JSONObject(jsonString);

                // Extraí os dados do JSON e armazena nos atributos da classe
                this.name = jsonObject.optString("name");
                this.email = jsonObject.optString("email");
                this.password = jsonObject.optString("password");
                this.accountNumber = jsonObject.optString("accountNumber");
                this.balance = jsonObject.optString("balance");
                this.logged = jsonObject.optBoolean("logged");


                // Exibe os dados para depuração
                System.out.println("Name: " + this.name);
                System.out.println("Email: " + this.email);
                System.out.println("Password: " + this.password);
                System.out.println("Account Number: " + this.accountNumber);
                System.out.println("Balance: " + this.balance);
                System.out.println("Logged: " + this.logged);
                } else {
                System.out.println("No data found in localStorage for the key: " + key);
                }
        }

        public String getAccountNumber() {
                return accountNumber;
        }

        



}
