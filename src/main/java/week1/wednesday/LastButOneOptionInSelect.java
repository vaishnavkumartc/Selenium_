package week1.wednesday;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LastButOneOptionInSelect {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		WebElement dd1 = driver.findElementById("dropdown1");
		Select drop1 = new Select(dd1);
		List<WebElement> options = drop1.getOptions();
		int size = options.size();
		drop1.selectByIndex(size-2);
		
		driver.close();
		
		
	}

}
