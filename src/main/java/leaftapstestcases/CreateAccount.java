package leaftapstestcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class CreateAccount extends ProjectMethods {

	//@Test(invocationCount=2,groups="smoke")
	//@DisplayName
	@Test()
	public void createAccount() throws InterruptedException {
		//login();
		//ExtentTest test = extent.createTest("TC001_CreateAccount", "CreateAccount");
		click(locateElement("LinkText", "Accounts"));
		//test.pass(details, provider);
		click(locateElement("LinkText", "Create Account"));
		verifyDisplayed(locateElement("id", "sectionHeaderTitle_accounts"));
		String randomAccntName = generateRandomString();
		typeWithoutSendKey(locateElement("id", "accountName"), randomAccntName);
		Thread.sleep(2000);
		selectDropDownUsingText(locateElement("Name", "industryEnumId"), "Computer Hardware");
		selectDropDownUsingText(locateElement("id", "currencyUomId"), "INR - Indian Rupee");
		selectDropDownUsingText(locateElement("id", "dataSourceId"), "Direct Mail");
		selectDropDownUsingText(locateElement("id", "marketingCampaignId"), "Automobile");
		typeWithoutSendKey(locateElement("id", "primaryPhoneNumber"), "9894431418");
		typeWithoutSendKey(locateElement("id", "generalCity"), "Chennai");
		typeWithoutSendKey(locateElement("id", "primaryEmail"), "xyz@gmail.com");
		selectDropDownUsingText(locateElement("id", "generalCountryGeoId"), "India");
		Thread.sleep(500);
		selectDropDownUsingText(locateElement("id", "generalStateProvinceGeoId"), "TAMILNADU");
		click(locateElement("xpath", "//input[@class='smallSubmit']"));
		verifyDisplayed(locateElement("id", "sectionHeaderTitle_accounts"));
		String accountName = getText(locateElement("xpath", "(//span[text()='Account Name']/following::td/span[@class='tabletext'])[1]"));
		accountName = accountName.trim().substring(accountName.indexOf('(')+1, accountName.indexOf(')'));
		click(locateElement("LinkText", "Find Accounts"));
		type(locateElement("xpath", "//label[text()='Account ID:']/following::div/input[@name='id']"), accountName);
		Thread.sleep(500);
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		verifyPartialText(locateElement("xpath","(//span[text()='Account Name']/following::td/span[@class='tabletext'])[1]"), accountName);
	}
	
	@Test
	public void editAccount() throws InterruptedException {
		//login();
		click(locateElement("LinkText", "Accounts"));
		click(locateElement("LinkText", "Find Accounts"));
		type(locateElement("xpath", "//label[text()='Account ID:']/following::div/input[@name='id']"), "103");
		Thread.sleep(500);
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		verifyDisplayed(locateElement("id", "sectionHeaderTitle_accounts"));
		click(locateElement("LinkText", "Edit"));
		typeWithoutSendKey(locateElement("id", "accountName"), "changevaish");
		click(locateElement("xpath", "//input[@type='submit' and @value='Save']"));
		verifyPartialText(locateElement("xpath", "(//span[text()='Account Name']/following::td/span[@class='tabletext'])[1]"), "changevaish");
		
	}


}
