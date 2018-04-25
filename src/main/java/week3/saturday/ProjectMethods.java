package week3.saturday;

public class ProjectMethods extends SeleniumMethods  {

	public void login() {
		startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		typeWithoutSendKey(locateElement("id", "username"), "DemoSalesManager");
		typeWithoutSendKey(locateElement("id", "password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("PartialLinkText", "CRM/SFA"));
		click(locateElement("LinkText", "Leads"));
	}
}

