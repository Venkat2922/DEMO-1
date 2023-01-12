package GenericUtility;
import static GenericUtility.PropertyFile.*;

import java.io.IOException;

import org.checkerframework.checker.signature.qual.MethodDescriptor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.github.javafaker.Faker;
import com.github.javafaker.File;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPageClass;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	WebDriverUtility wdu;
	LoginPageClass lp;
	
	@BeforeSuite
	public void connectDB() {
		System.out.println("database connected");
	}
@AfterSuite
public void disConnectDb() {
	System.out.println("Database is disConected");
}


@BeforeClass
public void launchTheBrowser() throws Throwable {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(readDataFromPropertyFile("url"));
	wdu=new WebDriverUtility(driver);
	wdu.maxiMize();
	wdu.implicitlyWait();
	
}

@AfterClass
public void closeTheBrowser() {
	driver.close();
}

@BeforeMethod
public void LoginToApplication() throws Throwable {
	 lp=new LoginPageClass(driver);
	lp.getUserName().sendKeys(readDataFromPropertyFile("username"));
	lp.getPwd().sendKeys(readDataFromPropertyFile("pwd"));
	lp.getLoginButton().click();
	
}
@AfterMethod
public void logoutApplication() {
 lp=new LoginPageClass(driver);
	lp.getHomebutton().click();
	lp.getAdminButton().click();
	lp.getLogoutButton().click();
	
}
public static String takeScreenShot(String name) {
	TakesScreenshot ts=(TakesScreenshot)sdriver;
	java.io.File src=ts.getScreenshotAs(OutputType.FILE);
	String path="./ScreenShot/"+name+".PNG";
	java.io.File dest = new java.io.File(path);
	try {
		Files.copy(src, dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return path;
}

}
