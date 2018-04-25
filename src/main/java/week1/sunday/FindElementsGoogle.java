package week1.sunday;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsGoogle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		driver.findElementById("lst-ib").sendKeys("vaishnav");
		driver.findElementByName("btnK").click();
//		List<WebElement> vaishlist = driver.findElementsByXPath("//a[contains(text(),'kesavan')]");
		List<WebElement> findvaish = driver.findElementsByTagName("a");
		System.out.println(findvaish.size());
		for(WebElement objlnk:findvaish) {
			if(objlnk.getText().contains("vaishnav")){
				System.out.println(objlnk.getText());
			}
		}
		driver.close();
	}

}
