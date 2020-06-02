package test_cases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import common_actions.CommonFunctions;
import page_objects.Dashboard_PageObjects;
import page_objects.Login_PageObjects;

public class Test_PendingLeaveRequest extends CommonFunctions {

	String actualmessage = null;
	static Logger logger = Logger.getLogger(Test_PendingLeaveRequest.class);

	public void login() {

		logger.info("Logging to the application");
		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.username.sendKeys(properties.getProperty("username"));
		Login_PageObjects.password.sendKeys(properties.getProperty("password"));
		Login_PageObjects.LoginButton.click();

	}

	public void PendingLeaveRequests() {
		
		logger.info("Getting Pending Leave Requests...");
		PageFactory.initElements(driver, Dashboard_PageObjects.class);
		actualmessage = Dashboard_PageObjects.PendingLeaveRequest.getText();
	}

	@Test
	public void verifyPendingLeaveRequests() throws InterruptedException {
		logger.info("Verifcation PLR");
		login();
		PendingLeaveRequests();
		Assert.assertEquals(actualmessage, "No Records are Available");
		Thread.sleep(2000);
		logger.info("End of PLR");

	}

}
