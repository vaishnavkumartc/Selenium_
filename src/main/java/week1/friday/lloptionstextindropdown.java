package week1.friday;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lloptionstextindropdown {
	
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// adding implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		// explicit wait - WebDriverWait
		WebDriverWait wdWait = new WebDriverWait(driver, 10);

		WebElement signUp = driver.findElementByLinkText("Sign up");

		wdWait.until(ExpectedConditions.elementToBeClickable(signUp));

		signUp.click();
		Thread.sleep(500);
		driver.findElementById("userRegistrationForm:userName").sendKeys("Luna");

		//wdWait.until(ExpectedConditions.elementToBeClickable(userName));

		//userName.sendKeys("Luna");
		driver.findElementById("userRegistrationForm:password").sendKeys("Password00");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("Password00");
		WebElement securityQ = driver.findElementById("userRegistrationForm:securityQ");
		Select secdd = new Select(securityQ);
		secdd.selectByVisibleText("What is your fathers middle name?");
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Ram");
		WebElement prelang = driver.findElementById("userRegistrationForm:prelan");
		Select prelangdd = new Select(prelang);
		prelangdd.selectByVisibleText("हिन�?दी");
		driver.findElementById("userRegistrationForm:firstName").sendKeys("somename");
		driver.findElementById("userRegistrationForm:middleName").sendKeys("middlename");
		driver.findElementById("userRegistrationForm:lastName").sendKeys("lastname");
		// driver.findElementById("userRegistrationForm:gender").click();
		driver.findElementByXPath("//input[@type='radio' and @value='M']").click();
		driver.findElementByXPath("//input[@type='radio' and @value='U']").click();
		driver.findElementById("userRegistrationForm:dobDay").sendKeys("01");
		driver.findElementById("userRegistrationForm:dobMonth").sendKeys("MAY");
		driver.findElementById("userRegistrationForm:dateOfBirth").sendKeys("1996");
		WebElement occp = driver.findElementById("userRegistrationForm:occupation");
		Select occpdd = new Select(occp);

		List<WebElement> occpoptions = occpdd.getOptions();
		System.out.println(occpoptions.size());
		for(WebElement eachOption: occpoptions) {
			String text = eachOption.getText();
			System.out.println(text);
			
		}
	}
	

}
