package zooMgmt;

import java.time.Duration;
import static GenericUtility.PropertyFile.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPageClass;

public class AddVisitorOneTest {
	
	@Test(groups = "smoke")
	public void addVisitor() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(readDataFromPropertyFile("url"));
		
		LoginPageClass loginPage=new LoginPageClass(driver);
		loginPage.getUserName().sendKeys(readDataFromPropertyFile("username"));
		loginPage.getPwd().sendKeys(readDataFromPropertyFile("pwd"));
		loginPage.getLoginButton().click();
		
				
	}

}
