package week1.thursday;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserAndWebElementsVerification {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// adding implicit wait
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://leafground.com/");
		
		String title = driver.getTitle();
		
		if(title.contains("leaf")) {
			System.out.println("yes title contains leaf");
		}else
			System.out.println("no leaf in title");
		
		String currentUrl = driver.getCurrentUrl();
		
		System.out.println(currentUrl);
		
		String pageSource = driver.getPageSource();
		
		System.out.println(pageSource);
		
		String classs = driver.findElementByXPath("//a/h5[@class='wp-categories-title' and text()='Button']").getAttribute("class");
		
		System.out.println(classs);
		
		driver.findElementByXPath("//a/h5[@class='wp-categories-title' and text()='Button']").click();
		
		String cssValue = driver.findElementById("color").getCssValue("background-color");
		
		System.out.println(cssValue);
		
		String gettext = driver.findElementById("position").getText();
		
		System.out.println(gettext);
		
		Point location = driver.findElementById("position").getLocation();
		
		System.out.println(location);
		
		int height = driver.findElementById("position").getSize().getHeight();
		
		System.out.println(height);
		
		String tagName = driver.findElementById("position").getTagName();

		System.out.println(tagName);
		
		driver.findElementById("home").click();
		
		driver.findElementByXPath("//a[@href='pages/checkbox.html']").click();
		
		boolean displayed = driver.findElementByXPath("(//div[@class='example'])[1]/input[1]").isDisplayed();
		if(displayed==true)
		System.out.println("java checkbox is displayed");
		WebElement javaCheckBox = driver.findElementByXPath("(//div[@class='example'])[1]/input[1]");
		boolean selected = javaCheckBox.isSelected();
		if(selected==false)
			javaCheckBox.click();
		driver.close();	
		}
			
		
		
	}


