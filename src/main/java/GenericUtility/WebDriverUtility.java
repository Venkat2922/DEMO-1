package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public  class WebDriverUtility {
	public WebDriver driver;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	
	}
	public  void maxiMize() {
		driver.manage().window().maximize();
	
	}
	
	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	

	public void alert() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}
}
