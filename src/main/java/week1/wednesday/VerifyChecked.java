package week1.wednesday;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyChecked {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/checkbox.html");
		
		boolean selected = driver.findElementByXPath("(//input[@type='checkbox'])[1]").isSelected();
		if(selected == true) {
			//driver.findElementByXPath("(//input[@type='checkbox'])[1]").click();
			System.out.println("the checkbox is selected");
		}else {
			System.out.println("the checkbox is not selected");
		}
		String attribute = driver.findElementByXPath("(//input[@type='checkbox'])[1]").getAttribute("type");
		driver.close();
		

	}

}
