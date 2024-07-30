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
    public void shouldRegisterSuccesfully(){
        registerPage.goToRegisterPage();

        registerPage.fillRegisterFilds("a@email.com", "Fulana", "senha123", "senha123");

        registerPage.submitRegiterForm();

        registerPage.getUserAcountFromScreen();

        Assertions.assertTrue(registerPage.successMessage());

        Assertions.assertEquals(registerPage.getUserAcountFromScreen(), registerPage.getAccountNumber());
        
        registerPage.closeModal(); 
    }
}
