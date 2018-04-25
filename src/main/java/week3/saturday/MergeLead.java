package week3.saturday;

import org.junit.Test;

import wdMethods.SeleniumMethods;

public class MergeLead extends ProjectMethods {

	@Test
	public void mergeLead() throws InterruptedException {
		//http://leaftaps.com/opentaps/control/main
		login();
		click(locateElement("LinkText", "Merge Leads"));
		verifyDisplayed(locateElement("xpath", "//div[text()='Merge Leads']"));
		//from lead
		clickWithoutSnap(locateElement("xpath", "//img[@src='/images/fieldlookup.gif'][1]"));
		switchToWindow(1);
		type(locateElement("Name", "id"), "104");
		Thread.sleep(500);
		clickWithoutSnap(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		switchToWindow(0);
		Thread.sleep(500);
		String fromLeadId = getAttributeText(locateElement("xpath", "//input[@name='ComboBox_partyIdFrom']"),"value");
		System.out.println("From Lead Id " + fromLeadId);
		//to lead
		clickWithoutSnap(locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[2]"));
		switchToWindow(1);
		type(locateElement("Name", "id"), "102");
		Thread.sleep(500);
		clickWithoutSnap(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		switchToWindow(0);
		Thread.sleep(500);
		String toLeadId = getAttributeText(locateElement("xpath", "//input[@name='ComboBox_partyIdFrom']"),"valuenow");
		System.out.println("to Lead Id " + toLeadId);
		clickWithoutSnap(locateElement("LinkText", "Merge"));
		Thread.sleep(500);
		//alert Handling
		String alertText = getAlertText();
		System.out.println(alertText);
		acceptAlert();
		click(locateElement("LinkText", "Find Leads"));
		type(locateElement("xpath", "(//label[text()='Lead ID:']/following::div/input)[1]"), fromLeadId);
		Thread.sleep(500);
		verifyDisplayed(locateElement("xpath", "//div[text()='No records to display']"));
		closeAllBrowsers();
	}
}
