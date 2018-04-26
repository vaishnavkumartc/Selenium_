package leaftapstestcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import edu.emory.mathcs.backport.java.util.Collections;

public class Flipkart {
	
	@Test
	public void flipkart() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com");
		driver.findElementByXPath("//button[text()='✕']").click();
		WebDriverWait wdwait = new WebDriverWait(driver, 10);
		WebElement loginLink = driver.findElementByLinkText("Login & Signup");
		wdwait.until(ExpectedConditions.visibilityOf(loginLink));
		driver.findElementByName("q").sendKeys("bags", Keys.ENTER);
		Thread.sleep(1000);
		List<WebElement> bags = driver.findElementsByClassName("_1vC4OE");
		List<String> bagPrice = new ArrayList<>();
		for (WebElement bag : bags) {
			bagPrice.add(bag.getText().replaceAll("[₹,]", ""));
		}
		Collections.sort(bagPrice);
		System.out.println(bagPrice);
		driver.close();;
	}
	
	

}
