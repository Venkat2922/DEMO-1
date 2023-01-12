package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTicket {
	public WebDriver driver;
	
	@FindBy(linkText = "Add Ticket")
	private WebElement addTicketTf;
	
	@FindBy(id="visitorname")
	private WebElement visitorNameTf;
	
	@FindBy(id = "noadult")
	private WebElement adultTf;
	
	@FindBy(id = "nochildren")
	private WebElement childrenTf;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	
	
	public AddTicket(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

	public WebElement getAddTicketTf() {
		return addTicketTf;
	}

	public WebElement getVisitorNameTf() {
		return visitorNameTf;
	}

	public WebElement getAdultTf() {
		return adultTf;
	}

	public WebElement getChildrenTf() {
		return childrenTf;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	

}
