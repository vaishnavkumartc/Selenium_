package leaftapstestcases;

import org.testng.annotations.Test;

public class EditAccount extends ProjectMethods{

	@Test(groups="smoke",dependsOnMethods="leaftapstestcases.CreateAccount.createAccount")
	public void editAccount() throws InterruptedException {
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
