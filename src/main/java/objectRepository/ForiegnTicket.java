package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForiegnTicket {
	
public WebDriver driver;

@FindBy(linkText = "Add Ticket")
private WebElement fAddTicket;

@FindBy(id = "visitorname")
private WebElement visitorName;

@FindBy(name = "noadult")
private WebElement Adult;


@FindBy(name = "nochildren")
private WebElement childrens;


@FindBy(name = "submit")
private WebElement submitButton;

public ForiegnTicket(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getfAddTicket() {
	return fAddTicket;
}

public WebElement getVisitorName() {
	return visitorName;
}

public WebElement getAdult() {
	return Adult;
}

public WebElement getChildrens() {
	return childrens;
}

public WebElement getSubmitButton() {
	return submitButton;
}

}


