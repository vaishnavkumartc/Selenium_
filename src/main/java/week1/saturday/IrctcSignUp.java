package week1.saturday;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrctcSignUp {

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
		for (WebElement occ : occpoptions) {
			System.out.println(occ.getText());
			if (occ.getText().equals("Private")) {
				occpdd.selectByVisibleText(occ.getText());
				break;
			} else {
				continue;
			}
		}
		driver.findElementById("userRegistrationForm:uidno").sendKeys("1234567890");
		driver.findElementById("userRegistrationForm:idno").sendKeys("xxxxxxxxxx");
		/*
		 * WebElement country =
		 * driver.findElementById("userRegistrationForm:countries"); Select countrydd =
		 * new Select(country); List<WebElement> countryOptions =
		 * countrydd.getOptions(); for (WebElement eachCountryOption : countryOptions)
		 * if (eachCountryOption.getText().equals("India")) {
		 * countrydd.selectByVisibleText(eachCountryOption.getText()); }
		 */
		WebElement country = driver.findElementById("userRegistrationForm:countries");
		Select countryDd = new Select(country);
		List<WebElement> options = countryDd.getOptions();
		List<WebElement> startsE = null;
		for (WebElement eachOptions : options) {
			// String optionText = allOptions.getText();
			// String optionText = allOptions.getText();
			if (eachOptions.getText().startsWith("E")) {
				System.out.println("happy");
				String attribute = eachOptions.getAttribute("index");
				System.out.println(attribute);
				countryDd.selectByIndex(Integer.parseInt(attribute)+1);
				break;
			}
			//countryDd.equals(startsE.get(1).getText());
			//countryDd.selectByVisibleText(startsE.get(1).getText());
			//countryDd.selectByIndex(0);
		}
		
		driver.findElementById("userRegistrationForm:email").sendKeys("hsdflkh@gmail.com");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9123456789");
		WebElement nationality = driver.findElementById("userRegistrationForm:nationalityId");
		Select nationalitydd = new Select(nationality);
		nationalitydd.selectByVisibleText("India");
		driver.findElementById("userRegistrationForm:address").sendKeys("address");
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600100", Keys.TAB);
		Thread.sleep(2000);
		WebElement cityName = driver.findElementById("userRegistrationForm:cityName");
		Select cityNamedd = new Select(cityName);
		cityNamedd.selectByVisibleText("Kanchipuram");
		Thread.sleep(2000);
		WebElement postOffice = driver.findElementById("userRegistrationForm:postofficeName");
		Select postOfficedd = new Select(postOffice);
		// postOfficedd.selectByVisibleText("Pallikaranai S.O");
		// postOfficedd.
		List<WebElement> postOptions = postOfficedd.getOptions();
		System.out.println(postOptions.size());
		for (WebElement posteach : postOptions) {
			System.out.println(posteach.getText());
			if (posteach.getText().contains("Medavakkam"))
				postOfficedd.selectByVisibleText(posteach.getText());

		}
		// postOfficedd.selectByValue("Medavakkam S.O");
		driver.findElementById("userRegistrationForm:landline").sendKeys("9087654321");
		driver.close();
	}

}
