package week2.saturday;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertFrames {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// adding implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img.png");
		FileUtils.copyFile(src, des);
		
		WebElement frame = driver.findElementById("iframeResult");
		driver.switchTo().frame(frame);
		//driver.switchTo().parentFrame();
		driver.findElementByXPath("//button[text()='Try it']").click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("TestLeaf");
		//String alertText = alert.getText();
		alert.accept();
		String outputText = driver.findElementById("demo").getText();
		System.out.println(outputText);
		driver.switchTo().frame(0);
		
		if(outputText.contains("TestLeaf")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		driver.close();
	}
}
