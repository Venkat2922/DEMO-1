package normalPeopleReports;

import static GenericUtility.PropertyFile.readDataFromPropertyFile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPageClass;
import objectRepository.NormalPeopleReportClass;

public class ReportsDatapresentOrNot {
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
		normalReport.getFromDate().sendKeys("10"+Keys.ENTER+"11"+Keys.ENTER+"2022");
		normalReport.getToDate().sendKeys("11"+Keys.ENTER+"01"+Keys.ENTER+"2023");
		normalReport.getSubmitButton().click();
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table text-center']/tbody/tr"));
		System.out.println(list.size());
		
		for(int i=1;i<=list.size();i++) {
			
			for(int j=1;j<=5;j++) {
			String value = driver.findElement(By.xpath("//table[@class='table text-center']/tbody["+i+"]/tr/td[3]")).getText();
			
			if(value.equals("rajnalla")) {
				System.out.println(value+" present in "+i+"row");
				break;
			}
			
		}
		
		
}
	}
}
