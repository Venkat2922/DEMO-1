package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	public WebDriver driver;
	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement pwd;
	
	@FindBy(id = "form_submit")
	private WebElement loginButton;
	
	@FindBy(linkText = "Home")
	private WebElement homebutton;
	
	@FindBy(xpath = "//h4[text()='Admin ']")
	private WebElement adminButton;
	
	@FindBy(linkText = "Log Out")
	private WebElement logoutButton;
	
	
	public LoginPageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		

	}


	public WebElement getHomebutton() {
		return homebutton;
	}


	public WebElement getAdminButton() {
		return adminButton;
	}


	public WebElement getLogoutButton() {
		return logoutButton;
	}


	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
