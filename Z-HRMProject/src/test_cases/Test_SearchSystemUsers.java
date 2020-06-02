package test_cases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import common_actions.CommonFunctions;
import page_objects.Users_PageObjects;

public class Test_SearchSystemUsers extends CommonFunctions {
	static Logger logger = Logger.getLogger(Test_SearchSystemUsers.class);

	public void navigatingToUsers() {
		logger.info("navigatingToUsers");
		Actions actions = new Actions(driver);
		actions.moveToElement(Users_PageObjects.Admin);
		actions.moveToElement(Users_PageObjects.UserManagement);
		actions.moveToElement(Users_PageObjects.Users);
		actions.click().build().perform();
	}

	public void SelectUserRole() {
		logger.info("Selecting the User Role");
		Select selectRole = new Select(Users_PageObjects.UserRole);
		selectRole.selectByIndex(1);
	}

	public void SelectStatus() {
		logger.info("Selecting the User status");
		Select selectStatus = new Select(Users_PageObjects.Status);
		selectStatus.selectByIndex(1);
	}

	public void verifyTestUserRole() {
		logger.info("Verifying test user roles");
		String actualtext = Users_PageObjects.UserRoleValue.getText();	
		Assert.assertEquals(actualtext, "Admin");

	}

	public void verifyTestStatus() {
		logger.info("Verifying test user status");
		String actualstatus = Users_PageObjects.UserStatusValue.getText();
		Assert.assertEquals(actualstatus, "Enabled");

	}

	@Test
	public void TestUserRole() {

		PageFactory.initElements(driver, Users_PageObjects.class);
		navigatingToUsers();
		// driver.navigate().refresh();
		SelectUserRole();
		SelectStatus();
		Users_PageObjects.SearchBtn.click();
		verifyTestUserRole();
		verifyTestStatus();
		

	}

}
