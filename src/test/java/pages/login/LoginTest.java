package pages.login;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.register.RegisterPage;


public class LoginTest {

	private LoginPage loginPage; 
	private RegisterPage registerPage;


	@BeforeEach
	public void setup() {
		this.registerPage = new RegisterPage();

		registerPage.goToRegisterPage();
        registerPage.fillRegisterFilds("a@email.com", "Fulana", "senha123", "senha123");
        registerPage.submitRegiterForm();
        this.loginPage =  registerPage.closeModal(); 

	}

	@Test
	public void shouldLoginWithValidData () {
		
		loginPage.fillLoginForm("a@email.com", "senha123");
		loginPage.submitLoginForm(); 
		loginPage.chhangeToHomePage();

		Assertions.assertFalse(loginPage.isLoginPage());
		Assertions.assertFalse(loginPage.isLoginPage());
	}	

	@Test
	public void shouldNotLoginWithNoData () {

		Assertions.assertTrue(loginPage.isLoginPage());
		
		loginPage.fillLoginForm("", "");
		loginPage.submitLoginForm(); 

		Assertions.assertTrue(loginPage.msgErrorRequiredFild());
		
		loginPage.fillLoginForm("", "123333");
		loginPage.submitLoginForm(); 

		Assertions.assertTrue(loginPage.msgErrorRequiredFild());
		Assertions.assertTrue(loginPage.isLoginPage());
	}	

	@Test
	public void shouldNotLoginWithInvalidUser () {
		
		loginPage.fillLoginForm("emailInexistente@e.com", "1234");
		loginPage.submitLoginForm(); 

		Assertions.assertTrue(loginPage.msgErrorInvalidUserOrPasswoord());
		Assertions.assertTrue(loginPage.isLoginPage());
	}
	
	@Test
	public void shouldNotLoginWithInvalidPassword () {
		
		loginPage.fillLoginForm("a@email.com", "1234ERRADA");
		loginPage.submitLoginForm(); 

		Assertions.assertTrue(loginPage.msgErrorInvalidUserOrPasswoord());
		Assertions.assertTrue(loginPage.isLoginPage());
	}
	

}