package leaftapstestcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReports {

	@Test
	public void extendReports() throws IOException {
		//to create a html file	
		String File = "./Reports/report.html";
		ExtentHtmlReporter html = new ExtentHtmlReporter(File);
		html.setAppendExisting(true);
		//to write on the created html file
		ExtentReports extents = new ExtentReports();
		extents.attachReporter(html);
		
		ExtentTest createAccountTest = extents.createTest("TC001", "CreateAccount");
		createAccountTest.pass("username entered", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img1.png").build());
		extents.flush();
		

	}

}
