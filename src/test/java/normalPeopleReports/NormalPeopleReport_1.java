package normalPeopleReports;

import static GenericUtility.PropertyFile.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPageClass;
import objectRepository.NormalPeopleReportClass;

public class NormalPeopleReport_1 {
	
	@Test
	public void normalReport() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(readDataFromPropertyFile("url"));
		WebDriverUtility wdu=new WebDriverUtility(driver);
		wdu.maxiMize();
		wdu.implicitlyWait();
		
		LoginPageClass lp=new LoginPageClass(driver);
		
		lp.getUserName().sendKeys(readDataFromPropertyFile("username"));
		lp.getPwd().sendKeys(readDataFromPropertyFile("pwd"));
		lp.getLoginButton().click();
		
		HomePage hp=new HomePage(driver);
		hp.getReports().click();
		
		NormalPeopleReportClass normalReport=new NormalPeopleReportClass(driver);
		normalReport.getNormalPeopleReportButton().click();
		normalReport.getFromDate().sendKeys("10-06-2022");
		normalReport.getToDate().sendKeys("11-01-2023");
		normalReport.getSubmitButton().click();
		
		
		
		LoginPageClass loginPage=new LoginPageClass(driver);
	
		loginPage.getHomebutton().click();	
		Thread.sleep(4000);
		loginPage.getAdminButton().click();
		loginPage.getLogoutButton().click();

	}

}
