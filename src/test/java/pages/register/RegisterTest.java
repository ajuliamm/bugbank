package pages.register;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class RegisterTest {
    private RegisterPage registerPage;

    @BeforeEach
	public void setup() {
		this.registerPage = new RegisterPage();

	}

    @Test
    public void shouldRegisterSuccesfullyWithoutCash(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("a@email.com", "Fulana", "senha123", "senha123");

        registerPage.submitRegiterForm();

        registerPage.getUserAcountFromScreen();

        Assertions.assertTrue(registerPage.successMessage());

        Assertions.assertEquals(registerPage.getUserAcountFromScreen(), registerPage.getAccountNumber());
        
        registerPage.closeModal(); 

        Assertions.assertTrue(registerPage.backToLoginForm());
    }

    @Test
    public void shouldRegisterSuccesfullyWithCash(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("a@email.com", "Fulana", "senha123", "senha123");

        registerPage.addBalance();
        
        registerPage.submitRegiterForm();

        registerPage.getUserAcountFromScreen();

        Assertions.assertTrue(registerPage.successMessage());

        Assertions.assertEquals(registerPage.getUserAcountFromScreen(), registerPage.getAccountNumber());
        
        registerPage.closeModal(); 
        Assertions.assertTrue(registerPage.backToLoginForm());
    }

    @Test
    public void shouldNotRegisterWithoutEmail(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("", "Fulana", "12345678", "12345678");
        
        registerPage.submitRegiterForm();

        Assertions.assertTrue(registerPage.msgErrorRequiredFild());
        Assertions.assertTrue(registerPage.isRegisterDisplayed());
        
    }

    @Test
    public void shouldNotRegisterWithEmailInvalid(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("a@email", "Fulana", "12345678", "12345678");
        
        registerPage.submitRegiterForm();

        Assertions.assertTrue(registerPage.isDisplayedMsgErrorInvalidFormat());
        Assertions.assertTrue(registerPage.isRegisterDisplayed());

        
    }

    @Test
    public void shouldNotRegisterWithoutPassword(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("a@email.com", "Fulana", "", "123456");
        
        registerPage.submitRegiterForm();

        Assertions.assertTrue(registerPage.msgErrorRequiredFild());
        Assertions.assertTrue(registerPage.isRegisterDisplayed());
        
    }
    @Test
    public void shouldNotRegisterWithoutConfirmationPassword(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("a@email.com", "Fulana", "123456", "");
        
        registerPage.submitRegiterForm();

        Assertions.assertTrue(registerPage.msgErrorRequiredFild());
        Assertions.assertTrue(registerPage.isRegisterDisplayed());

    }

    @Test
    public void shouldNotRegisterWithoutNameFilled(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("a@email.com", "", "123456", "123456");
        
        registerPage.submitRegiterForm();

        Assertions.assertTrue(registerPage.isDisplayedMsgErrorNameEmpty());
        Assertions.assertTrue(registerPage.isRegisterDisplayed());
        Assertions.assertFalse(registerPage.successMessage());

    }

    @Test
    public void shouldNotRegisterWithoutDiferentPasswords(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("a@email.com", "Fulana", "1234", "5678");
        
        registerPage.submitRegiterForm();

        Assertions.assertTrue(registerPage.isDisplayedMsgErrorDifferentPasswords());
        Assertions.assertTrue(registerPage.isRegisterDisplayed());
        


    }
}
