package leaftapstestcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class TestCreateAccount extends ProjectMethods {

	//@Test(invocationCount=2,groups="smoke")
	//@DisplayName
	@Test(dataProvider="fetchdata")
	public void createAccount(String AccountName,String Industry,String Currency,String DataSource,String Marketing,String Phone,String City,String Email,String Country,String State) throws InterruptedException {
		//login();
		//ExtentTest test = extent.createTest("TC001_CreateAccount", "CreateAccount");
		click(locateElement("LinkText", "Accounts"));
		//test.pass(details, provider);
		click(locateElement("LinkText", "Create Account"));
		verifyDisplayed(locateElement("id", "sectionHeaderTitle_accounts"));
		String randomAccntName = generateRandomString();
		typeWithoutSendKey(locateElement("id", "accountName"), AccountName);
		Thread.sleep(2000);
		selectDropDownUsingText(locateElement("Name", "industryEnumId"), Industry);
		selectDropDownUsingText(locateElement("id", "currencyUomId"), Currency);
		selectDropDownUsingText(locateElement("id", "dataSourceId"), DataSource);
		selectDropDownUsingText(locateElement("id", "marketingCampaignId"),Marketing);
		typeWithoutSendKey(locateElement("id", "primaryPhoneNumber"), Phone);
		typeWithoutSendKey(locateElement("id", "generalCity"), City);
		typeWithoutSendKey(locateElement("id", "primaryEmail"), Email);
		selectDropDownUsingText(locateElement("id", "generalCountryGeoId"), Country);
		Thread.sleep(500);
		selectDropDownUsingText(locateElement("id", "generalStateProvinceGeoId"), State);
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
	
}
