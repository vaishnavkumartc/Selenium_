package leaftapstestcases;

import org.testng.annotations.Test;

public class MergeAccount extends ProjectMethods {

	@Test(groups="sanity",timeOut=20000)
	public void mergeAccount() throws InterruptedException {

		//login();
		click(locateElement("LinkText", "Accounts"));
		click(locateElement("LinkText", "Merge Accounts"));
		click(locateElement("xpath", "//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a"));
		switchToWindow(1);
		type(locateElement("Name", "id"), "12");
		Thread.sleep(500);
		String fromaccntId = getText(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		clickWithoutSnap(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		switchToWindow(0);
		click(locateElement("xpath", "//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a"));
		switchToWindow(1);
		type(locateElement("Name", "id"), "11");
		Thread.sleep(500);
		clickWithoutSnap(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		switchToWindow(0);
		clickWithoutSnap(locateElement("LinkText", "Merge"));
		//String alertText = getAlertText();
		acceptAlert();
		verifyDisplayed(locateElement("xpath", "//div[text()='Account Details']"));
		click(locateElement("LinkText", "Find Accounts"));
		type(locateElement("Name", "id"), fromaccntId);
		String recrdnotfnd = getText(locateElement("xpath", "//div[@class='x-toolbar x-small-editor']/div"));
		if(recrdnotfnd.contains("No records to display")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		//closeBrowser();
	}

}
