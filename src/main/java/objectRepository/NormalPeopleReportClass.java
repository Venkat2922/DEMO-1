package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NormalPeopleReportClass {
	public WebDriver driver;
	
	@FindBy(linkText = "Normal People Report")
	private WebElement normalPeopleReportButton;
	
	@FindBy(id = "fromdate")
	private WebElement  fromDate;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	
	
	
	@FindBy(id = "todate")
	private WebElement toDate;
	
	public NormalPeopleReportClass(WebDriver driver) {
    this.driver=driver;
PageFactory.initElements(driver, this);
	}

	public WebElement getNormalPeopleReportButton() {
		return normalPeopleReportButton;
	}

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getToDate() {
		return toDate;
	}

	
	
}
