package week3.saturday;

import org.testng.annotations.Test;

public class CreateLead extends ProjectMethods{
	@Test
	public void createLead() {
		
		login();
		click(locateElement("LinkText", "Create Lead"));
		typeWithoutSendKey(locateElement("id", "createLeadForm_companyName"),"TestLeaf");
		typeWithoutSendKey(locateElement("id", "createLeadForm_firstName"), "Test");
		typeWithoutSendKey(locateElement("id", "createLeadForm_lastName"), "Leaf");
		click(locateElement("Name", "submitButton"));
		String companyName = getText(locateElement("id", "viewLead_companyName_sp"));
		//System.out.println(companyName);
		verifyDisplayed(locateElement("id", "viewLead_companyName_sp"));
		closeBrowser();
		
	}
	

}
