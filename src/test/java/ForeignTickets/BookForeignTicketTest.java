package ForeignTickets;

import static GenericUtility.PropertyFile.*;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ForiegnTicket;
import objectRepository.HomePage;
import objectRepository.LoginPageClass;

public class BookForeignTicketTest {
	
	@Test(groups = "regression")
	public void ForeignTicket_1() throws Throwable {
		
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
			fTicket.getVisitorName().sendKeys("RAJU");
			fTicket.getAdult().sendKeys("10");
			fTicket.getChildrens().sendKeys("3");
			fTicket.getSubmitButton();
			
			Alert alert=driver.switchTo().alert();
			alert.accept();
			// FOR LOGOUT
			loginPage.getHomebutton().click();	
			loginPage.getAdminButton().click();
			loginPage.getLogoutButton().click();
			
			
			
			
			
	}

}
