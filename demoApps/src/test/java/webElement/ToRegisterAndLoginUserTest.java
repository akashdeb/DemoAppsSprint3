package webElement;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.BaseClass;
import pomRepo.LoginPage;
import pomRepo.RegisterPage;

public class ToRegisterAndLoginUserTest extends BaseClass {

	
	@Test(priority = 1)
	public void toResgisterUserTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String name = fUtils.fetchDataFromExcelSheet("commonData", 1, 0);
		String email = fUtils.fetchDataFromExcelSheet("commonData", 1, 1);
		String password = fUtils.fetchDataFromExcelSheet("commonData", 1, 2);

		RegisterPage register=new RegisterPage(driver);
		register.registerUser(name, email, password);
		
		Thread.sleep(2000);
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.verifyRegisterUser());
		System.out.println("Pass: the user has registered");
		
	}
	
	@Test(priority = 2)
	public void toLoginUserTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String email = fUtils.fetchDataFromExcelSheet("commonData", 1, 1);
		String password = fUtils.fetchDataFromExcelSheet("commonData", 1, 2);
		
		LoginPage login = new LoginPage(driver);
		login.loginUser(email, password);
		Thread.sleep(2000);
		Assert.assertTrue(login.verifyLoginUser());
		System.out.println("Pass: the user has Logged in");
	}
}
