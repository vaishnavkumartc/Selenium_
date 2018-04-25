package week2.friday;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// adding implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByPartialLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();

		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("//div[text()='Merge Leads']").isDisplayed();

		// from lead
		driver.findElementByXPath("//img[@src='/images/fieldlookup.gif'][1]").click();
		List<String> winhand = winhand(driver);
		WebDriver findLeadsWin = driver.switchTo().window(winhand.get(1));
		findLeadsWin.manage().window().maximize();
		findLeadsWin.findElement(By.name("id")).sendKeys("104", Keys.ENTER);
		Thread.sleep(500);
		findLeadsWin.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		//findLeadsWin.findElement(By.name("id")).sendKeys("104", Keys.ENTER);
		WebDriver defaultWin = driver.switchTo().window(winhand.get(0));
		Thread.sleep(500);
		String fromLead = defaultWin.findElement(By.id("ComboBox_partyIdFrom")).getText();
		System.out.println("from lead " + fromLead);
		// to lead
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
		List<String> winhand2 = winhand(driver);
		WebDriver toLeadWin = driver.switchTo().window(winhand2.get(1));
		toLeadWin.manage().window().maximize();
		findLeadsWin.findElement(By.name("id")).sendKeys("112", Keys.ENTER);
		Thread.sleep(500);
		findLeadsWin.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		WebDriver defaultWin2 = driver.switchTo().window(winhand2.get(0));
		String toLeadId = defaultWin2.findElement(By.id("ComboBox_partyIdTo")).getText();
		System.out.println("to lead id " + toLeadId);

		defaultWin2.findElement(By.linkText("Merge")).click();
		// alert handling
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		defaultWin2.findElement(By.linkText("Find Leads")).click();
		defaultWin2.findElement(By.xpath("(//label[text()='Lead ID:']/following::div/input)[1]")).sendKeys("10437",
				Keys.ENTER);
		Thread.sleep(500);
		defaultWin2.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		driver.close();
		
	}

	public static List<String> winhand(ChromeDriver driver) {

		Set<String> setOfWindows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>();
		listOfWindows.addAll(setOfWindows);
		return listOfWindows;

	}

}
