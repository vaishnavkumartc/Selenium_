package week2.saturday;

import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switchwindows {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// adding implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img.png");
		FileUtils.copyFile(src, des);
		
		driver.findElementByLinkText("Contact Us").click();
		
		Set<String> allWin = driver.getWindowHandles();
		
		ArrayList<String> windowsList = new ArrayList<>();
		
		windowsList.addAll(allWin);
		
		int size = windowsList.size();
		
		WebDriver secondWindow = driver.switchTo().window(windowsList.get(1));
		
		String titleOfSecondWindow = secondWindow.getTitle();
		
		System.out.println(titleOfSecondWindow);
		
		String faxNo = driver.findElementByXPath("//div[@class='content-ele']/p[2]").getText();
		
		System.out.println(faxNo);
		
		secondWindow.close();
		
		driver.switchTo().window(windowsList.get(0));
		
		driver.findElementById("usernameId").sendKeys("test");
		
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File des1 = new File("./snaps/img.png");
		FileUtils.copyFile(src1, des1);
		
		
		driver.close();
		
		
	}
}
