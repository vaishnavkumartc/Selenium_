package week2.saturday;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wdMethods.SeleniumMethods;

public class MergeLead {

	@Test
	public void mergeLead() throws InterruptedException {
		SeleniumMethods selObj = new SeleniumMethods();
		
		selObj.startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		selObj.typeWithoutSendKey(selObj.locateElement("id", "username"), "DemoSalesManager");
		selObj.typeWithoutSendKey(selObj.locateElement("id", "password"), "crmsfa");
		selObj.click(selObj.locateElement("class", "decorativeSubmit"));
		selObj.click(selObj.locateElement("PartialLinkText", "CRM/SFA"));
		selObj.click(selObj.locateElement("LinkText", "Leads"));
		
		selObj.click(selObj.locateElement("LinkText", "Merge Leads"));
		selObj.verifyDisplayed(selObj.locateElement("xpath", "//div[text()='Merge Leads']"));
		//from lead
		selObj.clickWithoutSnap(selObj.locateElement("xpath", "//img[@src='/images/fieldlookup.gif'][1]"));
		selObj.switchToWindow(1);
		selObj.type(selObj.locateElement("Name", "id"), "104");
		Thread.sleep(500);
		selObj.clickWithoutSnap(selObj.locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		selObj.switchToWindow(0);
		Thread.sleep(500);
		String fromLeadId = selObj.getAttributeText(selObj.locateElement("xpath", "//input[@name='ComboBox_partyIdFrom']"),"value");
		System.out.println("From Lead Id" + fromLeadId);
		//to lead
		selObj.clickWithoutSnap(selObj.locateElement("xpath", "(//img[@src='/images/fieldlookup.gif'])[2]"));
		selObj.switchToWindow(1);
		selObj.type(selObj.locateElement("Name", "id"), "102");
		Thread.sleep(500);
		selObj.clickWithoutSnap(selObj.locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		selObj.switchToWindow(0);
		Thread.sleep(500);
		String toLeadId = selObj.getAttributeText(selObj.locateElement("xpath", "//input[@name='ComboBox_partyIdFrom']"),"valuenow");
		System.out.println("to Lead Id" + toLeadId);
		selObj.clickWithoutSnap(selObj.locateElement("LinkText", "Merge"));
		Thread.sleep(500);
		//alert Handling
		String alertText = selObj.getAlertText();
		System.out.println(alertText);
		selObj.acceptAlert();
		selObj.click(selObj.locateElement("LinkText", "Find Leads"));
		selObj.type(selObj.locateElement("xpath", "(//label[text()='Lead ID:']/following::div/input)[1]"), fromLeadId);
		Thread.sleep(500);
		selObj.verifyDisplayed(selObj.locateElement("xpath", "//div[text()='No records to display']"));
		selObj.closeAllBrowsers();
	}
}
