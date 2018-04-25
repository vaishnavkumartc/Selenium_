package leaftapstestcases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SeleniumMethods implements WdMethods{
	int i =1;
	public RemoteWebDriver driver;
	public void startApp(String browser, String url) {
		try {
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equals("ff")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();				
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(url);
			takeSnap();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}catch(IllegalStateException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		WebElement webElement = null;
		try {
			switch(locator) {
			case "id":
				webElement = driver.findElementById(locValue);
				break;
			case "class":
				webElement = driver.findElementByClassName(locValue);
				break;
			case "PartialLinkText":
				webElement = driver.findElementByPartialLinkText(locValue);
				break;
			case "LinkText":
				webElement = driver.findElementByLinkText(locValue);
				break;
			case "Name":
				webElement = driver.findElementByName(locValue);
				break;
			case "xpath":
				webElement = driver.findElementByXPath(locValue);
				break;
			case "TagName":
				webElement = driver.findElementByTagName(locValue);
				break;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return webElement;

	}

	@Override
	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data,Keys.ENTER);
			takeSnap();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			takeSnap();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getText(WebElement ele) {
		//ele.getText();
		takeSnap();
		return ele.getText();
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByVisibleText(value);
			takeSnap();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByIndex(index);
			takeSnap();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		if(driver.getTitle().contains(expectedTitle)){
			return true;
		}else {
			takeSnap();
			return false;
		}
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().equals(expectedText)) {
				System.out.println("Text is matching");
			}else
				takeSnap();
			System.out.println("Text is not matching");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().contains(expectedText)) {
				System.out.println("Text contains " + expectedText);
			}else {
				takeSnap();
				System.out.println("Text does not contain " + expectedText);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).equals(value)) {
				System.out.println("The attribute value is matching");
			}else {
				takeSnap();
				System.out.println("The attribute value is not matching");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).contains(value)) {
				System.out.println("The attribute value is partially matching");
			}else {
				takeSnap();
				System.out.println("The attribute value is not matching partially too ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				System.out.println("Selected");
			}else {
				takeSnap();
				System.out.println("Not selected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				System.out.println(ele.getText() + " is displayed");
			}else {
				takeSnap();
				System.out.println(ele.getText() + " is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> setOfWindows = driver.getWindowHandles();
			List<String> listOfWindows = new ArrayList<String>();
			listOfWindows.addAll(setOfWindows);
			driver.switchTo().window(listOfWindows.get(index));
			takeSnap();
			System.out.println("Window switched successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			takeSnap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getAlertText() {
		String alertText = null;;
		try {
			alertText = driver.switchTo().alert().getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alertText;
	}

	@Override
	public void takeSnap() {

		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img" + i + ".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		//return des.getAbsolutePath().toString();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.close();

	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();

	}

	@Override
	public boolean verifySelected(String locator, String locatorValue) {
		WebElement locatedElement = locateElement(locator, locatorValue);
		if(locatedElement.isSelected()){
			return true;
		}else
			takeSnap();
		return false;
	}

	@Override
	public void clickWithoutSnap(WebElement ele) {
		ele.click();

	}

	@Override
	public void typeWithoutSendKey(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			takeSnap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getAttributeText(WebElement ele, String attributeName) {
		return ele.getAttribute(attributeName);
	}

	@Override
	public void extentPass(String TestName, String Testdesc, String stepdesc) throws IOException {
		
		String File = "./Reports/report.html";
		ExtentHtmlReporter html = new ExtentHtmlReporter(File);
		html.setAppendExisting(true);
		//to write on the created html file
		ExtentReports extents = new ExtentReports();
		extents.attachReporter(html);
		
		ExtentTest createAccountTest = extents.createTest(TestName, Testdesc);//before class
		createAccountTest.pass(stepdesc, MediaEntityBuilder.createScreenCaptureFromPath("./../snaps").build());
		extents.flush();
		// TODO Auto-generated method stub
		
	}
	
	/*@BeforeSuite
	public ExtentHtmlReporter createHtml() {
		String File = "./Reports/report.html";
		ExtentHtmlReporter html = new ExtentHtmlReporter(File);
		html.setAppendExisting(true);
		return html;
	}*/
	
	/*@BeforeMethod
	public ExtentReports writeHtml(ExtentHtmlReporter html) {
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		return extent;
	}*/
	
	//@AfterClass extent.flush
}