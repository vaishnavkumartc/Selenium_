package leaftapstestcases;

import org.testng.annotations.Test;

public class DeactivateAccount extends ProjectMethods {
	@Test(groups="sanity",dependsOnMethods="leaftapstestcases.CreateAccount.createAccount")
	public void deactivateAccount() throws InterruptedException {

		click(locateElement("LinkText", "Accounts"));
		click(locateElement("LinkText", "Find Accounts"));
		type(locateElement("xpath", "//label[text()='Account ID:']/following::div/input[@name='id']"), "123");
		Thread.sleep(500);
		String accntId = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		verifyDisplayed(locateElement("id", "sectionHeaderTitle_accounts"));
		clickWithoutSnap(locateElement("LinkText", "Deactivate Account"));
		acceptAlert();
		String actualWarning = getText(locateElement("class", "subSectionWarning"));
		if(actualWarning.contains("This account was deactivated as of ")) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
		click(locateElement("LinkText", "Find Accounts"));
		type(locateElement("xpath", "//label[text()='Account ID:']/following::div/input[@name='id']"), accntId);
		String recrdnotfnd = getText(locateElement("xpath", "//div[@class='x-toolbar x-small-editor']/div"));
		if(recrdnotfnd.contains("No records to display")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}
}
