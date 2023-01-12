package normalPeopleReports;
import static GenericUtility.Excelutility.*;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import objectRepository.AddTicket;
import objectRepository.HomePage;

public class NormalTicketWithbase_2 extends BaseClass {
	@Test
	public void normalTicket__2() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.getNormalTicket().click();
		AddTicket aT=new AddTicket(driver);
		aT.getAddTicketTf().click();
		aT.getVisitorNameTf().sendKeys(readDatafromExcelFile("Sheet1", 2, 0));
		aT.getAdultTf().sendKeys(readDatafromExcelFile("Sheet1", 2, 1));
		aT.getChildrenTf().sendKeys(readDatafromExcelFile("Sheet1", 2, 2));
		aT.getSubmitButton().click();
		Alert al=driver.switchTo().alert();
		al.accept();
		}
		}


