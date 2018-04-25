package week2.sunday;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import wdMethods.SeleniumMethods;

public class erail{
	@Test
	public void table() {
		SeleniumMethods selObj = new SeleniumMethods();
		selObj.startApp("chrome", "https://erail.in/");
		selObj.type(selObj.locateElement("id", "txtStationFrom"), "MS");
		selObj.type(selObj.locateElement("id", "txtStationTo"), "SBC");
		selObj.verifySelected(selObj.locateElement("id", "chkSelectDateOnly"));
		boolean verifyCheckboxSelected = selObj.verifySelected("id", "chkSelectDateOnly");	
		if(verifyCheckboxSelected==true)
			selObj.click(selObj.locateElement("id", "chkSelectDateOnly"));
		//selObj.click(selObj.locateElement("id", "chkSelectDateOnly"));
		WebElement trainListTable = selObj.locateElement("xpath", "//table[@class='DataTable TrainList']");
		List<WebElement> rows = trainListTable.findElements(By.tagName("tr"));
		int rowsize = rows.size();
		for(int i=0;i<rowsize;i++) {
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			//int columnsize = columns.size();
			WebElement trainNameEle = columns.get(1);
			String trainName = selObj.getText(trainNameEle);
			System.out.println(trainName);
		}
		selObj.closeBrowser();
		
		

	}	
}


