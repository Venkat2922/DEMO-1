package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	@FindBy(className = "ti-dashboard")
	private WebElement dashBoardModule;
	
	@FindBy(xpath = "Animals Details")
	private WebElement animalDetails;
	
	@FindBy(xpath = "//span[normalize-space(text())='Manage Type Ticket']")
	private WebElement managetypeTicket;
	
	
	@FindBy(xpath = "//span[normalize-space(text())='Normal Ticket']")
	private WebElement normalTicket;
	
	
	@FindBy(xpath = "//span[normalize-space(text())='Foreigners Ticket']")
	private WebElement foreignersTicket;
	
	@FindBy(xpath = "Page")
	private WebElement page;
	
	@FindBy(xpath = "//span[text()='Reports']")
	private WebElement reports;
	
	@FindBy(xpath = "Search")
	private WebElement search;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	public WebElement getDashBoardModule() {
		return dashBoardModule;
	}

	public WebElement getAnimalDetails() {
		return animalDetails;
	}

	public WebElement getManagetypeTicket() {
		return managetypeTicket;
	}

	public WebElement getNormalTicket() {
		return normalTicket;
	}

	public WebElement getForeignersTicket() {
		return foreignersTicket;
	}

	public WebElement getPage() {
		return page;
	}

	public WebElement getReports() {
		return reports;
	}

	public WebElement getSearch() {
		return search;
	}
	
	

}
