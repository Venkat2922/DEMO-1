package ForeignTickets;
import static GenericUtility.Excelutility.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static GenericUtility.PropertyFile.*;

import GenericUtility.Excelutility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ForiegnTicket;
import objectRepository.HomePage;
import objectRepository.LoginPageClass;

public class BookForeignTicketWithExcelFileTest {
	
	@Test(groups = "integration")
	public void ticketForeign() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wdu=new WebDriverUtility(driver);
		
		driver.get(readDataFromPropertyFile("url"));
		wdu.maxiMize();
		wdu.implicitlyWait();
		LoginPageClass lp=new LoginPageClass(driver);
		lp.getUserName().sendKeys(readDataFromPropertyFile("username"));
		lp.getPwd().sendKeys(readDataFromPropertyFile("pwd"));
		lp.getLoginButton().click();
		
		HomePage hP=new HomePage(driver);
		hP.getForeignersTicket().click();
		
		ForiegnTicket fTicket=new ForiegnTicket(driver);
		fTicket.getfAddTicket().click();
		
		fTicket.getVisitorName().sendKeys(readDatafromExcelFile("Sheet1", 0, 0));
		fTicket.getAdult().sendKeys(readDatafromExcelFile("Sheet1", 0, 1));
		fTicket.getChildrens().sendKeys(readDatafromExcelFile("Sheet1", 0, 1));
		fTicket.getSubmitButton();
		Thread.sleep(4000);
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		
		LoginPageClass loginPage=new LoginPageClass(driver);
		loginPage.getHomebutton().click();	
		loginPage.getAdminButton().click();
		loginPage.getLogoutButton().click();

		
	}

}
