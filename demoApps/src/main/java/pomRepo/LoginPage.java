package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement emailTextField;
	
	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[text()='Registered successfully']")
	private WebElement registerSuccessfulMsg;
	
	@FindBy(xpath = "//div[text()='Signin successful']")
	private WebElement signinsuccessfulMsg;
	
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	public WebElement getRegisterSuccessfulMsg() {
		return registerSuccessfulMsg;
	}

	public WebElement getSigninsuccessfulMsg() {
		return signinsuccessfulMsg;
	}

	public void loginUser(String email, String password) {
		
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
	public boolean verifyRegisterUser() {
		return registerSuccessfulMsg.isDisplayed();
	}
	
	public boolean verifyLoginUser() {
		return signinsuccessfulMsg.isDisplayed();
	}

}
