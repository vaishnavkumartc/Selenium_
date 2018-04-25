package week3.Monday;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckPassword {

	//@Test
	public void checkPass() {

		//1. get the input

		Scanner scan = new Scanner(System.in);

		String inputString = scan.nextLine();

		boolean valid = isValid (inputString);

		if (valid) System.out.println("pass");
		else System.out.println("Fail");
	}

	//2. initialize variables and methods

	public static boolean isValid(String password){

		if(password.length() < 10) return false;

		int charCount = 0;
		int numCount = 0;
		int capCount = 0;

		for(int i = 0; i< password.length(); i++){

			char ch = password.charAt(i);

			if(isNumeric(ch)) numCount++;

			else if(isLetter(ch)) { 
				charCount++; 
				if(isCapital(ch)) capCount++;
				}
			
			//else if(isCapital(ch)) capCount++;

			else return false;

		}

		return (charCount >=2 && numCount >=2 && capCount >=1);

	}

	public static boolean isNumeric(char ch){

		return (ch >= '0' && ch <= '9');

	}

	public static boolean isLetter(char ch){

		ch = Character.toUpperCase(ch);

		return (ch >='A' && ch<= 'Z'); 

	}
	
	public static boolean isCapital(char ch) {
		boolean isUpper = Character.isUpperCase(ch);
		return isUpper;
	}
	
	public static boolean getUrlrespCode(String url) throws IOException {
		
		//String url = "https://threejs.org/examples/webgl_objconvert_test.html";
		
		HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
		
		connection.setRequestMethod("HEAD");
		
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		
		if(responseCode >=400) return true;
		else return false;
		
	}


@Test
public  void brokenLinks() throws MalformedURLException, IOException {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://www.google.co.in");
	
	driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Level3", Keys.ENTER);
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	for(WebElement eachLink:links) {
		String eachUrl = eachLink.getAttribute("href");
		boolean urlrespCode = getUrlrespCode(eachUrl);
		if (urlrespCode) System.out.println("bad link");
		else System.out.println("good link");
	}
	driver.quit();
}

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


