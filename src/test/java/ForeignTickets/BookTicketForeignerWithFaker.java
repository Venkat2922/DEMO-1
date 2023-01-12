package ForeignTickets;

import static GenericUtility.PropertyFile.*;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.FakerUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ForiegnTicket;
import objectRepository.HomePage;
import objectRepository.LoginPageClass;

public class BookTicketForeignerWithFaker {
	
	@Test(groups = "smoke")
	public void ForeignTicket_2() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(readDataFromPropertyFile("url"));
		LoginPageClass loginPage=new LoginPageClass(driver);
		loginPage.getUserName().sendKeys(readDataFromPropertyFile("username"));
		loginPage.getPwd().sendKeys(readDataFromPropertyFile("pwd"));
		loginPage.getLoginButton().click();
		
		HomePage hP=new HomePage(driver);
		hP.getForeignersTicket().click();
		
		ForiegnTicket fTicket=new ForiegnTicket(driver);
		fTicket.getfAddTicket().click();
		//TO PASS THE INPUT DATA BY FAKER UTILITY
		FakerUtility fake=new FakerUtility();
		
		fTicket.getVisitorName().sendKeys(fake.foreignName());
		fTicket.getAdult().sendKeys(fake.adults());
		fTicket.getChildrens().sendKeys(fake.childrens());
		fTicket.getSubmitButton();
		Thread.sleep(4000);
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		// FOR LOGOUT
		loginPage.getHomebutton().click();	
		loginPage.getAdminButton().click();
		loginPage.getLogoutButton().click();

}
}
