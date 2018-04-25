package week1.sunday;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkEditLead {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// adding implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		// explicit wait - WebDriverWait
		//WebDriverWait wdWait = new WebDriverWait(driver, 10);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByPartialLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByXPath("//ul[@class='shortcuts']/li[3]").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("test");
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(1000);
		WebElement firstCell = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		//waitUntilElementIsClickable(driver, 10, firstCell);
		firstCell.click();
		driver.findElementByXPath("//title[text()='View Lead | opentaps CRM']").isDisplayed();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").getText();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("TestCompany");
		driver.findElementByXPath("(//input[@name='submitButton'])[1]").click();
		String changedCompanyName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		if(changedCompanyName.contains("TestCompany")) {
			System.out.println("Company name successfully changed");
		}else{System.out.println("company name not changed");}
		
		
		driver.close();
	}
	
	public static void waitUntilElementIsClickable(ChromeDriver driver, int seconds, WebElement element){
		
		WebDriverWait wdWait = new WebDriverWait(driver, seconds);
		wdWait.until(ExpectedConditions.elementToBeClickable(element));
		//wdWait.until(ExpectedConditions.visibilityOf(element));
	}

}
