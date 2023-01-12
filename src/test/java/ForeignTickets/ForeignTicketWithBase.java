package ForeignTickets;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static GenericUtility.Excelutility.*;
import GenericUtility.BaseClass;
import objectRepository.ForiegnTicket;
import objectRepository.HomePage;
import objectRepository.LoginPageClass;

public class ForeignTicketWithBase  extends BaseClass{
@Test
public void foreign() throws Throwable {
	
	HomePage hp =new HomePage(driver);
	hp.getForeignersTicket().click();
	ForiegnTicket fT=new ForiegnTicket(driver);
	fT.getfAddTicket().click();
	fT.getVisitorName().sendKeys(readDatafromExcelFile("Sheet1", 0, 0));
	fT.getAdult().sendKeys(readDatafromExcelFile("Sheet1", 0, 1));
	fT.getChildrens().sendKeys(readDatafromExcelFile("Sheet1", 0, 2));
	
	fT.getSubmitButton();
	//Alert alert=driver.switchTo().alert();
	//alert.accept();
}
	

}
