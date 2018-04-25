package leaftapstestcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectMethods extends SeleniumMethods  {
	@Parameters ({"url","uname","pwd"})
	@BeforeMethod
	public void login(String url,String uname,String pwd) {
		startApp("chrome", url);
		typeWithoutSendKey(locateElement("id", "username"),uname);
		typeWithoutSendKey(locateElement("id", "password"),pwd);
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("PartialLinkText", "CRM/SFA"));
		//click(locateElement("LinkText", "Leads"));
	}
	
	public String generateRandomString() {
		int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    return generatedString;
	}
	
	@DataProvider(name="fetchdata")
	public Object[][] getdata() throws IOException{
		
		GetDataFromExcel data = new GetDataFromExcel();
		return data.getDataFromExcel();
		
	}
	
		

}

